using System.IO;

IEnumerable<string> listaDeDiretorios = Directory.EnumerateDirectories("stores");

foreach (var pasta in listaDeDiretorios)
{
    Console.WriteLine($"{pasta}");
}

Console.WriteLine($"------------------");

IEnumerable<string> arquivos = Directory.EnumerateFiles("stores");

foreach (var arquivo in arquivos)
{
    Console.WriteLine($"{arquivo}");
}

Console.WriteLine($"------------------");

//Encontra todos os arquivos *.txt na pasta stores e nas subpastas

IEnumerable<string> todosArquviosTxtNaPastaStore = Directory.EnumerateFiles("stores", "*.txt", SearchOption.AllDirectories);

foreach (var arquivoTXT in todosArquviosTxtNaPastaStore)
{
    Console.WriteLine($"{arquivoTXT}");
}