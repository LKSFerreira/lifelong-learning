# Módulo 2 - Aulas 1 e 2

## Módulo 2: Ameaças, malwares e controles

## Aula 1: Tipos de malware

### **Objetivos**

* [ ] Compreender os diferentes tipos de malware com base em sua classificação.
* [ ] Identificar exemplos de cada tipo de malware e seu modo de operação.
* [ ] Conscientizar os alunos sobre a importância da prevenção contra ameaças de malware.

### **Conceitos**

* [ ] Malware e sua classificação por critérios como vetor, propósito e payload.
* [ ] Vírus e worms, trojans e programas potencialmente indesejados (PUPs).
* [ ] Spyware e keyloggers, backdoors, rootkits e ransomware.

### **Introdução**

Bem-vindos à aula sobre tipos de malware! Nesta aula, o tema "malware" — ou software malicioso — será abordado quanto à sua classificação. Essa é uma das principais armas dos cibercriminosos. A compreensão dos diferentes tipos de malware é fundamental para a proteção dos sistemas, redes e informações sensíveis.

Ao longo das próximas duas horas, exploraremos os tipos de malware com base em três critérios-chave: o vetor de propagação, o propósito de sua existência e o payload que carrega consigo. Durante este tempo, abordaremos definições, modos de operação e exemplos ilustrativos de cada tipo de malware para que vocês possam compreender as ameaças às quais estão expostos e como se proteger contra elas.

A segurança cibernética é um campo em constante mutação, e a conscientização e o conhecimento são as primeiras linhas de defesa. Ao final desta aula, esperamos que todos saiam com uma compreensão mais sólida sobre os perigos representados por malware e com insights sobre como se proteger e manter os sistemas seguros.

#### **Classificação de malware**

Muitas das tentativas de intrusão perpetradas contra redes de computadores dependem do uso de software malicioso ou malware. Malware geralmente é definido simplesmente como software que faz algo ruim, da perspectiva do proprietário do sistema. Existem muitos tipos de malware, mas eles não são classificados de forma rigorosa, por isso algumas definições se sobrepõem ou ficam confusas. Algumas classificações de malware, como Trojan, vírus e worm, concentram-se no vetor usado pelo malware. O vetor é o método pelo qual o malware é executado em um computador e potencialmente se espalha para outros hosts da rede.

Outras classificações são baseadas na carga entregue pelo malware. A carga útil (payload) é uma ação executada pelo malware que não é simplesmente replicar ou persistir em um host. Exemplos de classificações de carga útil incluem spyware, rootkit, Trojan de acesso remoto (RAT) e ransomware.

![Tipos de malware.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-35846fa0073501eae036ea2c00ff5f6596652d0d%2F3-1-Malware.png?alt=media)

#### **Classificação de malware de acordo com o vetor**

As categorias a seguir descrevem alguns tipos de malware de acordo com o vetor:

1. **Vírus**: representam alguns dos primeiros tipos de malware, e se espalham sem qualquer autorização do usuário, ficando ocultos no código executável de outro processo. Os vírus são programas maliciosos que têm sua funcionalidade anexada a outros arquivos legítimos, como executáveis, documentos ou scripts. Eles são projetados para se espalhar quando os arquivos infectados são executados. Os vírus precisam de um "hospedeiro" para se propagar, e a infecção ocorre quando o usuário abre ou executa o arquivo hospedeiro. Quando um arquivo infectado é aberto, o vírus é ativado e pode infectar outros arquivos no mesmo sistema.

* **Modo de Operação**: os vírus se anexam a arquivos executáveis, documentos ou scripts, e se espalham quando esses arquivos são compartilhados ou abertos.
* **Exemplos**: o vírus "ILOVEYOU" se espalhou por meio de anexos de e-mail em 2000, causando grandes danos. Outro exemplo é o vírus "Melissa".

2. **Worms**: são programas maliciosos autônomos que não precisam de um arquivo hospedeiro para se propagar. Eles são projetados para se replicar e se espalhar por redes e sistemas. Diferentemente dos vírus, os worms não se anexam a arquivos existentes, o que os torna mais independentes e autônomos.

* **Modo de operação**: os worms exploram vulnerabilidades de segurança em sistemas e redes para se propagar. Eles podem se transmitir por meio de redes de computadores, dispositivos USB e até mesmo pela internet. Uma vez em um sistema, um worm pode se replicar automaticamente e transmitir-se a outros sistemas na rede.
* **Exemplos**: o worm "Conficker” (executa o que é chamado de "ataque de dicionário") é um exemplo notório de um worm que se espalhou amplamente, explorando vulnerabilidades no Windows. O "SQL Slammer" (causou um “ataque de negação de serviço") é outro exemplo notório de worm que se propagou rapidamente pela internet, explorando uma vulnerabilidade no Microsoft SQL Server.

