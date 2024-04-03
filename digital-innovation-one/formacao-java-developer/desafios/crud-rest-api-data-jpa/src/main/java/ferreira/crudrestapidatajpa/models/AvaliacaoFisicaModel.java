package ferreira.crudrestapidatajpa.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_avaliacoes")
public class AvaliacaoFisicaModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @ManyToOne(cascade = CascadeType.ALL) // Todas as alterações feitas em uma avaliação física serão refletidas no aluno
  @JoinColumn(name = "aluno_id", nullable = false) // Define a foreign key
  private AlunoModel aluno;

  @CreationTimestamp // Hibernate gerencia a data e hora da avaliação
  @Column(name = "data_avaliacao", nullable = false) // Características da coluna no db.
  @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") // Formato da data e hora da avaliação
  private LocalDateTime dataDaAvaliacao;

  @Column(nullable = false, precision = 2, name = "peso_atual")
  private Double peso;

  @Column(nullable = false, precision = 2, name = "altura_atual")
  private Double altura;
  
}
