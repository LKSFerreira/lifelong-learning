using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using System.Threading.Tasks;
using simulatec.Models;

namespace simulatec.Services;

public class AcessoService
{
    public static Acesso Acesso()
    {
        Console.Clear();

        Console.WriteLine($"Digite o seu usuario:");
        var usuario = "lksferreira"; //Console.ReadLine()!;

        Console.WriteLine($"Digite a sua senha:");
        var senha = "lks123"; //Console.ReadLine()!;

        Acesso acesso = new()
        {
            Usuario = usuario,
            Senha = senha
        };

        return acesso;
    }

    public static string GetToken()
    {
        HttpResponseMessage response = Autenticar(Acesso());

        if (response.IsSuccessStatusCode)
        {
            var token = response.Content.ReadAsStringAsync().Result;
            Console.WriteLine($"Token: {token}"); // TODO: Remover essa em produção
            return token.Replace("\\", "").Replace("\"", "");
        }
        else
        {
            Console.WriteLine($"Usuário ou senha inválidos");
            return "";
        }
    }

    public static Token ValidarToken()
    {
        var client = HttpService.RequisicaoAPI("Acesso/ValidarToken");

        var response = client.GetAsync(client.BaseAddress).Result;

        if (response.IsSuccessStatusCode)
        {
            var responseString = response.Content.ReadAsStringAsync().Result;
            var usuario = JsonSerializer.Deserialize<Token>(responseString);
            return usuario!;
        }
        else
        {
            Console.WriteLine($"Token inválido");
            return null!;
        }
    }

    public static async Task Listar()
    {
        Console.Clear();

        var client = HttpService.RequisicaoAPI("Acesso/Listar");
        var response = await client.GetAsync(client.BaseAddress);

        if (response.IsSuccessStatusCode)
        {
            var listaDeAcesso = await response.Content.ReadFromJsonAsync<List<Acesso>>();

            Console.WriteLine($"Acessos cadastrados:");
            foreach (var acesso in listaDeAcesso!)
            {
                Console.WriteLine($"Usuario: {acesso.Usuario,-15} | Senha: {acesso.Senha,-15} | Atvido: {acesso.Ativo}");
            }
            Console.WriteLine($"\n");
        }
        else
        {
            Console.WriteLine($"Acessos não encontrados\n");
        }
    }

    public static void Cadastrar(Acesso acesso)
    {
        var client = HttpService.RequisicaoAPI("Acesso/Cadastrar");

        var response = client.PostAsJsonAsync(client.BaseAddress, acesso).Result;

        Console.WriteLine($"Acesso {(response.IsSuccessStatusCode ? "cadastrado com sucesso" : $"não cadastrada. Erro: {response.StatusCode}")}");
    }

    public static async Task Buscar()
    {
        Console.Clear();
        Console.WriteLine($"Digite o usuario:");
        var usuario = "lksferreira"; //Console.ReadLine()!;
        Console.WriteLine();

        var client = HttpService.RequisicaoAPI($"Acesso/Buscar/{usuario}");
        var response = client.GetAsync(client.BaseAddress).Result;

        if (response.IsSuccessStatusCode)
        {
            var acesso = await response.Content.ReadFromJsonAsync<Acesso>();
            Console.WriteLine($"Acessos localizado:");
            Console.WriteLine($"Usuario: {acesso!.Usuario,-15} | Senha: {acesso.Senha,-15} | Atvido: {acesso.Ativo}");
            Console.WriteLine($"\n");
        }
        else
        {
            Console.WriteLine($"Acessos não encontrado\n");
        }
    }

    internal static void AtualizarSenha()
    {
        var acesso = Acesso();

        Console.WriteLine($"Digite a nova senha:");
        var novaSenha = "lks123"; //Console.ReadLine()!;
        acesso.Senha = novaSenha;

        var client = HttpService.RequisicaoAPI($"Acesso/Alterar/{acesso.Usuario}");
        var response = client.PutAsJsonAsync(client.BaseAddress, acesso).Result;

        if (response.IsSuccessStatusCode)
        {
            Console.Clear();
            Console.WriteLine($"Senha de acesso {(response.IsSuccessStatusCode ? "alterada com sucesso" : $"não alterada. Erro: {response.StatusCode}")}");
            Console.WriteLine($"\n");
        }
        else
        {
            Console.WriteLine($"Acesso não encontrado\n");
        }
    }

    public static void Cadastrar()
    {
        var acesso = Acesso();
        acesso.Ativo = true;

        var client = HttpService.RequisicaoAPI("Acesso/Cadastrar");
        var response = client.PostAsJsonAsync(client.BaseAddress, acesso).Result;

        Console.WriteLine($"Acesso {(response.IsSuccessStatusCode ? "cadastrado com sucesso" : $"não alterada. Erro: {response.StatusCode}")}");
        Console.WriteLine($"\n");
    }

    public static void Excluir()
    {
        var acesso = Acesso();
        var client = HttpService.RequisicaoAPI($"Acesso/Excluir/{acesso.Usuario}");
        var response = client.DeleteAsync(client.BaseAddress).Result;

        if (response.IsSuccessStatusCode)
        {
            Console.Clear();
            Console.WriteLine($"Acesso {(response.IsSuccessStatusCode ? "excluido com sucesso" : $"não excluido. Erro: {response.StatusCode}")}");
            Console.WriteLine($"\n");
        }
        else
        {
            Console.WriteLine($"Acesso não encontrado\n");
        }
    }

    public static HttpResponseMessage Autenticar(Acesso acessoDoUsuario)
    {
        Acesso acesso = new()
        {
            Usuario = acessoDoUsuario.Usuario,
            Senha = acessoDoUsuario.Senha,
        };

        var client = HttpService.RequisicaoAPI("Acesso/Autenticar");
        var response = client.PostAsJsonAsync(client.BaseAddress, acesso).Result;
        return response;
    }

}
