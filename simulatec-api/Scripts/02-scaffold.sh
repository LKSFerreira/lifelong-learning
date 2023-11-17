#!/bin/bash

# Scrip para gerar as Models e o DbContext a partir do banco de dados

dotnet ef dbcontext scaffold Name=DefaultConnection MySql.EntityFrameworkCore -o Models -c SimulatecDbContext --context-dir Data --force --no-onconfiguring

# Adiciona o using para o DbContext no Program.cs
# Configura a conexão com o banco de dados da context no Program.cs
# Utiliza as variáveis de ambiente para configurar a conexão com o banco de dados em produção
if ! grep -q 'var connectionString = builder.Configuration.GetConnectionString("DefaultConnection")' Program.cs; then
    sed -i '1iusing simulatec_api_app.Data;' Program.cs
    sed -i '/var builder = WebApplication.CreateBuilder(args);/a \
\
DotNetEnv.Env.Load(); \
\
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection") ?? null;\
\
connectionString ??= new string($"server={Environment.GetEnvironmentVariable("DB_HOST")};port={Environment.GetEnvironmentVariable("DB_PORT")};database={Environment.GetEnvironmentVariable("DB_DATABASE")};user={Environment.GetEnvironmentVariable("DB_USERNAME")};password={Environment.GetEnvironmentVariable("DB_PASSWORD")}"); \
\
builder.Services.AddDbContext<SimulatecDbContext>(options => \
    options.UseMySQL(connectionString));' Program.cs
fi

dotnet clean
dotnet build