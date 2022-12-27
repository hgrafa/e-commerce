package com.washington.ecomerce.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.washington.ecomerce.model.Produto;
import com.washington.ecomerce.resource.dto.ProdutoDto;
import com.washington.ecomerce.service.ProdutoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produtos/api")
@AllArgsConstructor
public class ProdutoController {

  private ProdutoService produtoService;

  @GetMapping
  public ResponseEntity<List<ProdutoDto>> pegarTodos() {

    // gerando uma lista de produtos dto a partir do serviço
    List<ProdutoDto> produtos = produtoService.getAll().stream()
        .map(ProdutoDto::new).toList();

    // monto uma resposta baseada na lista de produtos
    return ResponseEntity.ok(produtos);
  }

  @GetMapping("/pesquisar")
  public ResponseEntity<List<ProdutoDto>> pegarTodosPorNome(@RequestParam("nome") String nome) {

    List<ProdutoDto> produtos = produtoService.getByNome(nome).stream()
        .map(ProdutoDto::new).toList();

    // monto uma resposta baseada na lista de produtos
    return ResponseEntity.ok(produtos);
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<ProdutoDto> cadastrarNovo(@RequestBody ProdutoDto produtoDto){
    Produto produto = produtoService.save(produtoDto);

    if(produto == null) return ResponseEntity.badRequest().build();

    return ResponseEntity.ok(new ProdutoDto(produto) );
  }

  @DeleteMapping("/remover")
  public ResponseEntity<String> deletarProdutoPorCodigo(@RequestParam String codigo) {
    boolean deleted = produtoService.delete(codigo);

    if(!deleted) 
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Falhou para deletar o produto");

    return ResponseEntity.ok("Produto deletado com sucesso!");    
  }

  @PutMapping("/atualizar")
  public ResponseEntity<ProdutoDto> atualizarProduto(@RequestParam String codigo, @RequestBody ProdutoDto produtoDto) {
    Produto produtoAtualizado = produtoService.update(codigo, produtoDto);

    if(produtoAtualizado == null) return ResponseEntity.badRequest().build();

    return ResponseEntity.ok(new ProdutoDto(produtoAtualizado));
  }

}
