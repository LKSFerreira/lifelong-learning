using System;
using System.Collections.Generic;

namespace simulatec_api_app.Models;

public partial class Pessoa
{
    public string Usuario { get; set; } = null!;

    public string Nome { get; set; } = null!;

    public string Cpf { get; set; } = null!;

    public string Email { get; set; } = null!;

    public string Telefone { get; set; } = null!;

    public DateTime Nascimento { get; set; }

    public string Role { get; set; } = null!;

    public string Validacao { get; set; } = null!;

    public bool Ativo { get; set; }

    public Pessoa()
    {
        Validacao = Usuario + Cpf + Nascimento.ToString("ddMMyyyy");
    }
}
