package ferreira.restapiswagger.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ferreira.restapiswagger.api.v1.dto.ProdutoDto;
import ferreira.restapiswagger.business.services.FakeApiService;
import ferreira.restapiswagger.business.services.ProdutoService;
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
  private final ProdutoService produtoService;

  @Operation(summary = "Busca todos os produtos na API Fake Store e salva no banco de dados", method = "POST")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Busca Realizada com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro ao buscar e salvar no servidor") })
  @PostMapping("/fakestore-api")
  public ResponseEntity<List<ProdutoDto>> saveAll() {
    return ResponseEntity.ok().body(fakeApiService.getAll());
  }

  @Operation(summary = "Busca todos os produtos no banco de dados", method = "GET")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Busca Realizada com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro ao buscar do servidor") })
  @GetMapping()
  public ResponseEntity<List<ProdutoDto>> getAll() {
    return ResponseEntity.ok().body(produtoService.getAll());
  }

  @Operation(summary = "Busca um produto pelo nome", method = "GET")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Busca Realizada com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro buscar do servidor") })
  @GetMapping("/{nome}")
  public ResponseEntity<ProdutoDto> getByNome(@RequestParam String nome) {
    return ResponseEntity.ok().body(produtoService.getByNome(nome));
  }

  @Operation(summary = "Remove um produto pelo nome", method = "DELETE")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Produto removido com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro excluir do servidor") })
  @DeleteMapping("/{nome}")
  public ResponseEntity<Void> deleteByNome(@RequestParam String nome) {
    produtoService.deleteByNome(nome);
    return ResponseEntity.accepted().build();
  }

  @Operation(summary = "Atualiiza um produto pelo nome", method = "PUT")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
      @ApiResponse(responseCode = "500", description = "Erro atualizar do servidor") })
  @PutMapping("/{id}")
  public ResponseEntity<ProdutoDto> update(@PathVariable String id, @RequestBody ProdutoDto produtoDto) {
    return ResponseEntity.ok().body(produtoService.update(id, produtoDto));
  }
}
