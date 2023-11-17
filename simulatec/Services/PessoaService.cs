using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Threading.Tasks;
using simulatec.Models;

namespace simulatec.Services;

public class PessoaService
{
    private static Pessoa Pessoa()
    {
        Console.WriteLine($"Digite o seu usuario:");
        var usuario = "lksferreira"; //Console.ReadLine()!;

        Console.WriteLine($"Digite o seu nome completo:");
        var nome = "Lucas Ferreira"; //Console.ReadLine()!;

        Console.WriteLine($"Digite o seu CPF:");
        var cpf = "390.055.178-24".Replace(".", "").Replace("-", ""); //Console.ReadLine()!;

        Console.WriteLine($"Digite o seu email:");
        var email = "ferreira.s.lks@gmail.com"; //Console.ReadLine()!;

        Console.WriteLine($"Digite o seu telefone:");
        var telefone = "(17) 99651-0506".Replace("(", "").Replace(")", "").Replace(" ", "").Replace("-", "").Replace(".", ""); //Console.ReadLine()!;

        Console.WriteLine($"Digite a sua data de nascimento: ano-mes-dia (ex: 1990-01-01)");
        var nascimento = "1990-01-01"; //Console.ReadLine()!;

        var role = "admin".ToLower().Trim();
        var validacao = $"{usuario}{cpf}{nascimento}";

        Console.WriteLine($@"
        Usário: {usuario}
        Nome: {nome}
        CPF: {cpf}
        Email: {email}
        Telefone: {telefone}
        Nascimento: {nascimento}
        Role: {role}
        Validacao: {validacao}
        ");

        Console.WriteLine($"Confirma o cadastro? (s/n)");
        var confirmacao = "s".Trim().ToLower(); //Console.ReadLine()!;

        return confirmacao.IndexOf('s') == 0 ? new Pessoa { Usuario = usuario, Nome = nome, Cpf = cpf, Email = email, Telefone = telefone, Nascimento = DateTime.Parse(nascimento), Role = role, Validacao = validacao } : null!;
    }

    public static async Task Listar()
    {
        Console.Clear();

        var client = HttpService.RequisicaoAPI("Pessoa/Listar");
        var response = await client.GetAsync(client.BaseAddress);

        if (response.IsSuccessStatusCode)
        {
            var listaDePessoa = await response.Content.ReadFromJsonAsync<List<Pessoa>>();

            Console.WriteLine($"Acessos cadastrados:");
            foreach (var pessoa in listaDePessoa!)
            {
                Console.WriteLine($"Usuario: {pessoa.Usuario,-15} | Nome: {pessoa.Nome,-15} | CPF: {pessoa.Cpf,-15} | Email: {pessoa.Email,-25} | Telefone: {pessoa.Telefone}");
            }
            Console.WriteLine($"\n");
        }
        else
        {
            Console.WriteLine($"Acessos não encontrados\n");
        }
    }

    public static async Task<Pessoa> Buscar()
    {
        Console.Clear();
        Console.WriteLine($"Digite o usuario:");
        var usuario = "lksferreira"; //Console.ReadLine()!;
        Console.WriteLine();

        var client = HttpService.RequisicaoAPI($"Pessoa/Buscar/{usuario}");
        var response = client.GetAsync(client.BaseAddress).Result;

        if (response.IsSuccessStatusCode)
        {
            var pessoa = await response.Content.ReadFromJsonAsync<Pessoa>();
            Console.WriteLine($"Pessoa localizada:");
            Console.WriteLine($@"
            Usuario: {pessoa!.Usuario}
            Nome: {pessoa.Nome}
            CPF: {pessoa.Cpf}
            Email: {pessoa.Email}
            Telefone: {pessoa.Telefone}");
            Console.WriteLine();
            return pessoa;
        }
        else
        {
            Console.WriteLine($"Acessos não encontrado\n");
            return null!;
        }
    }

    public static void Atualizar()
    {
        Pessoa pessoa = Buscar().Result;

        Console.WriteLine($"Digite o novo nome:");
        var nome = "Lucas Ferreira"; //Console.ReadLine()!;

        Console.WriteLine($"Digite o novo e-mail:");
        var email = "lks_ferreira@hotmail.com"; //Console.ReadLine()!;

        Console.WriteLine($"Digite o novo telefone:");
        var telefone = "(17) 99651-0506".Replace("(", "").Replace(")", "").Replace(" ", "").Replace("-", "").Replace(".", ""); //Console.ReadLine()!;

        pessoa.Nome = nome;
        pessoa.Email = email;
        pessoa.Telefone = telefone;

        var client = HttpService.RequisicaoAPI($"Pessoa/Atualizar/{pessoa.Usuario}");
        var response = client.PutAsJsonAsync(client.BaseAddress, pessoa).Result;
        if (response.IsSuccessStatusCode)
        {
            Console.Clear();
            Console.WriteLine($"Dados {(response.IsSuccessStatusCode ? "alterada com sucesso" : $"não alterada. Erro: {response.StatusCode}")}");
            Console.WriteLine($"\n");
        }
        else
        {
            Console.WriteLine($"Pessoa não encontrado\n");
        }
    }

    public static void Cadastrar()
    {
        var pessoa = Pessoa();
        if (pessoa == null) return;

        var client = HttpService.RequisicaoAPI("Pessoa/Cadastrar");
        var response = client.PostAsJsonAsync(client.BaseAddress, pessoa).Result;

        if (response.IsSuccessStatusCode)
        {
            Console.WriteLine($"Digite a sua senha:");
            var senha = "lks123"; //Console.ReadLine()!;

            Acesso acesso = new()
            {
                Usuario = pessoa.Usuario,
                Senha = senha,
                Ativo = true
            };
            AcessoService.Cadastrar(acesso);
        }
        Console.WriteLine($"Pessoa {(response.IsSuccessStatusCode ? "cadastrada com sucesso" : $"não cadastrada. Erro: {response.StatusCode}")}");
        Console.WriteLine($"\n");
    }

    public static void Excluir()
    {
        Console.WriteLine($"Digite o usuario:");
        var usuario = "lksferreira"; //Console.ReadLine()!;

        var client = HttpService.RequisicaoAPI($"Pessoa/Excluir/{usuario}");
        var response = client.DeleteAsync(client.BaseAddress).Result;

        Console.Clear();
        Console.WriteLine($"Pessoa {(response.IsSuccessStatusCode ? "excluida com sucesso" : $"não excluida. Erro: {response.StatusCode}")}");
        Console.WriteLine($"\n");
    }
}
