# Script para instalar todos os pacotes e ferramentas necessárias para o desenvolvimento do projeto.

#!/bin/bash

packages=(
    "Microsoft.AspNetCore.OpenApi"
    "Swashbuckle.AspNetCore"
    "Microsoft.EntityFrameworkCore"
    "Microsoft.EntityFrameworkCore.Design"
    "Microsoft.VisualStudio.Web.CodeGeneration.Design"
    "MySql.EntityFrameworkCore"
    "Microsoft.EntityFrameworkCore.Tools"
    "Microsoft.EntityFrameworkCore.SqlServer"
    "DotNetEnv"
    "Microsoft.AspNetCore.Authentication.JwtBearer"
)

for package in "${packages[@]}"
do
    dotnet add package "$package"
done

tools=(
    "dotnet-ef"
    "dotnet-aspnet-codegenerator"
)

for tool in "${tools[@]}"
do
    dotnet tool install --global "$tool"
done

dotnet tool update --global dotnet-ef
dotnet tool update --global dotnet-aspnet-codegenerator

dotnet clean
dotnet build
