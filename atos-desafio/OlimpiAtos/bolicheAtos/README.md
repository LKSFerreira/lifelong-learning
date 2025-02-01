# Jogo de Boliche: Calculadora de Pontuação

Este projeto implementa um algoritmo para calcular a pontuação de um jogo de boliche, além de explorar a tecnologia de embedding para integração e execução de código em uma plataforma externa.

Implementação: https://lksferreira.github.io/bolicheAtos

## Descrição do Algoritmo

O jogo de boliche consiste em 10 frames, onde cada frame pode resultar em um strike, spare ou open frame:

- **Strike:** Derruba todos os 10 pinos no primeiro arremesso. Pontuação = 10 + número de pinos derrubados nos próximos 2 arremessos.
- **Spare:** Derruba todos os 10 pinos com dois arremessos. Pontuação = 10 + número de pinos derrubados no próximo arremesso.
- **Open Frame:** Derruba menos de 10 pinos em dois arremessos. Pontuação = número de pinos derrubados.

No décimo frame, há regras especiais para strikes e spares, onde bolas extras podem ser concedidas.

## Funcionalidades Implementadas

```python
class JogoDeBoliche:
    def __init__(self):
        self.arremessos = []  # Lista para armazenar o número de pinos derrubados em cada arremesso
        self.frame_atual = 0  # Contador para acompanhar o frame atual do jogo

    def arremesso(self, pinos: int):
        """Registra o número de pinos derrubados em um arremesso."""
        self.arremessos.append(pinos)

    def pontuacao(self) -> int:
        """Calcula e retorna a pontuação total do jogo de boliche."""

        pontuacao_total = 0  # Inicializa a pontuação total
        indice_arremesso = 0  # Inicializa o índice para percorrer a lista de arremessos

        for frame in range(10):  # Loop para processar os 10 frames do jogo
            if indice_arremesso >= len(self.arremessos):
                break

            if self._eh_strike(indice_arremesso):  # Verifica se foi um strike
                pontuacao_total += 10 + self._bonus_strike(indice_arremesso)
                indice_arremesso += 1
            elif self._eh_spare(indice_arremesso):  # Verifica se foi um spare
                pontuacao_total += 10 + self._bonus_spare(indice_arremesso)
                indice_arremesso += 2
            else:  # Caso não seja strike nem spare, calcula os pontos do frame
                pontuacao_total += self._pontos_frame(indice_arremesso)
                indice_arremesso += 2

        return pontuacao_total

    def _eh_strike(self, indice_arremesso: int) -> bool:
        """Verifica se o arremesso atual foi um strike."""
        return indice_arremesso < len(self.arremessos) and self.arremessos[indice_arremesso] == 10

    def _eh_spare(self, indice_arremesso: int) -> bool:
        """Verifica se o arremesso atual foi um spare."""
        return (indice_arremesso + 1 < len(self.arremessos) and
                self.arremessos[indice_arremesso] + self.arremessos[indice_arremesso + 1] == 10)

    def _bonus_strike(self, indice_arremesso: int) -> int:
        """Calcula o bônus para um strike."""
        if indice_arremesso + 2 < len(self.arremessos):
            return self.arremessos[indice_arremesso + 1] + self.arremessos[indice_arremesso + 2]
        return 0

    def _bonus_spare(self, indice_arremesso: int) -> int:
        """Calcula o bônus para um spare."""
        if indice_arremesso + 2 < len(self.arremessos):
            return self.arremessos[indice_arremesso + 2]
        return 0

    def _pontos_frame(self, indice_arremesso: int) -> int:
        """Calcula os pontos de um frame que não foi strike nem spare."""
        if indice_arremesso + 1 < len(self.arremessos):
            return self.arremessos[indice_arremesso] + self.arremessos[indice_arremesso + 1]
        return 0

# Função para obter entrada do usuário com validação
def obter_entrada(mensagem: str) -> int:
    """Função para obter entrada do usuário e validar se é um número inteiro."""
    while True:
        entrada = input(mensagem)
        if entrada.isdigit():
            return int(entrada)
        else:
            print("Entrada inválida. Por favor, digite um número.")

# Função principal para interação com o usuário
def main():
    jogo = JogoDeBoliche()
    print("Bem-vindo ao jogo de boliche!")

    # Loop para processar cada frame do jogo
    for frame in range(10):
        print(f"\nFrame {frame + 1}")

        # Primeiro arremesso do frame
        pinos = obter_entrada("Digite o número de pinos derrubados no primeiro arremesso: ")
        jogo.arremesso(pinos)

        # Segundo arremesso do frame (se não for um strike)
        if pinos < 10:
            pinos = obter_entrada("Digite o número de pinos derrubados no segundo arremesso: ")
            jogo.arremesso(pinos)

        # Caso especial para o 10º frame, onde podem ocorrer bolas extras
        if frame == 9:
            if jogo.arremessos[-1] == 10 or (len(jogo.arremessos) >= 2 and jogo.arremessos[-1] + jogo.arremessos[-2] == 10):
                pinos = obter_entrada("\nDigite o número de pinos derrubados na bola extra: ")
                jogo.arremesso(pinos)
                if jogo.arremessos[-2] == 10:
                    pinos = obter_entrada("\nDigite o número de pinos derrubados na segunda bola extra: ")
                    jogo.arremesso(pinos)

    # Exibe a pontuação total do jogo ao final
    print(f"\nPontuação total do jogo: {jogo.pontuacao()}")

# Executa a função principal ao iniciar o script
if __name__ == "__main__":
    main()
```

