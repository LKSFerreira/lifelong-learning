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
  private Long id;

  @JsonProperty(value = "entity_id")
  private String entityId;

  @JsonProperty(value = "title")
  private String nome;

  @JsonProperty(value = "price")
  private String preco;

  @JsonProperty(value = "category")
  private String categoria;

  @JsonProperty(value = "description")
  private String descricao;

  @JsonProperty(value = "image")
  private String imagem;

}
