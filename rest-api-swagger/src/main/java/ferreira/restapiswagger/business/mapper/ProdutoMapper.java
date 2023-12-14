package ferreira.restapiswagger.business.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import ferreira.restapiswagger.api.v1.dto.ProdutoDto;
import ferreira.restapiswagger.infra.entities.ProdutoEntity;

@Component
public class ProdutoMapper {

  public ProdutoEntity toEntity(ProdutoDto produtoDto) {
    return ProdutoEntity.builder()
        .id(String.valueOf(UUID.randomUUID()))
        .nome(produtoDto.getNome())
        .preco(produtoDto.getPreco().toString())
        .categoria(produtoDto.getCategoria())
        .descricao(produtoDto.getDescricao())
        .dataInclusao(LocalDateTime.now())
        .build();
  }

  public ProdutoDto toDto(ProdutoEntity produtoEntity) {
    return ProdutoDto.builder()
        .entityId(produtoEntity.getId())
        .nome(produtoEntity.getNome())
        .categoria(produtoEntity.getCategoria())
        .descricao(produtoEntity.getDescricao())
        .preco(produtoEntity.getPreco())
        .imagem(produtoEntity.getImagem())
        .build();
  }

  public List<ProdutoDto> toListDto(List<ProdutoEntity> produtoEntity) {
    return produtoEntity.stream().map(this::toDto).toList();
  }
}
