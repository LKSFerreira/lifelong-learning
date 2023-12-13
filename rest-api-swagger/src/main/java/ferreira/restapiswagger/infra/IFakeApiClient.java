package ferreira.restapiswagger.infra;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ferreira.restapiswagger.api.v1.dto.ProdutoDto;

@FeignClient(name = "fakeApi", url = "${fakeApi.url:#{null}}") // Obtem a url do arquivo application-local.ymal se for diferente de nulo
public interface IFakeApiClient {

  @GetMapping("/products")
  List<ProdutoDto> getAll();
}
