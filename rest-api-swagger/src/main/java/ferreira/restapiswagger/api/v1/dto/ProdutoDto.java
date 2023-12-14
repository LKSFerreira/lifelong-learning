package ferreira.restapiswagger.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDto {

  @JsonProperty(value = "id")
  private String id;

  @JsonProperty(value = "nome")
  private String nome;

  @JsonProperty(value = "preco")
  private String preco;

  @JsonProperty(value = "categoria")
  private String categoria;

  @JsonProperty(value = "descricao")
  private String descricao;

  @JsonProperty(value = "iamgem")
  private String imagem;

}
