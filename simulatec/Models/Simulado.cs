using System;
using System.Collections.Generic;

namespace simulatec.Models;

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

    public bool Ativo { get; set; } = true;

    public override string ToString()
    {
        return $"({Instituicao}/{Ano}) {Questao}\n A) {RespostaA}\n B) {RespostaB}\n C) {RespostaC}\n D) {RespostaD}\n E) {RespostaE}\n";
    }

    public void EmbaralharRespostas()
    {
        var respostas = new List<string> { RespostaA!, RespostaB!, RespostaC!, RespostaD!, RespostaE! };
        respostas = respostas.OrderBy(x => Guid.NewGuid()).ToList();
        RespostaA = respostas[0];
        RespostaB = respostas[1];
        RespostaC = respostas[2];
        RespostaD = respostas[3];
        RespostaE = respostas[4];
    }
}