3. **Trojan**: malware oculto em um pacote de instalação de software que parece ser legítimo. Trojans ou cavalos de Troia são um tipo de malware que se disfarça como software legítimo ou benigno para enganar os usuários e, assim, ganhar acesso a sistemas ou realizar ações maliciosas. Eles são nomeados em referência ao famoso episódio da Guerra de Troia na mitologia grega, quando os gregos esconderam soldados dentro de um cavalo de madeira gigante para infiltrá-los na cidade de Troia.

* **Modo de operação**: a principal característica dos Trojans é a sua capacidade de enganar os usuários, fazendo com que estes voluntariamente instalem o malware, muitas vezes através de técnicas de engenharia social. Isso pode ocorrer de várias formas:

1. **Falsos programas ou aplicativos**: os Trojans são frequentemente disfarçados como software legítimo, como programas antivírus falsos, jogos, ou utilitários.
2. **Anexos de e-mail**: os cibercriminosos podem enviar emails com anexos maliciosos que parecem legítimos, levando o destinatário a abri-los.
3. **Links maliciosos**: links em sites, e-mails ou mensagens que redirecionam para a instalação de um Trojan.
4. **Funcionalidades maliciosas**: uma vez que um Trojan está ativo em um sistema, ele pode realizar uma variedade de ações maliciosas, incluindo, mas não se limitando a:

* Roubo de informações: coleta de senhas, dados pessoais, informações financeiras e outros dados sensíveis.
* Acesso remoto: abre uma porta de acesso para um invasor, permitindo o controle não autorizado do sistema afetado.
* Destruição de dados: pode corromper ou excluir arquivos e pastas.
* Espionagem e monitoramento: pode registrar a atividade do usuário, incluindo teclas digitadas (keyloggers) e capturas de tela.
* **Exemplos**: trojans vêm em muitas formas e tamanhos, e existem inúmeras variantes. Alguns exemplos notórios incluem:
* Zeus Trojan: focado em roubo de informações financeiras e bancárias.
* RAT (Remote Access Trojan): projetado para fornecer acesso remoto a um sistema comprometido.
* Backdoor trojans: abrem portas de acesso não autorizado em sistemas comprometidos.
* Trojans de download: baixam e instalam outros malware no sistema.

4. **Programas Potencialmente Indesejados (PUPs) / Aplicativos Potencialmente Indesejados (PUAs)**: software instalado junto com um pacote selecionado pelo usuário ou talvez empacotado com um novo sistema de computador. Ao contrário de um trojan, a presença de um PUP não é automaticamente considerada maliciosa. Ele pode ter sido instalado sem consentimento ativo ou consentimento de um contrato de licença propositalmente confuso. Esse tipo de software às vezes é descrito como grayware em vez de malware. Apesar de não serem estritamente maliciosos, podem causar problemas de segurança ou privacidade. Eles frequentemente acompanham a instalação de software legítimo e realizam atividades indesejadas, como exibição de anúncios invasivos.

* **Modo de operação**: PUPs são frequentemente instalados como parte de pacotes de software e realizam ações intrusivas sem o consentimento do usuário.
* **Exemplos**: barras de ferramentas de navegador, extensões suspeitas, programas de otimização de sistema que fazem mais mal do que bem.

![Malware por vetor.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-6ecc17190e9bb3b469dedbb67b93b12316ba2ae4%2F3-1-VetorMalware.png?alt=media)

#### **Classificação de malware pelo propósito**

Os primeiros vírus e worms focaram no potencial destrutivo fazendo da sua capacidade de replicação. À medida que os usos lucrativos desse software se tornaram conhecidos, eles começaram a ser codificados com cargas projetadas para facilitar invasões, fraudes e roubo de dados.

A ameaça representada por spyware e keyloggers é evidente, uma vez que eles podem resultar na exposição de informações altamente confidenciais e causar sérios danos financeiros e de privacidade. Para se proteger contra essas ameaças, é essencial utilizar software antivírus e antimalware confiáveis, manter sistemas e aplicativos atualizados, evitar downloads de fontes não confiáveis e ter cautela ao abrir anexos de e-mail ou clicar em links suspeitos. Vários tipos de código indesejado e malware realizam algum nível de monitoramento:

1. **Spyware**: é um tipo de malware projetado para coletar informações pessoais e confidenciais de um sistema, muitas vezes sem o consentimento do usuário. Essas informações podem incluir histórico de navegação, senhas, informações bancárias e muito mais. O objetivo principal do spyware é o monitoramento não autorizado e a coleta de dados sensíveis. Este é um malware que pode rastrear linhas de adware, mas também monitorar a atividade local de aplicativos, fazer capturas de tela e ativar dispositivos de gravação, como microfone ou webcam. Outra técnica de spyware é redirecionar DNS para sites pharming.

