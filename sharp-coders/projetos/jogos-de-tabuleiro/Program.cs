using jogos_de_tabuleiro.view;
using jogos_de_tabuleiro.controller;
using jogos_de_tabuleiro;
using jogos_de_tabuleiro.controller.naval.tabuleiro;
using jogos_de_tabuleiro.controller.naval;


Autenticacao autenticacao = new Autenticacao();

if (autenticacao.AutenticarUsuario())
{
    Console.WriteLine($"{ArtASCII._Logo}");
    do
    {
        Dashbord.Iniciar();
        
    } while (true);
}