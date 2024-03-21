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

  public ProdutoEntity toEntityUpdate(ProdutoEntity produtoEntity, String id, ProdutoDto produtoDto) {
    return ProdutoEntity.builder()
        .id(id)
        .nome(produtoDto.getNome() != null ? produtoDto.getNome() : produtoEntity.getNome())
        .preco(produtoDto.getPreco() != null ? produtoDto.getPreco() : produtoEntity.getPreco())
        .categoria(produtoDto.getCategoria() != null ? produtoDto.getCategoria() : produtoEntity.getCategoria())
        .descricao(produtoDto.getDescricao() != null ? produtoDto.getDescricao() : produtoEntity.getDescricao())
        .imagem(produtoDto.getImagem() != null ? produtoDto.getImagem() : produtoEntity.getImagem())
        .dataInclusao(produtoEntity.getDataInclusao())
        .dataAlteracao(LocalDateTime.now())
        .build();
  }

  public ProdutoDto toDto(ProdutoEntity produtoEntity) {
    return ProdutoDto.builder()
        .id(produtoEntity.getId())
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
