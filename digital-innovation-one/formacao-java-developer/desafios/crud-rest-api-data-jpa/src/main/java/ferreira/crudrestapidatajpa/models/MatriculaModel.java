package ferreira.crudrestapidatajpa.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_matriculas")
public class MatriculaModel {

  @Id
  @GeneratedValue(generator = "Long")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id", nullable = false)
  private AlunoModel aluno;

  @CreationTimestamp
  @Column(name = "data_matricula", nullable = false)
  @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDateTime dataDaMatricula;

}
