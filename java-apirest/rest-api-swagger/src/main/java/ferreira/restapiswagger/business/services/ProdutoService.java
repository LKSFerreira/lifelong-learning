package ferreira.restapiswagger.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ferreira.restapiswagger.api.v1.dto.ProdutoDto;
import ferreira.restapiswagger.business.mapper.ProdutoMapper;
import ferreira.restapiswagger.infra.entities.ProdutoEntity;
import ferreira.restapiswagger.infra.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository productoRepository;

  private final ProdutoMapper produtoMapper;

  public ProdutoDto save(ProdutoEntity produtoEntity) {
    try {
      return produtoMapper.toDto(productoRepository.save(produtoEntity));
    } catch (Exception e) {
      throw new RuntimeException("Erro ao salvar produto: " + e.getMessage());
    }
  }

  public ProdutoDto saveProdutoDto(ProdutoDto produtoDto) {
    try {
      return produtoMapper.toDto(productoRepository.save(produtoMapper.toEntity(produtoDto)));
    } catch (Exception e) {
      throw new RuntimeException("Erro ao savar produto:" + e.getMessage());
    }
  }

  public List<ProdutoDto> getAll() {
    try {
      return produtoMapper.toListDto(productoRepository.findAll());
    } catch (Exception e) {
      throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
    }
  }

  public ProdutoDto getByNome(String nome) {
    try {
      return produtoMapper.toDto(productoRepository.findByNome(nome));
    } catch (Exception e) {
      throw new RuntimeException("Erro ao buscar produto: " + e.getMessage());
    }
  }

  public void deleteByNome(String nome) {
    try {
      productoRepository.deleteByNome(nome);
    } catch (Exception e) {
      throw new RuntimeException("Erro ao deletar produto: " + e.getMessage());
    }
  }

  public Boolean existsByName(String name) {
    try {
      return productoRepository.existsByNome(name);
    } catch (Exception e) {
      throw new RuntimeException("Erro ao buscar produto: " + e.getMessage());
    }
  }

  public ProdutoDto update(String id, ProdutoDto produtoDto) {
    try {
      ProdutoEntity produtoEntity = productoRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("O Id informado não existe no banco de dados"));
          
      return produtoMapper.toDto(productoRepository.save(produtoMapper.toEntityUpdate(produtoEntity, id, produtoDto)));
    } catch (Exception e) {
      throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
    }
  }

}
