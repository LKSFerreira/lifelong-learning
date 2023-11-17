using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using simulatec_api_app.Data;
using simulatec_api_app.Models;

namespace simulatec_api_app.Controllers
{
    [Authorize]
    [Route("api/[controller]")]
    [ApiController]
    public class PessoaController : ControllerBase
    {
        private readonly SimulatecDbContext _context;

        public PessoaController(SimulatecDbContext context)
        {
            _context = context;
        }

        // GET: api/Pessoa/Listar
        [Authorize(Roles = "admin")]
        [HttpGet("Listar")]
        public async Task<ActionResult<IEnumerable<Pessoa>>> GetPessoas()
        {
            if (_context.Pessoas == null)
            {
                return NotFound();
            }
            return await _context.Pessoas.ToListAsync();
        }

        // GET: api/Pessoa/Buscar/5
        [Authorize(Roles = "admin")]
        [HttpGet("Buscar/{id}")]
        public async Task<ActionResult<Pessoa>> GetPessoa(string id)
        {
            if (_context.Pessoas == null)
            {
                return NotFound();
            }
            var pessoa = await _context.Pessoas.FindAsync(id);

            if (pessoa == null)
            {
                return NotFound();
            }

            return pessoa;
        }

        // PUT: api/Pessoa/Atualizar/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [Authorize(Roles = "admin")]
        [HttpPut("Atualizar/{id}")]
        public async Task<IActionResult> PutPessoa(string id, Pessoa pessoa)
        {
            if (id != pessoa.Usuario)
            {
                return BadRequest();
            }

            _context.Entry(pessoa).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PessoaExists(id))
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

        // POST: api/Pessoa/Cadastrar
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [AllowAnonymous]
        [HttpPost("Cadastrar")]
        public async Task<ActionResult<Pessoa>> PostPessoa([FromBody] Pessoa pessoa)
        {
            if (_context.Pessoas == null)
            {
                return Problem("Entity set 'SimulatecDbContext.Pessoas'  is null.");
            }
            _context.Pessoas.Add(pessoa);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (PessoaExists(pessoa.Usuario))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetPessoa", new { id = pessoa.Usuario }, pessoa);
        }

        // DELETE: api/Pessoa/Excluir/5
        [Authorize(Roles = "admin")]
        [HttpDelete("Excluir/{id}")]
        public async Task<IActionResult> DeletePessoa(string id)
        {
            if (_context.Pessoas == null)
            {
                return NotFound();
            }
            var pessoa = await _context.Pessoas.FindAsync(id);
            if (pessoa == null)
            {
                return NotFound();
            }

            _context.Pessoas.Remove(pessoa);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool PessoaExists(string id)
        {
            return (_context.Pessoas?.Any(e => e.Usuario == id)).GetValueOrDefault();
        }
    }
}
