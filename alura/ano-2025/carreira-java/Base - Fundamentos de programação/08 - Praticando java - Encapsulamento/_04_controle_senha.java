class Usuario {
    private String senha;

    public Usuario(String senha) {
        this.senha = senha;
    }

    public void setSenha(String senha, String novaSenha, String confirmarNovaSenha) {
        if (senha == null || !senha.equals(this.senha)) {
            System.out.println("Senha atual incorreta.");
            return;
        }

        if (novaSenha == null || !novaSenha.equals(confirmarNovaSenha)) {
            System.out.println("Nova senha e confirmação não coincidem.");
            return;
        }

        this.senha = novaSenha;
        System.out.println("Senha atualizada com sucesso.");
    }
}

public class _04_controle_senha {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("senha123");
        usuario.setSenha("senha123", "novaSenha456", "novaSenha456"); // Atualiza com sucesso
        usuario.setSenha("senhaErrada", "novaSenha456", "novaSenha456"); // Senha atual incorreta

    }

}