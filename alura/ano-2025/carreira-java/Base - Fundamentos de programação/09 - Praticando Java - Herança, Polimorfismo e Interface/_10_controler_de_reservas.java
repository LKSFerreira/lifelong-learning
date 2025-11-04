public class _10_controler_de_reservas {
    public static void main(String[] args) {
        
        // Testando a classe Reserva com seus métodos sobrecarregados
        Reserva reserva = new Reserva();
        reserva.reservar();                        // Sem parâmetros
        reserva.reservar("10/04");                 // Com data
        reserva.reservar("12/04", 4);              // Com data e quantidade
        
        // Testando a subclasse ReservaVip que sobrescreve o método
        Reserva reservaVip = new ReservaVip();
        reservaVip.reservar();                     // Método sobrescrito
        
    }
}

/**
 * Classe base para representar uma reserva no sistema de entretenimento
 * Implementa sobrecarga de métodos para diferentes tipos de reserva
 */
class Reserva {
    
    /**
     * Método reservar sem parâmetros - versão básica
     * Realiza uma reserva simples sem especificações
     */
    public void reservar() {
        System.out.println("Reserva realizada");
    }
    
    /**
     * Método reservar com data - versão com um parâmetro
     * @param data Data da reserva no formato string
     */
    public void reservar(String data) {
        System.out.println("Reserva feita para o dia " + data);
    }
    
    /**
     * Método reservar com data e quantidade - versão completa
     * @param data Data da reserva no formato string
     * @param quantidadePessoas Número de pessoas para a reserva
     */
    public void reservar(String data, int quantidadePessoas) {
        System.out.println("Reserva feita para o dia " + data + " para " + quantidadePessoas + " pessoas");
    }
}

/**
 * Classe ReservaVip que herda de Reserva
 * Oferece serviços exclusivos para clientes VIP
 * Sobrescreve o método reservar() básico para fornecer atendimento diferenciado
 */
class ReservaVip extends Reserva {
    
    /**
     * Sobrescreve o método reservar sem parâmetros
     * Fornece mensagem exclusiva para clientes VIP
     */
    @Override
    public void reservar() {
        System.out.println("Reserva VIP confirmada com atendimento exclusivo");
    }
    
    // Os outros métodos reservar(String) e reservar(String, int) 
    // são herdados da classe pai sem modificação
}
