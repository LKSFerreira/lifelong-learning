package ferreira.restapiswagger.infra.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ProdutoEntity")
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoEntity {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descricao")
  private String descricao;

  @Column(name = "preco")
  private String preco;

  @Column(name = "categoria")
  private String categoria;

  @Column(name = "imagem")
  private String imagem;

  @Column(name = "data_inclusao")
  private LocalDateTime dataInclusao;

}
