using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Json;
using System.Threading.Tasks;
using simulatec.Models;

namespace simulatec.Services;

public class SimuladoService
{
    private static Simulado Simulado()
    {
        Console.Clear();

        Simulado simulado = new();

        Console.WriteLine($"Digite a questão:");
        simulado.Questao = "A resposta correta desta questão é: Resposta correta"; //Console.ReadLine()!;

        Console.WriteLine($"Resposta A:");
        simulado.RespostaA = "Resposta errada"; //Console.ReadLine()!;

        Console.WriteLine($"Resposta B:");
        simulado.RespostaB = "Resposta errada"; //Console.ReadLine()!;

        Console.WriteLine($"Resposta C:");
        simulado.RespostaC = "Resposta errada"; //Console.ReadLine()!;

        Console.WriteLine($"Resposta D:");
        simulado.RespostaD = "Resposta errada"; //Console.ReadLine()!;

        Console.WriteLine($"Resposta E:");
        simulado.RespostaE = "Resposta correta"; //Console.ReadLine()!;

        Console.WriteLine($"Digite a resposta correta:");
        simulado.Correta = "Resposta correta"; //Console.ReadLine()!;

        Console.WriteLine($"Digite a dificuldade da questão:");
        simulado.Dificuldade = 1;

        Console.WriteLine($"Digite o nome da instituição:");
        simulado.Instituicao = "Instituição Simulatec"; //Console.ReadLine()!;

        Console.WriteLine($"Digite o ano da questão:");
        simulado.Ano = 2023; // int.Parse(Console.ReadLine()!);

        Console.WriteLine($"Digite a área de estudo da questão:");
        simulado.Area = "Tecnologia da Informação";

        Console.WriteLine($"Digite o curso em que a questão é aplicada:");
        simulado.Curso = "Analise e Desenvolvimento de Sistemas";

        Console.WriteLine($@"
        Questão: {simulado.Questao}
        A) {simulado.RespostaA}
        B) {simulado.RespostaB}
        C) {simulado.RespostaC}
        D) {simulado.RespostaD}
        E) {simulado.RespostaE}
        Resposta correta: {simulado.Correta}
        Dificuldade: {simulado.Dificuldade}
        Instituição: {simulado.Instituicao}
        Ano: {simulado.Ano}
        Área: {simulado.Area}
        Curso: {simulado.Curso}
        ");

        Console.WriteLine($"Confirma o cadastro? (s/n)");
        var confirmacao = "s".Trim().ToLower(); //Console.ReadLine()!;

        return confirmacao.IndexOf('s') == 0 ? simulado : null!;
    }
    public static async Task Listar()
    {
        var client = HttpService.RequisicaoAPI("Simulado/Listar");

        var response = await client.GetAsync(client.BaseAddress);

        if (response.IsSuccessStatusCode)
        {
            var simulados = await response.Content.ReadFromJsonAsync<List<Simulado>>();

            foreach (var simulado in simulados!)
            {
                Console.WriteLine(simulado);
            }
        }
        else
        {
            Console.WriteLine($"Erro: {response.StatusCode}");
        }
    }

    public static void Atualizar()
    {
        Simulado simulado = Buscar().Result;
        var novoSimulado = Simulado();
        novoSimulado.Id = simulado.Id;

        var client = HttpService.RequisicaoAPI($"Simulado/Atualizar/{simulado.Id}");
        var response = client.PutAsJsonAsync(client.BaseAddress, novoSimulado).Result;

        if (response.IsSuccessStatusCode)
        {
            Console.Clear();
            Console.WriteLine($"Dados {(response.IsSuccessStatusCode ? "alterada com sucesso" : $"não alterada. Erro: {response.StatusCode}")}");
            Console.WriteLine($"\n");
        }
        else
        {
            Console.WriteLine($"Questão não encontrada\n");
        }

    }

    public static async Task<Simulado> Buscar()
    {
        Console.Clear();
        Console.WriteLine($"Digite o ID da questão:");
        var id = "1"; //Console.ReadLine()!;
        Console.WriteLine();

        Console.Clear();
        var client = HttpService.RequisicaoAPI($"Simulado/Buscar/{id}");
        var response = client.GetAsync(client.BaseAddress).Result;

        if (response.IsSuccessStatusCode)
        {
            var questao = await response.Content.ReadFromJsonAsync<Simulado>();
            Console.WriteLine($"Questão localizada:");
            Console.WriteLine($@"
            Id: {questao!.Id}
            Questão: {questao!.Questao}
            A): {questao.RespostaA}
            B): {questao.RespostaB}
            C): {questao.RespostaC}
            D): {questao.RespostaD}
            E): {questao.RespostaE}
            Resposta correta: {questao.Correta}
            Dificuldade: {questao.Dificuldade}
            Instituição: {questao.Instituicao}
            Ano: {questao.Ano}
            Área: {questao.Area}
            Curso: {questao.Curso}
            ");
            Console.WriteLine();
            return questao;
        }

        Console.WriteLine($"Acessos não encontrado\n");
        return null!;
    }

    public static async Task Cadastrar()
    {
        var simulado = Simulado();
        if (simulado == null) return;

        var client = HttpService.RequisicaoAPI("Simulado/Cadastrar");
        var response = await client.PostAsJsonAsync(client.BaseAddress, simulado);

        Console.WriteLine($"Questão {(response.IsSuccessStatusCode ? "cadastrada com sucesso" : $"não cadastrada. Erro: {response.StatusCode}")}");
        Console.WriteLine($"\n");
    }

    public static void Excluir()
    {
        Console.WriteLine($"Digite o ID da questão:");
        var id = "1"; //Console.ReadLine()!;

        var client = HttpService.RequisicaoAPI($"Simulado/Excluir/{id}");
        var response = client.DeleteAsync(client.BaseAddress).Result;

        Console.Clear();
        Console.WriteLine($"Questão {(response.IsSuccessStatusCode ? "excluída com sucesso" : $"não excluída. Erro: {response.StatusCode}")}");
        Console.WriteLine($"\n");
    }

    public static void Simular()
    {
        var listaDeQuestoes = new List<Simulado>();
        int acertos = 0;

        var client = HttpService.RequisicaoAPI("Simulado/Listar");
        var response = client.GetAsync(client.BaseAddress).Result;

        if (!response.IsSuccessStatusCode)
        {
            Console.WriteLine($"Erro: {response.StatusCode}");
            return;
        }

        var simulados = response.Content.ReadFromJsonAsync<List<Simulado>>().Result;
        simulados!.ForEach(listaDeQuestoes.Add);

        string respostaUsuario = "";

        // Embaralha os itens da lista
        listaDeQuestoes = listaDeQuestoes.OrderBy(x => Guid.NewGuid()).ToList();

        foreach (var questao in listaDeQuestoes)
        {   
            // Embaralha as respostas da questão para cada vez que for executada a simulação as respostas estejam em ordem diferente
            questao.EmbaralharRespostas();            

            Dictionary<string, string> dicionarioResposta = new()
            {
                   {"a", questao.RespostaA!},
                   {"b", questao.RespostaB!},
                   {"c", questao.RespostaC!},
                   {"d", questao.RespostaD!},
                   {"e", questao.RespostaE!}
            };

            Console.WriteLine(questao);
            Console.WriteLine($"Digite a resposta correta: ");
            respostaUsuario = Console.ReadLine()!.ToLower().Trim();

            if (dicionarioResposta[respostaUsuario] == questao.Correta)
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine($"Resposta correta!");
                Console.ResetColor();
                acertos++;
            }
            else
            {   
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine($"Resposta incorreta!");
                Console.ResetColor();
            }
            Console.WriteLine();
        }

        Console.WriteLine($"Simulado finalizado!");
        Console.WriteLine($"Total de questões: {listaDeQuestoes.Count}");
        Console.WriteLine($"Total de acertos: {acertos}");
    }
}
