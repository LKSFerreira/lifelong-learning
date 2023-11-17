using System;
using Microsoft.EntityFrameworkCore.Migrations;
using MySql.EntityFrameworkCore.Metadata;

#nullable disable

namespace simulatec_api_app.Migrations
{
    /// <inheritdoc />
    public partial class InitialCreate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterDatabase()
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "acessos",
                columns: table => new
                {
                    usuario = table.Column<string>(type: "varchar(15)", maxLength: 15, nullable: false),
                    senha = table.Column<string>(type: "varchar(15)", maxLength: 15, nullable: false),
                    ativo = table.Column<bool>(type: "tinyint(1)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PRIMARY", x => x.usuario);
                })
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "pessoas",
                columns: table => new
                {
                    usuario = table.Column<string>(type: "varchar(15)", maxLength: 15, nullable: false),
                    nome = table.Column<string>(type: "varchar(50)", maxLength: 50, nullable: false),
                    cpf = table.Column<string>(type: "varchar(11)", maxLength: 11, nullable: false),
                    email = table.Column<string>(type: "varchar(50)", maxLength: 50, nullable: false),
                    telefone = table.Column<string>(type: "varchar(11)", maxLength: 11, nullable: false),
                    nascimento = table.Column<DateTime>(type: "date", nullable: false),
                    role = table.Column<string>(type: "varchar(50)", maxLength: 50, nullable: false),
                    validacao = table.Column<string>(type: "varchar(255)", nullable: false),
                    ativo = table.Column<bool>(type: "tinyint(1)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PRIMARY", x => x.usuario);
                })
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "simulados",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    questao = table.Column<string>(type: "text", nullable: false),
                    resposta_a = table.Column<string>(type: "text", nullable: true),
                    resposta_b = table.Column<string>(type: "text", nullable: true),
                    resposta_c = table.Column<string>(type: "text", nullable: true),
                    resposta_d = table.Column<string>(type: "text", nullable: true),
                    resposta_e = table.Column<string>(type: "text", nullable: true),
                    correta = table.Column<string>(type: "text", nullable: true),
                    dificuldade = table.Column<int>(type: "int", nullable: false),
                    instituicao = table.Column<string>(type: "varchar(100)", maxLength: 100, nullable: false),
                    ano = table.Column<int>(type: "int", nullable: false),
                    area = table.Column<string>(type: "varchar(50)", maxLength: 50, nullable: false),
                    curso = table.Column<string>(type: "varchar(50)", maxLength: 50, nullable: false),
                    ativo = table.Column<bool>(type: "tinyint(1)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PRIMARY", x => x.id);
                })
                .Annotation("MySQL:Charset", "utf8mb4");

            migrationBuilder.CreateIndex(
                name: "usuario",
                table: "acessos",
                column: "usuario",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "cpf",
                table: "pessoas",
                column: "cpf",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "email",
                table: "pessoas",
                column: "email",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "usuario1",
                table: "pessoas",
                column: "usuario",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "validacao",
                table: "pessoas",
                column: "validacao",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "id",
                table: "simulados",
                column: "id",
                unique: true);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "acessos");

            migrationBuilder.DropTable(
                name: "pessoas");

            migrationBuilder.DropTable(
                name: "simulados");
        }
    }
}