* **Modo de operação**:
* Infecção: o spyware pode ser instalado em um sistema por meio de downloads de software, anexos de email, links maliciosos ou explorando vulnerabilidades do sistema.
* Monitoramento: uma vez instalado, o spyware monitora a atividade do usuário, coletando informações sem o conhecimento ou consentimento do usuário.
* Transmissão de dados: as informações coletadas são geralmente transmitidas para um servidor controlado pelo atacante, onde podem ser usadas para fins maliciosos, como roubo de identidade ou fraude financeira.
* **Exemplos**:
* Adware: um tipo comum de spyware que exibe anúncios indesejados e coleta informações sobre os hábitos de navegação do usuário para exibir anúncios direcionados.
* Superfish: um spyware que foi pré-instalado em alguns laptops Lenovo para fins de publicidade, mas acabou expondo os usuários a vulnerabilidades de segurança.

2. **Keyloggers**: keyloggers — ou registradores de teclas — são um subconjunto de spyware que se concentra em registrar todas as teclas digitadas pelo usuário. Isso inclui senhas, mensagens, detalhes de cartão de crédito e qualquer outra informação digitada no teclado do computador. Esses dados são frequentemente enviados para um servidor controlado pelo invasor. Um keylogger tenta roubar informações confidenciais gravando as teclas digitadas. O invasor geralmente espera descobrir senhas de dados de cartão de crédito.

* **Modo de operação**:
* Instalação: keyloggers podem ser instalados da mesma forma que o spyware, frequentemente por meio de downloads de software comprometidos ou anexos de e-mail.
* Gravação de teclas: uma vez ativados, os keyloggers registram todas as teclas digitadas pelo usuário, incluindo senhas e informações confidenciais.
* Transmissão de dados: os dados registrados são enviados para um servidor remoto, onde o invasor pode acessar as informações capturadas.
* **Exemplos**:
* Zeus: um keylogger notório que foi usado para roubar informações bancárias, senhas e credenciais financeiras de inúmeras vítimas.
* HawkEye Keylogger: um keylogger que se espalhou por meio de kits de exploração e foi usado para roubar informações de login e credenciais sensíveis.

3. **Outros tipos de malware desta categoria**:

* **Cookies de rastreamento (tracking cookies)**: cookies são arquivos de texto simples e não malware, mas se as configurações do navegador permitirem cookies de terceiros, eles podem ser usados para registrar páginas visitadas, consultas de pesquisa, metadados do navegador e endereço IP. Os cookies de rastreamento são criados por anúncios e widgets analíticos incorporados em muitos sites.
* **Adware**: essa é uma classe de PUP/grayware que realiza reconfigurações do navegador, como permitir cookies de rastreamento, alterar provedores de pesquisa padrão, abrir páginas de patrocinadores na inicialização, adicionar marcadores e assim por diante. O adware pode ser instalado como um programa ou como uma extensão/plug-in do navegador.

![Malware por propósito.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-03010f92e940c5c8c4bc673f1f074067e323e853%2F3-1-Prop%C3%B3sitoMalware.png?alt=media)

#### **Classificação de malware de acordo com o payload**

Nesta parte da classificação de malware, veremos alguns tipos de malware com base no seu payload, que se refere à ação específica que o malware executa em um sistema comprometido. Vamos examinar três categorias distintas de malware de acordo com seu payload:

1. **Backdoors e trojans de acesso remoto**: são tipos de malware que fornecem a um invasor acesso não autorizado a um sistema comprometido. Eles abrem "portas dos fundos" (backdoors) no sistema, permitindo que um invasor controle e manipule o sistema remotamente. Qualquer tipo de método de acesso a um host que contorne o método de autenticação usual e forneça controle administrativo ao usuário remoto pode ser chamado de backdoor. Um trojan de acesso remoto (RAT) é um malware backdoor que imita a funcionalidade de programas remotos legítimos, mas é projetado especialmente para operar secretamente. Depois que o RAT é instalado, ele permite que o agente da ameaça acesse o host, carregue arquivos e instale software ou use técnicas de “live off the land (viver fora da terra)” para efetuar novos comprometimentos.

Um host comprometido pode ser instalado com um ou mais bots (robôs). Um bot é um script ou ferramenta automatizada que executa a atividade maliciosa. Um grupo de bots, que estão todos sob o controle da mesma instância de malware, pode ser manipulado como uma botnet (rede de robôs) pelo programa líder. Uma botnet pode ser usada para muitos tipos de propósitos maliciosos, incluindo o acionamento de ataques distribuídos de negação de serviço (DDoS), lançando campanhas de spam ou realizando criptomineração.

* **Modo de operação**:
* Infecção: esses tipos de malware frequentemente se disfarçam como programas legítimos ou são instalados junto com software confiável. Uma vez que o sistema está comprometido, eles criam uma conexão com um servidor controlado pelo atacante.
* Acesso remoto: o atacante pode, então, assumir o controle do sistema comprometido, executar comandos, acessar arquivos e realizar outras ações maliciosas sem o conhecimento do usuário.
* Uso malicioso: os invasores podem usar backdoors e trojans de acesso remoto para roubar informações, espionar o usuário, implantar malware adicional ou até mesmo desativar sistemas.
* **Exemplos**:
* RAT (Remote Access Trojan): exemplos incluem o RAT DarkComet e o NetBus. Esses Trojans de acesso remoto são usados por invasores para controlar sistemas remotamente.
* BackOrifice: um famoso exemplo de backdoor que permite o controle remoto de sistemas comprometidos.

