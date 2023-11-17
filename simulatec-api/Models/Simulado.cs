using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace simulatec_api_app.Models;

public partial class Simulado
{
    public int Id { get; set; }

    public string Questao { get; set; } = null!;

    public string? RespostaA { get; set; }

    public string? RespostaB { get; set; }

    public string? RespostaC { get; set; }

    public string? RespostaD { get; set; }

    public string? RespostaE { get; set; }

    public string? Correta { get; set; }

    public int Dificuldade { get; set; }

    public string Instituicao { get; set; } = null!;

    public int Ano { get; set; }

    public string Area { get; set; } = null!;

    public string Curso { get; set; } = null!;

    public bool Ativo { get; set; }
}
