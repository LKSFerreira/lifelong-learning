// Classe principal para testar o sistema de notificações
public class _07_sistema_notificacao {
    public static void main(String[] args) {
        // Criando instâncias de cada tipo de notificação
        Email email = new Email("cliente@exemplo.com", "Promoção especial!", "Aproveite nossos descontos esta semana.");
        SMS sms = new SMS("(11) 98765-4321", "Sua fatura foi paga com sucesso.");
        Push push = new Push("usuario_app", "Novidade!", "Você tem uma nova mensagem não lida.");

        // Enviando as notificações
        email.enviar();
        sms.enviar();
        push.enviar();
    }
}

// Classe base Notificacao
class Notificacao {
    String destinatario;
    String mensagem;

    public Notificacao(String destinatario, String mensagem) {
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }

    public void enviar() {
        System.out.println("Enviando notificação genérica...");
    }
}

// Classe específica para Email
class Email extends Notificacao {
    private String assunto;

    public Email(String destinatario, String assunto, String mensagem) {
        super(destinatario, mensagem);
        this.assunto = assunto;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando Email para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Corpo: " + mensagem);
        System.out.println();
    }
}

// Classe específica para SMS
class SMS extends Notificacao {
    public SMS(String destinatario, String mensagem) {
        super(destinatario, mensagem);
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        System.out.println();
    }
}

// Classe específica para Notificação Push
class Push extends Notificacao {
    private String titulo;

    public Push(String destinatario, String titulo, String mensagem) {
        super(destinatario, mensagem);
        this.titulo = titulo;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando Push para: " + destinatario);
        System.out.println("Título: " + titulo);
        System.out.println("Conteúdo: " + mensagem);
    }
}