![Backdoor attack.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-6871f7a836bbd216e1b18306a25f7f952669b1d8%2F3-1-Backdoor.png?alt=media)

2. **Rootkits**: são malwares projetados para se esconder no sistema, tornando-se difíceis de detectar e remover. Eles costumam se enraizar no nível mais profundo do sistema operacional, o kernel, e podem esconder outros tipos de malware.

* **Modo de operação**:
* Infecção: os rootkits são frequentemente instalados como parte de um ataque de malware mais amplo. Eles ocultam atividades maliciosas, processos e arquivos.
* Persistência: os rootkits têm a capacidade de manter-se ativos mesmo após reinicializações do sistema e atualizações de software.
* Ocultação de atividades maliciosas: é usada para esconder a presença de malware no sistema, dificultando a detecção por software de segurança.
* **Exemplos**: existem exemplos de rootkits que podem residir no firmware (seja o firmware do computador ou o firmware de qualquer tipo de placa adaptadora, disco rígido, unidade removível ou dispositivo periférico). Eles podem sobreviver a qualquer tentativa de remover o rootkit formatando a unidade e reinstalando o sistema operacional. Por exemplo, as agências de inteligência dos EUA desenvolveram os rootkits DarkMatter e QuarkMatter EFI direcionados ao firmware de laptops Apple Macbook.
* Sony BMG Rootkit: um exemplo notório, a Sony BMG instalou um rootkit em CDs de música para impedir a cópia não autorizada de faixas, o que levou a problemas de segurança.
* TDL-4: um rootkit notório usado para ocultar botnets e atividades maliciosas.

![Rootkit.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-b11c3f56ab1f320eee06a5b904f1bc7dc8e019bb%2F3-1-Rootkit.png?alt=media)

3. **Ransomware**: é um tipo de malware que criptografa os arquivos ou sistemas de um computador, tornando-os inacessíveis. Os invasores, então, exigem um resgate (ransom) em troca da chave de descriptografia, geralmente em moedas digitais, como Bitcoin. O termo "ransomware" deriva da extorsão de dinheiro (ransom) exigida das vítimas. O Ransomware pode causar danos significativos, não apenas bloqueando o acesso a arquivos e sistemas, mas também interrompendo operações comerciais e resultando em perda de dados irreparável. As vítimas que optam por pagar o resgate não têm garantia de que receberão a chave de descriptografia ou que seus dados não serão comprometidos de alguma forma.

* **Modo de operação**:
* Infecção: o Ransomware geralmente é distribuído por meio de anexos de e-mail maliciosos, downloads de software comprometido, sites infectados ou exploração de vulnerabilidades em sistemas desatualizados.
* Criptografia: uma vez no sistema da vítima, o Ransomware criptografa arquivos pessoais, como documentos, imagens e vídeos, bem como sistemas inteiros. A chave de descriptografia é mantida sob controle do invasor.
* Resgate: o invasor exige um resgate em troca da chave de descriptografia. As instruções geralmente são exibidas em uma mensagem na tela da vítima. O pagamento deve ser feito em moedas digitais, que proporcionam maior anonimato ao invasor.
* **Exemplos**:
* WannaCry: em 2017, o WannaCry se espalhou globalmente, afetando hospitais, empresas e instituições governamentais em todo o mundo. Foi um dos ataques de ransomware mais devastadores da história.
* CryptoLocker: um dos primeiros ransomware notórios, que surgiu em 2013, e foi responsável por extorquir grandes quantias de dinheiro de vítimas.
* Ryuk: usado em ataques direcionados contra empresas e organizações, o Ryuk é conhecido por exigir resgates substanciais.

![Ransomware.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-a1702b9c27a21d27c908bf9000851f90f86e4eb1%2F3-1-Ransomware.png?alt=media)

4. **Cripto-malware**: O cripto-malware, ou criptomalware, é um tipo específico de malware que utiliza técnicas de criptografia para prejudicar ou comprometer sistemas, arquivos ou informações. Diferentemente do ransomware, que criptografa arquivos para extorquir um resgate, o cripto-malware visa prejudicar ou ocultar informações, muitas vezes sem uma demanda monetária direta. O cripto-malware pode resultar em perda de dados irreparável, danificar sistemas, interromper operações comerciais e comprometer a privacidade das vítimas. Ocasionalmente, o cripto-malware pode ser usado como parte de ataques mais amplos, como a infiltração de sistemas para espionagem ou roubo de dados.

