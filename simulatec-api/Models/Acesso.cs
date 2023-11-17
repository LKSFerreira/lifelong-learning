using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace simulatec_api_app.Models;

public class Acesso
{

    public string Usuario { get; set; } = null!;
    
    public string Senha { get; set; } = null!;

    public bool Ativo { get; set; }
}
