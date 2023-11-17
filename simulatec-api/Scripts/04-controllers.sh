#!/bin/bash

#Script para gerar o controlador de cada model.

models=("Acesso" "Pessoa" "Simulado")

for model in "${models[@]}"; do
    controllerName="${model}Controller"
    dotnet-aspnet-codegenerator controller -name "$controllerName" -async -api -m "$model" -dc SimulatecDbContext --relativeFolderPath Controllers
done