* **Modo de operação**:
* Infecção: o Cripto-Malware é distribuído de maneira semelhante a outros tipos de malware, geralmente por meio de anexos de e-mail maliciosos, downloads de software comprometido ou exploração de vulnerabilidades em sistemas desatualizados.
* Criptografia destrutiva: ao contrário do ransomware, que oferece a chave de descriptografia em troca de um resgate, o cripto-malware pode criptografar arquivos ou sistemas simplesmente para causar danos. As chaves de descriptografia não são fornecidas.
* Ocultação de atividades maliciosas: em algumas variantes, o cripto-malware é usado para ocultar atividades maliciosas em sistemas, tornando a detecção mais difícil.
* **Exemplos**:
* CryptoLocker: embora mais conhecido como um ransomware, o CryptoLocker também pode ser considerado cripto-malware, uma vez que criptografa arquivos sem fornecer a chave de descriptografia. Uma variante do CryptoLocker, chamada "LockerGoga," é um exemplo de cripto-malware destrutivo que visava organizações empresariais.
* NotPetya (ExPetr/Petya/SortaPetya): este malware foi inicialmente identificado como ransomware, mas na verdade, agiu como cripto-malware, pois destruía os dados em vez de fornecer uma maneira de recuperá-los. Também foi associado a um ataque cibernético massivo que afetou empresas e governos em 2017.

5. **Bombas lógicas (logic bombs)**: são programas ou trechos de código maliciosos projetados para executar ações prejudiciais em um sistema em resposta a uma condição ou evento específico. Elas são uma forma de malware que não é ativada até que um gatilho pré-determinado seja acionado. A analogia com uma "bomba" se refere ao potencial destrutivo que está adormecido até que seja ativado. Bombas lógicas são frequentemente usadas por insiders maliciosos, como funcionários de uma organização, para causar danos deliberados quando suas condições de emprego ou situação mudam. Elas também podem ser incorporadas em malware mais amplo como parte de ataques cibernéticos.

* **Modo de operação**:
* Infecção: uma bomba lógica pode ser introduzida em um sistema como parte de um programa legítimo, código-fonte ou até mesmo como parte de uma operação criminosa.
* Ativação por gatilho: a bomba lógica permanece inativa até que uma condição específica seja atendida. Essa condição pode ser uma data e hora específicas, uma ação específica do usuário, a presença ou ausência de um arquivo, entre outros eventos.
* Ação maliciosa: quando o gatilho é acionado, a bomba lógica executa uma ação maliciosa predeterminada, que pode incluir a exclusão de arquivos críticos, a corrupção de dados, a disseminação de malware adicional ou outros danos ao sistema.
* **Exemplos**:
* Stuxnet: o worm Stuxnet é um exemplo notório que continha uma bomba lógica que foi ativada quando detectou que estava em um ambiente de controle industrial específico. Ela foi usada para atacar sistemas de enriquecimento de urânio no Irã.
* Mydoom: um worm que continha uma bomba lógica para lançar um ataque distribuído de negação de serviço (DDoS) em um determinado dia.

![Bomba lógica.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-c022c9c9394844e852c4a4f5d5b8f529191a6f24%2F3-1-BombaL%C3%B3gica.png?alt=media)

### **Conclusão**

Parabéns a todos por terem finalizado a aula de tipos de malware! Na aula 2.1, exploramos uma variedade de tipos de malware e suas classificações com base em diferentes critérios, como vetor, propósito e payload. Essa compreensão é fundamental para qualquer pessoa que deseja entender as ameaças cibernéticas e adotar medidas eficazes de segurança cibernética.

No primeiro tópico, classificamos malware com base em seu vetor de infecção, examinando vírus, worms, irojans e programas potencialmente indesejados (PUPs). Compreendemos como cada um deles se espalha e opera, identificando exemplos notórios dessas categorias.

No segundo tópico, exploramos o propósito do malware, com foco em spyware e keyloggers. Aprendemos como essas ameaças são projetadas para coletar informações pessoais e monitorar a atividade do usuário, com exemplos de spyware e keyloggers amplamente conhecidos.

No terceiro tópico, abordamos o payload do malware, classificando ameaças com base em seus efeitos. Discutimos backdoors, trojans de acesso remoto, rootkits, ransomware, cripto-malware e bombas lógicas. Compreendemos como essas ameaças funcionam e suas implicações.

É importante destacar que a segurança cibernética é uma preocupação. Algumas práticas de segurança importantes incluem a manutenção de software atualizado, o uso de software antivírus e antimalware confiáveis, a educação sobre práticas seguras de navegação na internet e o backup regular de dados.

## Aula 2: Análise de indicadores e prevenção de malware

### **Objetivos**

* [ ] Compreender os indicadores de malware e aprender como analisá-los.
* [ ] Explorar técnicas e ferramentas de análise de processos.
* [ ] Aprender sobre estratégias de prevenção e mitigação de malware.

### **Conceitos**

* [ ] Indicadores de malware, antivírus e sandbox.
* [ ] Análise de processo.
* [ ] Estratégias de prevenção.

### **Introdução**

