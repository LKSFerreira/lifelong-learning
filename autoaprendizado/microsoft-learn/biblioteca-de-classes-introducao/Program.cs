// O QUE É A BIBLIOTECA DE CLASSES DO .NET?
/* {É uma coleção de milhares de classes, que contém dezenas de milhares de métodos. Esses métodos são criados pela Microsoft e estão disponíveis para o uso em seus aplicativos .Uma classe é simplemente um contêiner para métodos.}*/

// O QUE É UM NAMESPACE?
/* Imagine um namespace como um sobrenome ou um "nome de família" para um tipo. Uma classe contém o código que implementa um tipo. As classes são organizadas em namespaces para evitar colisões de nomenclatura. Afinal, quando há milhares de classes, é possível que possa ser necessário reutilizar um nome de classe. O namespace ajuda a verificar duas classes não têm o mesmo nome completo.*/

// O exemplo simula uma jogada de dados gerando um número aleatório e imprimindo-o no console:
internal class Program
{
    private static void Main(string[] args)
    {   
        /* Cria uma instancia da classe System.Random e armazenaa referencia ao novo objetoem uma variável denominada rolarDado*/
        Random rolarDado = new Random();
        
        
        for (int i = 0; i < 100000; i++)
        {   
            /* Chama o metodo Next(), que recebe dois argumentos, o valor mínimo e o valor máximo, retornando um valor aleatório entre os números passados como parametros, esse valor é guardado dentro da variavel numeroRolado*/
            int numeroRolado = rolarDado.Next();

            /*Imprime o valor no console*/
            Console.Write($@"{numeroRolado} ");
        }
    }
}