// Definição da classe Animal
class Animal {
    // Atributos e métodos da classe Animal
    public void comer() {
        System.out.println("Este animal está comendo.");
    }
}

// Definição da classe Cachorro que herda de Animal
class Cachorro extends Animal {
    // Atributos e métodos específicos da classe Cachorro
    public void latir() {
        System.out.println("Este cachorro está latindo.");
    }
}

// Classe principal para testar as classes Animal e Cachorro
public class Main {
    public static void main(String[] args) {
        // Criação de um objeto da classe Cachorro
        Cachorro cachorro = new Cachorro();
        
        // Verificação usando pattern matching for instanceof
        if (cachorro instanceof Animal animal) {
            // Não é necessário fazer o casting explícito
            System.out.println("Casting realizado com sucesso. " + animal);
        } else {
            System.out.println("O objeto não é do tipo Animal.");
        }
    }
}