O malware, uma abreviação de "software malicioso", representa uma das ameaças mais prementes que enfrentamos no ciberespaço. Ao longo desta aula, exploraremos os indicadores de malware, que são as pegadas digitais deixadas por essas ameaças invisíveis. Esses indicadores atuam como as pistas de um detetive digital, permitindo-nos identificar a presença ou atividade de software malicioso em sistemas e redes. Eles podem aparecer de várias formas, desde notificações de antivírus até mudanças no sistema de arquivos, e cada um revela informações valiosas sobre a natureza e o comportamento do malware.

A análise dos indicadores e a compreensão das técnicas de análise de processos são competências essenciais para qualquer profissional de segurança cibernética. Ao aprender a interpretar esses indicadores, você adquire a capacidade de detectar ameaças em seus estágios iniciais antes que elas causem danos substanciais. Esse conhecimento capacita você a agir de forma proativa, fortalecendo a segurança de sistemas e redes e protegendo informações confidenciais.

Além disso, nesta aula, não só exploraremos como identificar e analisar malware, mas também discutiremos estratégias de prevenção. Afinal, a melhor defesa contra ameaças cibernéticas é evitar que elas se infiltrem em nossos sistemas. Abordaremos tópicos como atualização de software, políticas de acesso e conscientização dos usuários, garantindo que você tenha uma compreensão abrangente de como mitigar riscos cibernéticos. Ao entender e aplicar esses conceitos, você não apenas se protege, mas também desempenha um papel fundamental na construção de um ciberespaço mais seguro e resiliente.

### **Análise de indicadores de malware**

#### **Indicadores de malware**

Os indicadores de malware, ou simplesmente indicadores de comprometimento (IoCs), desempenham um papel crítico na detecção, análise e prevenção de ameaças cibernéticas maliciosas, como vírus, worms, cavalos de Troia e outras formas de software mal-intencionado. São informações importantes que permitem identificar e analisar a presença de malware em sistemas e redes. Eles representam traços, pistas ou evidências deixadas pelo software malicioso em um sistema ou rede que podem ser usados para identificar a presença ou atividade desse software. Eles são como impressões digitais virtuais que permitem que os profissionais de segurança rastreiem e analisem o comportamento suspeito ou malicioso. Entender os indicadores é fundamental para compreender o escopo das ameaças cibernéticas.

Esses indicadores podem assumir várias formas, incluindo arquivos, registros de eventos, comportamento de rede, e são geralmente coletados por meio de monitoramento contínuo dos sistemas, análise de tráfego de rede, registros de eventos e outras técnicas de segurança.

Os indicadores de malware não se limitam a um único formato. Eles abrangem uma variedade de pistas que podem ser usadas para identificar a presença de software malicioso. Alguns exemplos incluem notificações de antivírus, que sinalizam a detecção de código malicioso, a execução de um ambiente de sandbox, que pode revelar tentativas de evasão; o consumo anormal de recursos do sistema e mudanças no sistema de arquivos, que podem indicar a presença de malware. Cada tipo de indicador desempenha um papel único na identificação de ameaças cibernéticas.

**Tipos de indicadores:**

1. **Notificações de antivírus**: os antivírus são uma linha de defesa crítica contra malware. As notificações de antivírus são um tipo comum de indicador de malware. Quando um antivírus identifica um arquivo ou programa como malware, ele gera uma notificação ou alerta para informar o usuário ou o administrador do sistema. A seguir, mostraremos como os antivírus identificam e notificam malware:

* **Modo de operação**: os antivírus utilizam uma variedade de técnicas, incluindo a correspondência de assinaturas, análise heurística e monitoramento de comportamento para identificar malware. Quando um antivírus detecta um arquivo ou programa suspeito, ele gera uma notificação ou alerta para informar o usuário ou administrador do sistema. Essas notificações são baseadas em padrões previamente identificados de código malicioso ou comportamento suspeito do software, permitindo ação imediata.
* **Falsos positivos e falsos negativos**: embora os antivírus sejam essenciais na detecção de malware, eles não são infalíveis. Às vezes, podem ocorrer erros de detecção, conhecidos como falsos positivos, nos quais um arquivo legítimo é erroneamente identificado como malware. Por outro lado, os falsos negativos ocorrem quando o antivírus não identifica uma ameaça genuína. Compreender essas possibilidades de erros é importante para avaliar criticamente os alertas e notificações gerados pelos antivírus.

2. **Execução de sandbox**: uma sandbox é um ambiente de isolamento controlado onde os programas e arquivos suspeitos podem ser executados com segurança. Ela é usada para analisar o comportamento do malware sem comprometer a segurança do sistema principal. Ao executar o malware em uma sandbox, os pesquisadores podem observar como ele se comporta, quais ações executa e como interage com o sistema, identificando assim possíveis ameaças.

Muitas organizações utilizam ambientes de sandbox para analisar o comportamento de arquivos ou aplicativos desconhecidos. Os indicadores de execução de sandbox referem-se a comportamentos que o malware exibe quando é executado em um ambiente de teste. Malwares frequentemente tentam detectar a presença de uma sandbox e podem alterar seu comportamento para evitar a detecção, tornando esse um indicador importante.

