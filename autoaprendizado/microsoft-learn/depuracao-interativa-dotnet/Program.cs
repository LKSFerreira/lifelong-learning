using System.Diagnostics;

int result = Fibonacci(6);
Console.WriteLine($"{result}");

int Fibonacci(int numero)
{

    Debug.WriteLine($"Entrando no metodo {nameof(Fibonacci)}");
    Debug.WriteLine($"Estamos procurando pelo valor da sequência de posição {numero}");

    int penultimoNumero = 0;
    int ultimoNumero = 1;
    int somaDosNumeros = 0;

    for (int i = 2; i <= numero; i++)
    {
        somaDosNumeros = penultimoNumero + ultimoNumero;
        penultimoNumero = ultimoNumero;

        Debug.WriteLineIf(somaDosNumeros == 1, $"A soma dos números é {somaDosNumeros}, o penultimo número é {penultimoNumero}, o último número é {ultimoNumero}");

        ultimoNumero = somaDosNumeros;
    }
    Debug.Assert(ultimoNumero == 5, "O valor de retorno não é 5 e deveria ser.");

    return numero == 0 ? penultimoNumero : ultimoNumero;
}

Console.WriteLine($"");