using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using simulatec.Models;

namespace simulatec.Services;

public class DashboardService
{
    public static string Token { get; private set; } = "";
    public static async Task<bool> Acessar()
    {
        Token = AcessoService.GetToken();
        var usuarioAutenticado = AcessoService.ValidarToken();

        if (usuarioAutenticado == null || string.IsNullOrEmpty(Token))
        {
            return false;
        }

        Console.WriteLine($"Usuário autenticado\n");
        Thread.Sleep(50);

        Task<int> opcao;
        do
        {
            opcao = MenuAsync(usuarioAutenticado.Role);

        } while (await opcao != 9);

        return true;
    }

    private static async Task<int> MenuAsync(string role)
    {
        int retorn = 0; // initialize with a default value
        switch (role)
        {
            case "cliente":
                retorn = await Cliente();
                break;
            case "admin":
                retorn = await Admin();
                break;
        }
        return retorn;
    }

    private static async Task<int> Admin()
    {

        Console.WriteLine($"Acesso de administrador");
        Console.WriteLine($"Escolha uma opção abaixo:\n");

        Console.WriteLine($"============ Acessos ===========");
        Console.WriteLine($"1 - Listar todos os acessos");
        Console.WriteLine($"2 - Buscar acesso");
        Console.WriteLine($"3 - Alterar senha de acesso");
        Console.WriteLine($"4 - Cadastrar acesso");
        Console.WriteLine($"5 - Excluir acesso");

        Console.WriteLine($"============ Pessoas ===========");
        Console.WriteLine($"6 - Listar todas as pessoas");
        Console.WriteLine($"7 - Buscar pessoa pelo usuário");
        Console.WriteLine($"8 - Alterar informações da pessoa");
        Console.WriteLine($"9 - Cadastrar pessoa");
        Console.WriteLine($"10 - Excluir pessoa");

        Console.WriteLine($"============ Simulados =========");
        Console.WriteLine($"11 - Simular");
        Console.WriteLine($"12 - Listar questões do simulado");
        Console.WriteLine($"13 - Buscar questão pelo ID");
        Console.WriteLine($"14 - Alterar questão");
        Console.WriteLine($"15 - Cadastrar questão");
        Console.WriteLine($"16 - Excluir questão");

        Console.WriteLine($"============ Sistema ===========");
        Console.WriteLine($"17 - Desconectar");
        Console.WriteLine($"0 - Sair\n");

        int opcao = int.Parse(Console.ReadLine()!);
        Console.WriteLine();

        switch (opcao)
        {
            case 0:
                Environment.Exit(0);
                break;
            case 1:
                await AcessoService.Listar();
                break;
            case 2:
                await AcessoService.Buscar();
                break;
            case 3:
                AcessoService.AtualizarSenha();
                break;
            case 4:
                AcessoService.Cadastrar();
                break;
            case 5:
                AcessoService.Excluir();
                break;
            case 6:
                await PessoaService.Listar();
                break;
            case 7:
                await PessoaService.Buscar();
                break;
            case 8:
                PessoaService.Atualizar();
                break;
            case 9:
                PessoaService.Cadastrar();
                break;
            case 10:
                PessoaService.Excluir();
                break;
            case 11:
                SimuladoService.Simular();
                break;
            case 12:
                await SimuladoService.Listar();
                break;
            case 13:
                await SimuladoService.Buscar();
                break;
            case 14:
                SimuladoService.Atualizar();
                break;
            case 15:
                await SimuladoService.Cadastrar();
                break;
            case 16:
                SimuladoService.Excluir();
                break;
            case 17:
                opcao = 9;
                Token = "";
                break;
            default:
                Console.WriteLine($"Opção inválida");
                await Admin();
                break;
        }

        return opcao;
    }

    private static Task<int> Cliente()
    {
        Console.Clear();
        Console.WriteLine($"Seja bem vindo ao Simulatec");
        Console.WriteLine($"Escolha uma opção abaixo:\n");

        Console.WriteLine($"1 - Simular");
        Console.WriteLine($"9 - Desconectar");
        Console.WriteLine($"0 - Sair");

        int opcao = int.Parse(Console.ReadLine()!);

        switch (opcao)
        {
            case 0:
                Environment.Exit(0);
                break;
            case 1:
                SimuladoService.Simular();
                break;
            case 9:
                Token = "";
                break;
        }

        return Task.FromResult(opcao);
    }

    public static void Cadastrar()
    {
        PessoaService.Cadastrar();
    }


}
