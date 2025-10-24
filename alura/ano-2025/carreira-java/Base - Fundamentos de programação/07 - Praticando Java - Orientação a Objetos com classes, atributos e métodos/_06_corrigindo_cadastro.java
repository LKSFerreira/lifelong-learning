// Define a classe Colaborador
class Colaborador {
    String nome;
    String cargo;
    int nivelAcesso;

    // Construtor para inicializar os atributos
    public Colaborador(String nome, String cargo, int nivelAcesso) {
        this.nome = nome;
        this.cargo = cargo;
        this.nivelAcesso = nivelAcesso;
    }

    /**
     * Permite alterar o cargo e o nível de acesso do colaborador.
     */
    public void alterarCargoNivel(String novoCargo, int novoNivel) {
        this.cargo = novoCargo;
        this.nivelAcesso = novoNivel;
    }

    /**
     * Exibe no console as informações do colaborador.
     */
    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Nível de acesso: " + this.nivelAcesso);
    }
}

public class _06_corrigindo_cadastro {

    public static void main(String[] args) {
        // Cria uma instância do colaborador com os dados iniciais
        Colaborador colaborador = new Colaborador("Júlia Oliveira", "Pessoa Desenvolvedora Júnior", 1);

        // Exibe as informações antes da atualização
        System.out.println("--- Antes da atualização ---");
        colaborador.exibirInformacoes();
        System.out.println(); // Adiciona uma linha em branco para formatação

        // Altera o cargo e o nível de acesso
        colaborador.alterarCargoNivel("Pessoa Desenvolvedora Plena", 2);

        // Exibe as informações após a atualização
        System.out.println("--- Após atualização ---");
        colaborador.exibirInformacoes();
    }

}
