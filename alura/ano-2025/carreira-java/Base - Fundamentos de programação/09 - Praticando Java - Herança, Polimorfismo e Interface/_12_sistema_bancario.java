public class _12_sistema_bancario {
    public static void main(String[] args) {
        
        // Criando diferentes operações bancárias usando polimorfismo
        OperacaoBancaria operacaoDeposito = new Deposito(200.0);
        OperacaoBancaria operacaoSaque = new Saque(50.5);
        
        // Executando as operações - cada uma com seu comportamento específico
        operacaoDeposito.executar();
        operacaoSaque.executar();
        
        // Demonstrando flexibilidade do sistema
        OperacaoBancaria outroDeposito = new Deposito(1500.75);
        OperacaoBancaria outroSaque = new Saque(300.25);
        
        outroDeposito.executar();
        outroSaque.executar();
        
    }
}

/**
 * Interface que define o contrato para todas as ações bancárias
 * Garante que toda operação financeira tenha o método executar()
 */
interface AcaoBancaria {
    /**
     * Método que deve ser implementado por todas as operações bancárias
     * Define o comportamento de execução da operação
     */
    void executar();
}

/**
 * Classe abstrata que serve como base para todas as operações bancárias
 * Implementa a interface AcaoBancaria e fornece estrutura comum
 * Combina os conceitos de interface e herança
 */
abstract class OperacaoBancaria implements AcaoBancaria {
    protected double valor;
    
    /**
     * Construtor para inicializar o valor da operação
     * @param valor Valor monetário da operação bancária
     */
    public OperacaoBancaria(double valor) {
        this.valor = valor;
    }
    
    /**
     * Método abstrato que força cada subclasse a implementar
     * sua própria lógica de execução
     */
    @Override
    public abstract void executar();
    
    /**
     * Método auxiliar para obter o valor da operação
     * @return Valor da operação
     */
    public double getValor() {
        return valor;
    }
}

/**
 * Classe para operações de depósito bancário
 * Extende OperacaoBancaria e implementa lógica específica de depósito
 */
class Deposito extends OperacaoBancaria {
    
    /**
     * Construtor para criar uma operação de depósito
     * @param valor Valor a ser depositado
     */
    public Deposito(double valor) {
        super(valor);
    }
    
    /**
     * Implementação específica para execução de depósito
     * Exibe mensagem formatada com o valor do depósito
     */
    @Override
    public void executar() {
        System.out.printf("Depósito de R$%.2f realizado%n", valor);
    }
}

/**
 * Classe para operações de saque bancário
 * Extende OperacaoBancaria e implementa lógica específica de saque
 */
class Saque extends OperacaoBancaria {
    
    /**
     * Construtor para criar uma operação de saque
     * @param valor Valor a ser sacado
     */
    public Saque(double valor) {
        super(valor);
    }
    
    /**
     * Implementação específica para execução de saque
     * Exibe mensagem formatada com o valor do saque
     */
    @Override
    public void executar() {
        System.out.printf("Saque de R$%.2f realizado%n", valor);
    }
}

/**
 * Exemplo adicional: Transferência bancária
 * Demonstra como o sistema pode ser facilmente expandido
 */
class Transferencia extends OperacaoBancaria {
    private String contaDestino;
    
    public Transferencia(double valor, String contaDestino) {
        super(valor);
        this.contaDestino = contaDestino;
    }
    
    @Override
    public void executar() {
        System.out.printf("Transferência de R$%.2f para conta %s realizada%n", 
                         valor, contaDestino);
    }
}
