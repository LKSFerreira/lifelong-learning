using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace simulatec.Models;

public partial class Acesso
{

    public string Usuario { get; set; } = null!;
    public string Senha { get; set; } = null!;
    public bool Ativo { get; set; } = true;
}
