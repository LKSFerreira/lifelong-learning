package ferreira.crudrestapidatajpa.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok annotation gerencia os getters, setters, equals, hashcode, toString
@NoArgsConstructor // lombok annotation Obs: O hibernate precisa de um construtor vazio
@AllArgsConstructor // lombok annotation gera um construtor com todos os atributos da classe
@Entity // Jakarta Persistence para indicar uma entidade do banco de dados
@Table(name = "tb_alunos") // Jakarta Persistence para indicar o nome da tabela no banco de dados
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Jackson para ignorar propriedades do hibernate
public class AlunoModel {

  @Id // Jakarta Persistence para indicar que o atributo é uma chave primária
  @GeneratedValue(generator = "UUID") // Jakarta Persistence para indicar que o atributo é gerado automaticamente
  private UUID id;

  @Column(nullable = false, length = 100) // Características da coluna no db.
  private String nome;

  @Column(nullable = false, length = 11, unique = true) // Características da coluna no db.
  private String cpf;

  @Column(nullable = false, length = 100) // Características da coluna no db.
  private String bairro;

  @Column(nullable = false, length = 10, name = "data_nascimento") // Características da coluna no db.
  @JsonFormat(pattern = "dd-MM-yyyy") // Spring para indicar o formato da data
  private LocalDate dataNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) // Jakarta Persistence para indicar que o atributo é uma relação de um para muitos
  @JsonIgnore
  private List<AvaliacaoFisicaModel> avaliacoesFisicas = new ArrayList<>();

}
