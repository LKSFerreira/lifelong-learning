namespace jogos_de_tabuleiro
{
    public class Login
    {
        public string Usuario { get; private set; }
        public string Senha { get; private set; }

        public Login(string usuario, string senha)
        {
            Usuario = usuario;
            Senha = senha;
        }
    }
}