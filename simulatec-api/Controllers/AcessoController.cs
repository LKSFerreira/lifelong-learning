using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using simulatec_api_app.Data;
using simulatec_api_app.Models;
using simulatec_api_app.Services;

namespace simulatec_api_app.Controllers
{
    [Authorize]
    [Route("api/[controller]")]
    [ApiController]
    public class AcessoController : ControllerBase
    {
        private readonly SimulatecDbContext _context = null!;

        private readonly IJWTAuthenticationManager _jwtAuthenticationManager;

        public AcessoController(IJWTAuthenticationManager jwtAuthenticationManager, SimulatecDbContext context)
        {
            _jwtAuthenticationManager = jwtAuthenticationManager;
            _context = context;
        }

        // GET: api/Acesso/Listar
        [HttpGet("Listar")]
        [Authorize(Roles = "admin")]
        public async Task<ActionResult<IEnumerable<Acesso>>> GetAcessos()
        {
            if (_context.Acessos == null)
            {
                return NotFound();
            }
            return await _context.Acessos.ToListAsync();
        }

        // GET: api/Acesso/Buscar/5
        [HttpGet("Buscar/{id}")]
        [Authorize(Roles = "admin")]
        public async Task<ActionResult<Acesso>> GetAcesso(string id)
        {
            if (_context.Acessos == null)
            {
                return NotFound();
            }
            var acesso = await _context.Acessos.FindAsync(id);

            if (acesso == null)
            {
                return NotFound();
            }

            if (acesso.Ativo == false)
            {
                return Unauthorized();
            }

            return acesso;
        }

        // PUT: api/Acesso/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("Alterar/{id}")]
        [Authorize(Roles = "admin")]
        public async Task<IActionResult> PutAcesso(string id, Acesso acesso)
        {
            if (id != acesso.Usuario)
            {
                return BadRequest();
            }

            _context.Entry(acesso).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AcessoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Acesso/Cadastrar
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [AllowAnonymous]
        [HttpPost("Cadastrar")]
        public async Task<ActionResult<Acesso>> PostAcesso([FromBody] Acesso acesso)
        {
            if (_context.Acessos == null)
            {
                return Problem("Entity set 'SimulatecDbContext.Acessos'  is null.");
            }
            _context.Acessos.Add(acesso);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (AcessoExists(acesso.Usuario))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetAcesso", new { id = acesso.Usuario }, acesso);
        }

        // DELETE: api/Acesso/Excluir/5
        [HttpDelete("Excluir/{id}")]
        [Authorize(Roles = "admin")]
        public async Task<IActionResult> DeleteAcesso(string id)
        {
            if (_context.Acessos == null)
            {
                return NotFound();
            }
            var acesso = await _context.Acessos.FindAsync(id);
            if (acesso == null)
            {
                return NotFound();
            }

            _context.Acessos.Remove(acesso);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        // AUTENTICA: api/Acesso/Autenticar
        [AllowAnonymous]
        [HttpPost("Autenticar")]
        public IActionResult Autenticar([FromBody] Acesso acesso)
        {
            if (acesso == null)
            {
                return NotFound();
            }

            var token = _jwtAuthenticationManager.Autenticar(acesso.Usuario, acesso.Senha);

            if (token == "Não foi possível autenticar o usuário")
            {
                return Unauthorized();
            }

            return Ok(token);
        }

        [HttpGet("ValidarToken")]
        public IActionResult Autenticado()
        {
            var jsonUsuario = new
            {
                Autenticado = User.Identity!.IsAuthenticated,
                Usuario = User.Identity!.Name,
                Role = User.Claims.FirstOrDefault(c => c.Type == ClaimTypes.Role)?.Value
            };
            return Ok(jsonUsuario);
        }

        private bool AcessoExists(string id)
        {
            return (_context.Acessos?.Any(e => e.Usuario == id)).GetValueOrDefault();
        }
    }
}
