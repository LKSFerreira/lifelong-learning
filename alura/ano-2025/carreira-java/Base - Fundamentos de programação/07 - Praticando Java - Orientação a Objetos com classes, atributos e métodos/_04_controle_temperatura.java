public class _04_controle_temperatura {
    public static void main(String[] args) {
        ControleTemperatura controle = new ControleTemperatura();
        controle.local = "Sala de Servidores";
        controle.temperaturaAtual = 38.2;
        controle.status();
        
    }

    public static class ControleTemperatura {
     String local;
     double temperaturaAtual;

     void status() {
         System.out.println("Local: " + local);
         System.out.println("Temperatura Atual: " + temperaturaAtual + "°C");
        
         double alertaTemperatura = 37.5;
         if (temperaturaAtual > alertaTemperatura) {
                System.out.println("Alerta: Temperatura acima do limite!");
         }
     }
    }
}  
