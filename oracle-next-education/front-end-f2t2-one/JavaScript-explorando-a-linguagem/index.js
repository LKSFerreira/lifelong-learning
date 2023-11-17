import { Cliente } from "./Cliente.js";
import { Diretor } from "./Funcionario/Diretor.js";
import { Gerente } from "./Funcionario/Gerente.js"
import { SistemaAutenticacao } from "./SistemaAutenticacao.js";

const diretor = new Diretor("Lucas", 6200, "39009917824");
diretor.cadastrarSenha("123456");
const diretorEstaLogado = SistemaAutenticacao.login(diretor, "123456");

const gerente = new Gerente("Vany", 4000, "07562371571");
gerente.cadastrarSenha("123");
const gerenteEstaLogado = SistemaAutenticacao.login(diretor, "123456");

const cliente = new Cliente ("Laiz", "12345678900", "2012")
SistemaAutenticacao.login(diretor, "123456789");
const clienteEstaLogado = SistemaAutenticacao.login(cliente, "2012");

console.log(gerenteEstaLogado, diretorEstaLogado);
console.log(clienteEstaLogado);
