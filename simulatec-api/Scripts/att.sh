#!/bin/bash

# Executa todos os scripts necessários para gerar o projeto

# Instala os pacotes e ferramentas necessárias para o desenvolvimento do projeto
./Scripts/01-kit-dev.sh

# Faz um sleep de 5 segundos para dar tempo de instalar os pacotes e ferramentas
sleep 3

# Gera as Models e o DbContext a partir do banco de dados
./Scripts/02-scaffold.sh

# Gera a primeira migration
./Scripts/03-migrations.sh

# Gera o controlador de cada model usando o comando `dotnet-aspnet-codegenerator`
./Scripts/04-controllers.sh

# Executa o projeto
dotnet run