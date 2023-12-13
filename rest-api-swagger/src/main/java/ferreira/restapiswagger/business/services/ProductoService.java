package ferreira.restapiswagger.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ferreira.restapiswagger.infra.entities.ProdutoEntity;
import ferreira.restapiswagger.infra.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

  private final ProdutoRepository productoRepository;

  public ProdutoEntity save(ProdutoEntity produtoEntity) {
    try {
      return productoRepository.save(produtoEntity);
    } catch (Exception e) {
      throw new RuntimeException("Erro ao salvar produto: " + e.getMessage());
    }
  }

  public List<ProdutoEntity> getAll() {

    try {
      return productoRepository.findAll();
    } catch (Exception e) {
      throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
    }
  }

}
