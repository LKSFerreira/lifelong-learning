public class _11_implementando_interfaces {
    public static void main(String[] args) {
        
        // Criando um relatório com título e conteúdo específicos
        Relatorio relatorio = new Relatorio(
            "Relatório 2025", 
            "Tudo funcionando conforme esperado."
        );
        
        // Imprimindo o relatório usando o método da interface
        relatorio.imprimir();
        
        // Demonstrando que podemos ter múltiplos relatórios
        Relatorio relatorioVendas = new Relatorio(
            "Relatório de Vendas Q4", 
            "Vendas aumentaram 15% em relação ao trimestre anterior."
        );
        
        relatorioVendas.imprimir();
        
    }
}

/**
 * Interface que define o contrato para objetos que podem ser impressos
 * Garante que todas as classes implementadoras tenham o método imprimir()
 */
interface Imprimivel {
    /**
     * Método que deve ser implementado por todas as classes
     * que desejam ter funcionalidade de impressão
     */
    void imprimir();
}

/**
 * Classe que representa um relatório corporativo
 * Implementa a interface Imprimivel para garantir padronização na exibição
 */
class Relatorio implements Imprimivel {
    private String titulo;
    private String conteudo;
    
    /**
     * Construtor para criar um relatório com título e conteúdo
     * @param titulo Título do relatório
     * @param conteudo Conteúdo principal do relatório
     */
    public Relatorio(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }
    
    /**
     * Implementação do método da interface Imprimivel
     * Define como o relatório deve ser exibido no console
     */
    @Override
    public void imprimir() {
        System.out.println("Título: " + titulo);
        System.out.println("Conteúdo: " + conteudo);
    }
    
    // Métodos getters para acesso aos atributos (boa prática de encapsulamento)
    public String getTitulo() {
        return titulo;
    }
    
    public String getConteudo() {
        return conteudo;
    }
    
    // Métodos setters para modificação dos atributos (flexibilidade)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}

/**
 * Exemplo adicional: outra classe que também implementa Imprimivel
 * Demonstra como diferentes tipos de documento podem seguir o mesmo contrato
 */
class NotaFiscal implements Imprimivel {
    private String numeroNota;
    private double valor;
    private String cliente;
    
    public NotaFiscal(String numeroNota, double valor, String cliente) {
        this.numeroNota = numeroNota;
        this.valor = valor;
        this.cliente = cliente;
    }
    
    @Override
    public void imprimir() {
        System.out.println("=== NOTA FISCAL ===");
        System.out.println("Número: " + numeroNota);
        System.out.println("Cliente: " + cliente);
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("==================");
    }
}
