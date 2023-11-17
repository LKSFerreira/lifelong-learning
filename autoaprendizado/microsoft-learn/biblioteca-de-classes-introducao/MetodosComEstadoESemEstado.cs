using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace biblioteca_de_classes_introducao
{
    public class MetodosComEstadoESemEstado
    {
        /*Em computação, o estado descreve a condição do ambiente de execução em um momento específico no tempo. Conforme seu código executa linha por linha, os valores são armazenados em variáveis. A qualquer momento durante a execução, o estado atual do aplicativo é a coleção de todos os valores armazenados na memória.*/

        /*Alguns métodos não dependem do estado atual do aplicativo para funcionarem corretamente. Em outras palavras, os métodos sem estado são implementados para que possam funcionar sem referenciar ou alterar os valores já armazenados na memória. Os métodos sem estado também são conhecidos como métodos estáticos.*/

        /*Por exemplo, o método Console.WriteLine() não depende de nenhum valor armazenado na memória. Ele executa sua função e termina sem afetar o estado do aplicativo de qualquer forma.*/

        /*Outros métodos, contudo, devem ter acesso ao estado do aplicativo para funcionar corretamente. Em outras palavras, os métodos com estado são criados de modo que dependem de valores armazenados na memória por linhas de código anteriores que já foram executadas ou modificam o estado do aplicativo atualizando valores ou armazenando novos valores na memória. Eles também são conhecidos como métodos de instância.*/

        /*Os métodos com estado (instância) controlam seu estado em campos, que são variáveis definidas na classe. Cada nova instância da classe tem sua própria cópia desses campos nos quais o estado é armazenado.*/

        /*Uma única classe pode dar suporte a métodos com e sem estado. No entanto, quando você precisa chamar métodos com estado, deve primeiro criar uma instância da classe para que o método possa acessar o estado.*/
    }
}