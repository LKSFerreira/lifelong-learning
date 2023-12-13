package ferreira.restapiswagger.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ferreira.restapiswagger.api.v1.dto.ProdutoDto;
import ferreira.restapiswagger.infra.IFakeApiClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FakeApiService {
  private final IFakeApiClient fakeApiClient;

  public List<ProdutoDto> getAll() {
    return fakeApiClient.getAll();
  }
}