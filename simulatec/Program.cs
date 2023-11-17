using simulatec.Services;

Console.WriteLine($"\nHello Atos, projeto em console consumindo a RestAPI do projeto Simulatec");


do
{
    Console.WriteLine($"\nEscolha uma opção:\n");

    Console.WriteLine($"1 - Acessar");
    Console.WriteLine($"2 - Cadastrar");
    Console.WriteLine($"0 - Sair");

    var opcao = int.Parse(Console.ReadLine()!);
    Console.WriteLine("");

    switch (opcao)
    {
        case 1:
            await DashboardService.Acessar();
            break;
        case 2:
            DashboardService.Cadastrar();
            break;
        case 0:
            Environment.Exit(0);
            break;
        default:
            Console.Clear();
            Console.WriteLine($"Opção inválida\n");
            break;
    }

} while (true);