* **Exemplos de técnicas que malware usa para evitar detecção em ambientes de sandbox**: o software malicioso é frequentemente projetado para detectar a presença de sandboxes e pode modificar seu comportamento para evitar a detecção. Por exemplo, ele pode verificar a quantidade de recursos disponíveis, como memória ou CPU, para determinar se está sendo executado em um ambiente de teste. Além disso, pode conter mecanismos para retardar sua atividade maliciosa, dificultando a análise. Compreender essas técnicas é fundamental para garantir uma análise eficaz do malware em um ambiente de sandbox.

3. **Consumo de recursos**: o malware muitas vezes consome uma quantidade significativa de recursos do sistema. O consumo excessivo de CPU — ou consumo de memória anormal —, é um indicador importante de atividade maliciosa, uma vez que costuma utilizar os recursos para executar suas operações. Profissionais de segurança monitoram a utilização de recursos em busca de picos ou comportamentos anômalos que possam sugerir a presença de malware. Monitorar esses picos de uso de recursos pode ajudar a identificar a presença do software, permitindo uma resposta rápida.

* **Exemplos de ferramentas que monitoram o uso de recursos**: existem diversas ferramentas de monitoramento de recursos que podem ajudar a identificar o consumo anormal de recursos do sistema. Essas ferramentas permitem que os administradores e pesquisadores de segurança rastreiem de perto o desempenho do sistema e identifiquem atividades suspeitas. Alguns exemplos incluem o Monitor de Recursos do Windows e ferramentas de monitoramento de desempenho de código aberto, como o Sysinternals Suite.

4. **Mudanças no sistema de arquivos**: quando o malware infecta um sistema, ele frequentemente faz alterações no sistema de arquivos, como criar ou modificar arquivos e diretórios. Essas mudanças podem ser indicativas de atividade maliciosa, pois o malware muitas vezes busca ocultar sua presença ou realizar ações prejudiciais. Os indicadores de mudanças no sistema de arquivos envolvem o rastreamento de qualquer modificação não autorizada e o registro dessas ações como indicativos de atividade suspeita. O rastreamento dessas alterações é fundamental para a detecção precoce.

* **Ferramentas que rastreiam alterações no sistema de arquivos**: para rastrear as mudanças no sistema de arquivos, existem várias ferramentas disponíveis, como o File Integrity Monitoring (FIM) e o Tripwire. Essas ferramentas monitoram continuamente o sistema de arquivos em busca de alterações não autorizadas e fornecem alertas quando identificam atividades suspeitas. Isso permite que os administradores de sistemas ajam rapidamente para conter ameaças.

![Notificação de antivírus.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-c32c0dfc884d3b648ae84c1e30643b52390b1c28%2F3-2-Antiv%C3%ADrus.png?alt=media)

#### **Análise de processos**

A análise de processos é uma técnica que se concentra em examinar o comportamento de programas e processos em execução em sistemas e redes. Pode envolver o estudo minucioso do comportamento de aplicativos, processos e serviços em um ambiente de computação. Isso inclui mapear quais ações eles executam, como interagem com outros elementos do sistema e quais recursos utilizam. Essas ações são importantes para detectar a presença de malware, pois muitos desses softwares tentam se camuflar como processos legítimos ou exploram processos existentes para realizar suas atividades maliciosas. Entender como analisar o comportamento dos processos é essencial para identificar ameaças cibernéticas em suas fases iniciais e tomar ações apropriadas.

**Técnicas de análise baseada em comportamento:**

Agora, veremos as técnicas de análise baseada em comportamento, que são fundamentais para entender o que os processos estão fazendo e detectar atividades suspeitas:

1. **Análise de tráfego de rede**: essa técnica envolve a observação e análise do tráfego de rede gerado por processos e aplicativos. Ela é usada para identificar padrões de comunicação, que podem revelar atividades suspeitas, como conexões a servidores remotos ou transmissões não autorizadas de dados.
2. **Análise de registros**: a análise de registros e logs do sistema é uma técnica crucial na detecção de atividades anômalas. Os registros, como logs de eventos do sistema ou logs de aplicativos, podem conter informações valiosas sobre ações suspeitas realizadas por processos.
3. **Monitoramento de comportamento**: é uma técnica dinâmica que permite observar o comportamento dos processos em tempo real. Essa abordagem proativa ajuda a identificar a criação de arquivos, modificações no registro do sistema, ou outras atividades suspeitas enquanto ocorrem.

![Análise de tráfego de rede.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-ed99e8283e4b0173a15be5232080f6c7c16418cc%2F3-2-An%C3%A1liseRede.png?alt=media)

**Ferramentas de análise de processos:**

A seguir, estão algumas das ferramentas mais populares e amplamente usadas para análise de processos e detecção de malware:

