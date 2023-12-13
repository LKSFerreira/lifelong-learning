package ferreira.restapiswagger.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ferreira.restapiswagger.api.v1.dto.ProdutoDto;
import ferreira.restapiswagger.services.FakeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "Produtos", description = "API de produtos")
public class FakeApiController {

  private final FakeApiService fakeApiService;

  @Operation(summary = "Obtem todos os produtos", method = "GET")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Busca Realizada com sucesso"),
      // @ApiResponse(responseCode = "400", description = "Requisição inválida"),
      // @ApiResponse(responseCode = "401", description = "Não autorizado"),
      // @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado"),
      // @ApiResponse(responseCode = "403", description = "Acesso negado"),
      // @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
  @GetMapping()
  public ResponseEntity<List<ProdutoDto>> getAll() {
    return ResponseEntity.ok().body(fakeApiService.getAll());
  }

}
