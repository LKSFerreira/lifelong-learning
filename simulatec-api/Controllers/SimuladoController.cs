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
    public class SimuladoController : ControllerBase
    {
        private readonly SimulatecDbContext _context;

        public SimuladoController(SimulatecDbContext context)
        {
            _context = context;
        }

        // GET: api/Simulado/Listar
        [AllowAnonymous]//[Authorize(Roles = "admin,cliente")]
        [HttpGet("Listar")]
        public async Task<ActionResult<IEnumerable<Simulado>>> GetSimulados()
        {
          if (_context.Simulados == null)
          {
              return NotFound();
          }
            return await _context.Simulados.ToListAsync();
        }

        // GET: api/Simulado/Buscar/5
        [Authorize(Roles = "admin,cliente")]
        [HttpGet("Buscar/{id}")]
        public async Task<ActionResult<Simulado>> GetSimulado(int id)
        {
          if (_context.Simulados == null)
          {
              return NotFound();
          }
            var simulado = await _context.Simulados.FindAsync(id);

            if (simulado == null)
            {
                return NotFound();
            }

            return simulado;
        }

        // PUT: api/Simulado/Atualizar/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [Authorize(Roles = "admin")]
        [HttpPut("Atualizar/{id}")]
        public async Task<IActionResult> PutSimulado(int id, Simulado simulado)
        {
            if (id != simulado.Id)
            {
                return BadRequest();
            }

            _context.Entry(simulado).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SimuladoExists(id))
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

        // POST: api/Simulado/Cadastrar
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [Authorize(Roles = "admin")]
        [HttpPost("Cadastrar")]
        public async Task<ActionResult<Simulado>> PostSimulado(Simulado simulado)
        {
          if (_context.Simulados == null)
          {
              return Problem("Entity set 'SimulatecDbContext.Simulados'  is null.");
          }
            _context.Simulados.Add(simulado);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetSimulado", new { id = simulado.Id }, simulado);
        }

        // DELETE: api/Simulado/Excluir/5
        [Authorize(Roles = "admin")]
        [HttpDelete("Excluir/{id}")]
        public async Task<IActionResult> DeleteSimulado(int id)
        {
            if (_context.Simulados == null)
            {
                return NotFound();
            }
            var simulado = await _context.Simulados.FindAsync(id);
            if (simulado == null)
            {
                return NotFound();
            }

            _context.Simulados.Remove(simulado);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool SimuladoExists(int id)
        {
            return (_context.Simulados?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
