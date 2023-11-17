using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace simulatec.Models;

public class Token
{
    [JsonPropertyName("autenticado")]
    public bool Autenticado { get; private set; }

    [JsonPropertyName("usuario")]
    public string Usuario { get; private set; } = null!;

    [JsonPropertyName("role")]
    public string Role { get; private set; } = null!;

    public Token(bool autenticado, string usuario, string role)
    {
        Autenticado = autenticado;
        Usuario = usuario;
        Role = role;
    }

}