- **`arremesso(pinos: int)`**: Registra o número de pinos derrubados em cada arremesso.
- **`pontuação() -> int`**: Calcula e retorna a pontuação total do jogo ao final.

### Exemplos de Pontuação

Exemplo de uma partida de boliche com três frames:

```plaintext
1. Frame 1 → X (strike)
2. Frame 2 → 5/ (spare)
3. Frame 3 → 9 0 (open frame)
```

Pontuação:

- Frame 1: 10 (strike) + 5 (arremesso 1 do Frame 2) + 5 (arremesso 2 do Frame 2) = 20
- Frame 2: 5 (arremesso 1 do Frame 2) + 5 (arremesso 2 do Frame 2) + 9 (arremesso 1 do Frame 3) = 19
- Frame 3: 9 + 0 = 9

Pontuação total: 20 + 19 + 9 = 48

## Demonstração de Embedding

Este projeto utiliza a plataforma Trinket.io para demonstrar a execução de código Python incorporado em uma página web. O exemplo prático é a integração do jogo de boliche com a plataforma de embedding, mostrando como diferentes tecnologias podem ser integradas para oferecer uma experiência interativa.

### Exemplo Prático

Veja abaixo um exemplo de como o código pode ser incorporado e executado diretamente em uma página web:

```html
<iframe src="https://trinket.io/embed/python3/2326706fd8" width="100%" height="356" frameborder="0" marginwidth="0" marginheight="0" allowfullscreen></iframe>
```

Ao incorporar este iframe em sua página, você pode permitir que os usuários interajam com o jogo de boliche e vejam a pontuação sendo calculada em tempo real.

## Riscos e Considerações

Embora o embedding de código externo ofereça flexibilidade e funcionalidades avançadas, há alguns pontos de atenção a serem considerados:

- **Segurança:** Incorporar código de terceiros pode introduzir vulnerabilidades de segurança se não forem tomadas precauções adequadas.
  
- **Dependência Externa:** Dependendo da plataforma de embedding, pode haver limitações de desempenho, estabilidade ou disponibilidade que afetam a experiência do usuário final.
  
- **Compatibilidade:** Garantir que o código incorporado funcione corretamente em diferentes navegadores e dispositivos pode ser um desafio técnico.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para forkar este projeto, fazer melhorias e enviar um pull request.
