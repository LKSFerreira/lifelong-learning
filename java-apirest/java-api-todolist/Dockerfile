# Executa o build da imagem
FROM ubuntu:latest AS build

# Executa um comando no container para atualizar o sistema
RUN apt-get update

# Executa um comando no container para instalar o java
RUN apt-get install -y openjdk-17-jdk

# Copia todos os arquivos da pasta local para o diretorio /app do container render
COPY . .

# Executa um comando no container para instalar o maven
RUN apt-get install -y maven

# Refaz o build do projeto no container
RUN mvn clean install

# Excuta o comando para rodar uma imagem do openjdk com o java 17 dentro do container
FROM openjdk:17-jdk-slim

# Abre a porta 8080 para acesso externo
EXPOSE 8080

# Copia o arquivo .jar gerado no build para a pasta /target do container e renomeia para app.jar
COPY --from=build /target/todolist-0.0.1.jar app.jar

# Executa o comando java -jar app.jar para iniciar a aplicação
# Fazendo com que o container execute a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
