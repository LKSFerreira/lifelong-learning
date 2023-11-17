using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.IdentityModel.Tokens;
using simulatec_api_app.Data;
using simulatec_api_app.Models;

namespace simulatec_api_app.Services;

public interface IJWTAuthenticationManager
{
    string Autenticar(string usuario, string senha);
}

public class JWTAuthenticationManager : IJWTAuthenticationManager
{
    private readonly string _tokenKey;
    private readonly SimulatecDbContext? _context;

    public JWTAuthenticationManager(string token, SimulatecDbContext context)
    {
        _tokenKey = token;
        _context = context;
    }

    public string Autenticar(string usuario, string senha)
    {
        // Verificar se o usuário existe dentro da context
        var user = _context.Acessos.FirstOrDefault(a => a.Usuario == usuario && a.Senha == senha);

        if (user == null || user.Ativo == false)
        {
            return "Não foi possível autenticar o usuário";
        }

        var tokenHandler = new JwtSecurityTokenHandler();

        var tokenKey = Encoding.ASCII.GetBytes(_tokenKey);

        var tokenDescriptor = new SecurityTokenDescriptor
        {
            Subject = new ClaimsIdentity(new Claim[]
            {
                new Claim(ClaimTypes.Name, user.Usuario),
                new Claim(ClaimTypes.Role, _context.Pessoas.FirstOrDefault(p => p.Usuario == user.Usuario)!.Role.ToString())
            }),
            Expires = DateTime.UtcNow.AddHours(24),
            SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(tokenKey), SecurityAlgorithms.HmacSha256Signature)
        };

        var token = tokenHandler.CreateToken(tokenDescriptor);
        return tokenHandler.WriteToken(token);
    }

}
