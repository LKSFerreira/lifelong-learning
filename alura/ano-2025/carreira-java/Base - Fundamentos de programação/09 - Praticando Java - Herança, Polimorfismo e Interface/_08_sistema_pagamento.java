public class _08_sistema_pagamento {
    public static void main(String[] args) {
        
        // Criando diferentes tipos de pagamento usando polimorfismo
        Pagamento pagamentoCartao = new CartaoCredito(250.00);
        Pagamento pagamentoBoleto = new BoletoBancario(500.00);
        Pagamento pagamentoPix = new Pix(300.00);
        
        // Confirmando cada pagamento - cada tipo tem seu comportamento específico
        pagamentoCartao.confirmarPagamento();
        pagamentoBoleto.confirmarPagamento();
        pagamentoPix.confirmarPagamento();
        
    }
}

/**
 * Classe abstrata base para todos os tipos de pagamento
 * Define a estrutura comum e força a implementação de métodos específicos
 */
abstract class Pagamento {
    protected double valor;
    
    /**
     * Construtor da classe base
     * @param valor Valor do pagamento em reais
     */
    public Pagamento(double valor) {
        this.valor = valor;
    }
    
    /**
     * Método abstrato que deve ser implementado por cada tipo de pagamento
     * Cada subclasse define sua própria lógica de confirmação
     */
    public abstract void confirmarPagamento();
    
    /**
     * Método abstrato para calcular a taxa específica de cada meio de pagamento
     * @return Valor da taxa calculada
     */
    protected abstract double calcularTaxa();
}

/**
 * Classe para pagamentos via Cartão de Crédito
 * Taxa de 3% sobre o valor da transação
 */
class CartaoCredito extends Pagamento {
    private static final double TAXA_PERCENTUAL = 0.03; // 3%
    
    public CartaoCredito(double valor) {
        super(valor);
    }
    
    @Override
    protected double calcularTaxa() {
        return valor * TAXA_PERCENTUAL;
    }
    
    @Override
    public void confirmarPagamento() {
        double taxaCalculada = calcularTaxa();
        System.out.printf("Pagamento de R$%.2f confirmado no Cartão de Crédito (Taxa: R$%.2f)%n", 
                         valor, taxaCalculada);
    }
}

/**
 * Classe para pagamentos via Boleto Bancário
 * Taxa de 1% sobre o valor da transação
 */
class BoletoBancario extends Pagamento {
    private static final double TAXA_PERCENTUAL = 0.01; // 1%
    
    public BoletoBancario(double valor) {
        super(valor);
    }
    
    @Override
    protected double calcularTaxa() {
        return valor * TAXA_PERCENTUAL;
    }
    
    @Override
    public void confirmarPagamento() {
        double taxaCalculada = calcularTaxa();
        System.out.printf("Boleto de R$%.2f gerado com sucesso (Taxa: R$%.2f)%n", 
                         valor, taxaCalculada);
    }
}

/**
 * Classe para pagamentos via Pix
 * Sem taxas - método de pagamento gratuito
 */
class Pix extends Pagamento {
    
    public Pix(double valor) {
        super(valor);
    }
    
    @Override
    protected double calcularTaxa() {
        return 0.0; // Pix não tem taxa
    }
    
    @Override
    public void confirmarPagamento() {
        System.out.printf("Pagamento via Pix de R$%.2f confirmado%n", valor);
    }
}
