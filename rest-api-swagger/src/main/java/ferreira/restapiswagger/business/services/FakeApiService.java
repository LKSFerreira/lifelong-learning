package ferreira.restapiswagger.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ferreira.restapiswagger.api.v1.dto.ProdutoDto;
import ferreira.restapiswagger.business.mapper.ProdutoMapper;
import ferreira.restapiswagger.infra.client.IFakeApiClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FakeApiService {
  private final IFakeApiClient fakeApiClient;
  private final ProdutoMapper produtoMapper;
  private final ProductoService produtoService;

  public List<ProdutoDto> getAll() {
    List<ProdutoDto> produtoDto = fakeApiClient.getAll();
    produtoDto.forEach(
        produto -> produtoService.save(produtoMapper.toEntity(produto)));
    return produtoDto;
  }
}