1. **Wireshark**: é uma ferramenta de análise de tráfego de rede de código aberto. Ela permite capturar e analisar pacotes de dados em tempo real, oferecendo insights sobre a comunicação de rede. Wireshark é uma ferramenta valiosa para identificar conexões suspeitas e comportamento malicioso na rede.
2. **Sysinternals Suite**: é um conjunto de ferramentas desenvolvidas pela Microsoft, projetadas para ajudar na análise de processos em sistemas Windows. Dentro dessa suíte, você encontrará ferramentas como o Process Explorer, Process Monitor e Autoruns, que são indispensáveis para monitorar, diagnosticar e detectar atividades suspeitas em sistemas Windows.

![Process Explorer.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-edb04ca401277af9229f4a6b9f94c148fde6adf9%2F3-2-ProcessExplorer.png?alt=media)

### **Prevenção de malware**

#### **Estratégias de prevenção**

As estratégias de prevenção de malware são medidas proativas adotadas para evitar a infecção por malware e fortalecer a segurança dos sistemas. Isso inclui uma série de práticas recomendadas que reduzem a superfície de ataque e minimizam as chances de infecção. Essas medidas podem abranger desde a configuração de políticas de segurança até a educação dos usuários. A seguir, apontaremos algumas dessas medidas:

1. **Atualização de software**: a manutenção regular e a atualização de sistemas e software são fundamentais. As atualizações frequentes garantem que os sistemas estejam protegidos contra vulnerabilidades conhecidas, reduzindo a exposição a ataques de malware.
2. **Políticas de acesso**: a implementação de políticas de acesso restrito ajuda a controlar quem tem permissão para acessar sistemas e dados sensíveis. Isso limita a exposição à malware que possa ser introduzido por usuários não autorizados.
3. **Conscientização dos usuários**: treinar os usuários para reconhecer práticas inseguras, como clicar em links suspeitos ou fazer download de anexos de e-mail desconhecidos, é uma parte crítica da prevenção de malware. Os usuários conscientes são menos propensos a tomar ações que possam comprometer a segurança.

![Backup.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-72e9777477cfe88b7368e984f1e5902597292531%2F3-2-Backup.png?alt=media)

**Mitigação de riscos**

A mitigação de riscos se concentra em como minimizar o impacto de uma infecção por malware quando as medidas de prevenção falham. Ainda que as medidas de prevenção sejam eficazes, é importante estar preparado para o cenário em que ocorra uma infecção por malware. A mitigação de riscos visa reduzir o dano potencial causado por tais infecções:

1. **Estratégias de isolamento e contenção**: ao detectar uma infecção por malware, é essencial isolar a ameaça para evitar que ela se espalhe para outros sistemas e dados. Isso pode envolver a desconexão da máquina afetada da rede ou a restrição do acesso a recursos críticos.
2. **Recuperação e restauração**: além do isolamento, a mitigação de riscos envolve a recuperação e restauração de sistemas comprometidos. Isso pode incluir a restauração de backups ou a limpeza profunda da máquina afetada para garantir que todo o malware tenha sido removido.
3. **Investigação pós-incidente**: uma parte importante da mitigação de riscos é a investigação pós-incidente para entender como o malware entrou no sistema e identificar possíveis pontos fracos na segurança. Isso ajuda a fortalecer a proteção contra futuras ameaças.

![Recuperação e restauração.](https://197913913-files.gitbook.io/~/files/v0/b/gitbook-x-prod.appspot.com/o/spaces%2Fgy7GKgxZTtL2mg8PHYoG%2Fuploads%2Fgit-blob-dff07e0d3558b60fe9f48352b8e984f6d213d294%2F3-2-Recupera%C3%A7%C3%A3o.png?alt=media)

### **Conclusão**

À medida que encerramos a Aula 2.2, é importante destacar as principais lições aprendidas e os pontos-chave abordados durante esta sessão. Nosso foco especial foi na detecção e prevenção de malware.

Durante esta aula, exploramos os indicadores de malware, que são as pistas e evidências cruciais que permitem identificar e analisar ameaças cibernéticas. Aprofundamos nossa compreensão dos diferentes tipos de indicadores, incluindo notificações de antivírus, execução de sandbox, consumo de recursos e mudanças no sistema de arquivos. Além disso, discutimos as técnicas de análise baseada em comportamento, exploramos a análise de tráfego de rede, análise de registros e monitoramento de comportamento como ferramentas para identificar atividades suspeitas e detectar possíveis ameaças.

Conhecemos também as ferramentas populares usadas na análise de processos, como o Wireshark e a Sysinternals Suite e, por fim, examinamos as estratégias de prevenção de malware, destacando a importância de medidas proativas, como a atualização de software, políticas de acesso e conscientização dos usuários. Além disso, discutimos a mitigação de riscos e estratégias de isolamento e contenção em caso de infecção por malware.

Concluindo, a cibersegurança é uma disciplina dinâmica e a compreensão de indicadores de malware, técnicas de análise de processos e estratégias de prevenção auxiliam na proteção de sistemas e dados valiosos. Parabéns por ter finalizado mais esta etapa!