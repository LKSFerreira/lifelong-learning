class Bateria {
    private short nivel;

    public Bateria(short nivel) {
        this.nivel = nivel;
    }

    public void setNivel(short nivel) {
        if (nivel < 0 || nivel > 100) {
            System.out.println("Nível de bateria inválido.");
            return;
        }
        this.nivel = nivel;
    }

    public void status() {
        if (nivel >= 80) {
            System.out.println("Bateria cheia");
        } else if (nivel >= 21 && nivel < 80) {
            System.out.println("Bateria ok");
        } else {
            System.out.println("Bateria crítica");
        }
    }

}

public class _05_controle_nivel_bateria {
    public static void main(String[] args) {

        Bateria bateria = new Bateria((short) 90);

        bateria.status(); // Exibe "Bateria cheia"

        bateria.setNivel((short) 15);
        bateria.status(); // Exibe "Bateria fraca"

        bateria.setNivel((short) 150); // Tenta definir nível inválido

        bateria.setNivel((short) 50);
        bateria.status(); // Exibe "Bateria ok"

    }

}