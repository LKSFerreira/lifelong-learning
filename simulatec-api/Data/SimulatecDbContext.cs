using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using simulatec_api_app.Models;

namespace simulatec_api_app.Data;

public partial class SimulatecDbContext : DbContext
{
    public SimulatecDbContext(DbContextOptions<SimulatecDbContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Acesso> Acessos { get; set; }

    public virtual DbSet<Pessoa> Pessoas { get; set; }

    public virtual DbSet<Simulado> Simulados { get; set; }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Acesso>(entity =>
        {
            entity.HasKey(e => e.Usuario).HasName("PRIMARY");

            entity.ToTable("acessos");

            entity.HasIndex(e => e.Usuario, "usuario").IsUnique();

            entity.Property(e => e.Usuario)
                .HasMaxLength(15)
                .HasColumnName("usuario");
            entity.Property(e => e.Ativo).HasColumnName("ativo");
            entity.Property(e => e.Senha)
                .HasMaxLength(15)
                .HasColumnName("senha");
        });

        modelBuilder.Entity<Pessoa>(entity =>
        {
            entity.HasKey(e => e.Usuario).HasName("PRIMARY");

            entity.ToTable("pessoas");

            entity.HasIndex(e => e.Cpf, "cpf").IsUnique();

            entity.HasIndex(e => e.Email, "email").IsUnique();

            entity.HasIndex(e => e.Usuario, "usuario").IsUnique();

            entity.HasIndex(e => e.Validacao, "validacao").IsUnique();

            entity.Property(e => e.Usuario)
                .HasMaxLength(15)
                .HasColumnName("usuario");
            entity.Property(e => e.Ativo).HasColumnName("ativo");
            entity.Property(e => e.Cpf)
                .HasMaxLength(11)
                .HasColumnName("cpf");
            entity.Property(e => e.Email)
                .HasMaxLength(50)
                .HasColumnName("email");
            entity.Property(e => e.Nascimento)
                .HasColumnType("date")
                .HasColumnName("nascimento");
            entity.Property(e => e.Nome)
                .HasMaxLength(50)
                .HasColumnName("nome");
            entity.Property(e => e.Role)
                .HasMaxLength(50)
                .HasColumnName("role");
            entity.Property(e => e.Telefone)
                .HasMaxLength(11)
                .HasColumnName("telefone");
            entity.Property(e => e.Validacao).HasColumnName("validacao");
        });

        modelBuilder.Entity<Simulado>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");

            entity.ToTable("simulados");

            entity.HasIndex(e => e.Id, "id").IsUnique();

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.Ano).HasColumnName("ano");
            entity.Property(e => e.Area)
                .HasMaxLength(50)
                .HasColumnName("area");
            entity.Property(e => e.Ativo).HasColumnName("ativo");
            entity.Property(e => e.Correta)
                .HasColumnType("text")
                .HasColumnName("correta");
            entity.Property(e => e.Curso)
                .HasMaxLength(50)
                .HasColumnName("curso");
            entity.Property(e => e.Dificuldade).HasColumnName("dificuldade");
            entity.Property(e => e.Instituicao)
                .HasMaxLength(100)
                .HasColumnName("instituicao");
            entity.Property(e => e.Questao)
                .HasColumnType("text")
                .HasColumnName("questao");
            entity.Property(e => e.RespostaA)
                .HasColumnType("text")
                .HasColumnName("resposta_a");
            entity.Property(e => e.RespostaB)
                .HasColumnType("text")
                .HasColumnName("resposta_b");
            entity.Property(e => e.RespostaC)
                .HasColumnType("text")
                .HasColumnName("resposta_c");
            entity.Property(e => e.RespostaD)
                .HasColumnType("text")
                .HasColumnName("resposta_d");
            entity.Property(e => e.RespostaE)
                .HasColumnType("text")
                .HasColumnName("resposta_e");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
