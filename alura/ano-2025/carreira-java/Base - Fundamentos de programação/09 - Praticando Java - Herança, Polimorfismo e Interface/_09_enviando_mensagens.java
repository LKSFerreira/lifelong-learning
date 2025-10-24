public class _09_enviando_mensagens {
    public static void main(String[] args) {

        Notificacao notificacao = new Notificacao();
        notificacao.enviarMensagem();
        notificacao.enviarMensagem("Lucas", "Seu pedido foi enviado com sucesso!");
        notificacao.enviarMensagem("Sofia", "Lembrete: Reunião amanhã às 10h", 3);

    }

    static class Notificacao {
        public void enviarMensagem() {
            System.out.println("Olá");
        }

        public void enviarMensagem(String nome, String mensagem) {
            System.out.println("Mensagem para " + nome + ": " + mensagem);
        }

        public void enviarMensagem(String nome, String mensagem, int quantidadeMensagens) {
            for (int i = 0; i < quantidadeMensagens; i++) {
                System.out.println("Mensagem " + (i + 1) + " para " + nome + ": " + mensagem);
            }
        }
    }
}
