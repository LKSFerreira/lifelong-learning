public class _13_controle_dispositivo {
    public static void main(String[] args) {
        
        // Criando dispositivos controláveis da casa
        Luz luzSala = new Luz();
        ArCondicionado arQuarto = new ArCondicionado();
        
        // Testando controle da luz conforme exemplo
        luzSala.ligar();        // Primeira vez - deve ligar
        luzSala.ligar();        // Segunda vez - já está ligada
        luzSala.desligar();     // Desligando a luz
        
        // Testando controle do ar-condicionado
        arQuarto.desligar();    // Tentando desligar quando já está desligado
        
        // Demonstrando outros cenários
        System.out.println("\n--- Testando outros cenários ---");
        arQuarto.ligar();       // Ligando o ar-condicionado
        arQuarto.ligar();       // Tentando ligar novamente
        arQuarto.desligar();    // Desligando o ar-condicionado
        
    }
}

/**
 * Interface que define o contrato para dispositivos controláveis
 * Garante que todos os dispositivos tenham métodos básicos de controle
 */
interface Controlavel {
    /**
     * Método para ligar o dispositivo
     * Deve verificar o estado atual antes de executar a ação
     */
    void ligar();
    
    /**
     * Método para desligar o dispositivo  
     * Deve verificar o estado atual antes de executar a ação
     */
    void desligar();
}

/**
 * Classe que representa uma lâmpada/luz controlável
 * Implementa a interface Controlavel com lógica específica para iluminação
 */
class Luz implements Controlavel {
    private boolean ligado;
    
    /**
     * Construtor que inicializa a luz como desligada
     */
    public Luz() {
        this.ligado = false;
    }
    
    /**
     * Liga a luz se estiver desligada, ou informa que já está ligada
     */
    @Override
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Luz ligada.");
        } else {
            System.out.println("Luz já está ligada.");
        }
    }
    
    /**
     * Desliga a luz se estiver ligada, ou informa que já está desligada
     */
    @Override
    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Luz desligada.");
        } else {
            System.out.println("Luz já está desligada.");
        }
    }
    
    /**
     * Método auxiliar para verificar o estado atual da luz
     * @return true se a luz estiver ligada, false caso contrário
     */
    public boolean estaLigado() {
        return ligado;
    }
}

/**
 * Classe que representa um ar-condicionado controlável
 * Implementa a interface Controlavel com lógica específica para climatização
 */
class ArCondicionado implements Controlavel {
    private boolean ligado;
    
    /**
     * Construtor que inicializa o ar-condicionado como desligado
     */
    public ArCondicionado() {
        this.ligado = false;
    }
    
    /**
     * Liga o ar-condicionado se estiver desligado, ou informa que já está ligado
     */
    @Override
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Ar-condicionado ligado.");
        } else {
            System.out.println("Ar-condicionado já está ligado.");
        }
    }
    
    /**
     * Desliga o ar-condicionado se estiver ligado, ou informa que já está desligado
     */
    @Override
    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Ar-condicionado desligado.");
        } else {
            System.out.println("Ar-condicionado já está desligado.");
        }
    }
    
    /**
     * Método auxiliar para verificar o estado atual do ar-condicionado
     * @return true se o ar-condicionado estiver ligado, false caso contrário
     */
    public boolean estaLigado() {
        return ligado;
    }
}

/**
 * Exemplo adicional: Ventilador controlável
 * Demonstra como facilmente adicionar novos dispositivos ao sistema
 */
class Ventilador implements Controlavel {
    private boolean ligado;
    private int velocidade;
    
    public Ventilador() {
        this.ligado = false;
        this.velocidade = 0;
    }
    
    @Override
    public void ligar() {
        if (!ligado) {
            ligado = true;
            velocidade = 1; // Velocidade mínima ao ligar
            System.out.println("Ventilador ligado na velocidade 1.");
        } else {
            System.out.println("Ventilador já está ligado.");
        }
    }
    
    @Override
    public void desligar() {
        if (ligado) {
            ligado = false;
            velocidade = 0;
            System.out.println("Ventilador desligado.");
        } else {
            System.out.println("Ventilador já está desligado.");
        }
    }
    
    public void ajustarVelocidade(int novaVelocidade) {
        if (ligado && novaVelocidade >= 1 && novaVelocidade <= 3) {
            this.velocidade = novaVelocidade;
            System.out.println("Velocidade do ventilador ajustada para " + novaVelocidade);
        }
    }
}
