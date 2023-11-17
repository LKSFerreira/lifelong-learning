using Newtonsoft.Json;

namespace jogos_de_tabuleiro
{

    public class Autenticacao
    {
        private static string _pathCredenciais = "./data/credenciais.json";

        private string jsonCredenciais()
        {
            return File.ReadAllText(_pathCredenciais);
        }

        public List<Login> AtualizarCredenciais()
        {
            string credenciais = "";

            if (!File.Exists(_pathCredenciais))
            {
                Console.ForegroundColor = ConsoleColor.Cyan;
                Console.WriteLine($"    É necessário criar um usuário e senha para o primeiro acesso");
                Console.ResetColor();

                FileStream fileStream = File.Create(_pathCredenciais);
                fileStream.Close();
                AdicionarCredencial();
            }
            else
            {
                credenciais = jsonCredenciais();
            }

            return JsonConvert.DeserializeObject<List<Login>>(credenciais);
        }

        private void AdicionarCredencial()
        {
            AtualizarCredenciais();
            string novoUsuario = ValidarUsuario();
            string novaSenha = ValidarSenha();
            Login login = new Login(novoUsuario, novaSenha);
            AdicionarLogin(login);
            Console.Clear();

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine($"    Usuario e senha registrados com sucesso.\n");
            Console.ResetColor();
        }

        public void AdicionarLogin(Login login)
        {
            List<Login> novaCredencial = new List<Login>();

            novaCredencial.Add(login);
            var novasCredenciais = JsonConvert.SerializeObject(novaCredencial);

            File.WriteAllText(_pathCredenciais, novasCredenciais);
        }

        private string ValidarUsuario()
        {
            string novoUsuario = "";
            string confirmarUsuario = "";

            do
            {
                Console.WriteLine($"    Digite seu usuário com no mínimo 6 caracteres.");
                novoUsuario = Console.ReadLine()!;

                while (!validarTamanhoUsuarioOuSenha(novoUsuario))
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine($"   Por questões de segurança digite outro usuário com no mínimo 6 caracteres", ConsoleColor.Red);
                    Console.ResetColor();

                    novoUsuario = Console.ReadLine()!;
                }

                Console.WriteLine($"    Repita o usuário para confirmar.");
                confirmarUsuario = Console.ReadLine()!;

                Console.ForegroundColor = ConsoleColor.Red;
                if (novoUsuario != confirmarUsuario) Console.WriteLine($"    Usuários não conferem");
                Console.ResetColor();

            } while (novoUsuario != confirmarUsuario);
            return novoUsuario;
        }

        private static string ValidarSenha()
        {
            string senhaCliente = "";
            string confirmaSenha = "";

            do
            {
                Console.WriteLine($"    digite uma senha com no mínimo 6 caracteres.");
                senhaCliente = LerSenha()!;

                while (!validarTamanhoUsuarioOuSenha(senhaCliente))
                {
                    Console.ForegroundColor = ConsoleColor.Red; ;
                    Console.WriteLine($"    Por questões de segurança adicione outra senha:");
                    Console.ResetColor();
                    senhaCliente = LerSenha()!;
                }

                Console.WriteLine($"    Repita a senha para confirmar.");
                confirmaSenha = LerSenha()!;

                Console.ForegroundColor = ConsoleColor.Red;
                if (senhaCliente != confirmaSenha) Console.WriteLine($"    As senhas não conferem");
                Console.ResetColor();

            } while (senhaCliente != confirmaSenha);
            return senhaCliente;
        }

        private static string LerSenha()
        {
            List<char> senha = new List<char>();
            while (true)
            {
                ConsoleKeyInfo tecla = Console.ReadKey(true);

                if (tecla.Key == ConsoleKey.Enter)
                {
                    break;
                }

                if (tecla.Key == ConsoleKey.Backspace)
                {
                    int posicaoX = Console.CursorLeft;
                    int posicaoY = Console.CursorTop;

                    if (senha.Count() > 0)
                    {
                        Console.SetCursorPosition(posicaoX - 1, posicaoY);
                        Console.Write(" ");
                        Console.SetCursorPosition(posicaoX - 1, posicaoY);
                        Console.Write("");
                        senha.RemoveAt(senha.Count() - 1);
                    }
                }
                else
                {
                    senha.Add(tecla.KeyChar);
                    Console.Write("*");
                }
            }
            System.Console.WriteLine();
            return string.Join("", senha);
        }

        private static bool validarTamanhoUsuarioOuSenha(string usuarioOuSenha)
        {
            if (usuarioOuSenha.Length < 6) return false;

            if (string.IsNullOrEmpty(usuarioOuSenha)) return false;

            return true;
        }

        public bool AutenticarUsuario()
        {
            if (!File.Exists(_pathCredenciais)) AtualizarCredenciais();
            /**

                Utilizamos uma dependencia NewtonJson para Deserializar os arquivos de credenciais, percorrendo e retornando true caso usuario consiga logar com sucesso, caso contrario será lançada uma nova excessão com a mensagem especifica.

            */
            bool usuarioLogado = false;

            do
            {
                Console.WriteLine($"    Por gentileza, digite seu usuário.");
                var usuario = Console.ReadLine()!;

                Console.WriteLine($"    Digite a senha, por favor.");
                var senha = LerSenha()!;

                try
                {
                    foreach (var credencial in AtualizarCredenciais())
                    {
                        if (credencial.Usuario == usuario && credencial.Senha == senha)
                        {
                            Console.ForegroundColor = ConsoleColor.Green;
                            Console.WriteLine($"    Login realizado com sucesso.");
                            Console.ResetColor();
                            Thread.Sleep(2000);
                            Console.Clear();
                            
                            usuarioLogado = true;
                            break;
                        }

                        Console.ForegroundColor = ConsoleColor.Red;
                        if (!usuarioLogado) Console.WriteLine($"    Usuário ou senha inválido");
                        Console.ResetColor();
                    }
                }
                catch (System.Exception erro)
                {
                    throw new Exception(erro.Message);
                }

            } while (!usuarioLogado);

            return usuarioLogado;
        }
    }
}