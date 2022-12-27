package com.washington.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.washington.ecomerce.model.Produto;
import com.washington.ecomerce.repository.ProdutoRepository;
import com.washington.ecomerce.resource.dto.ProdutoDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {
  
  private ProdutoRepository produtoRepository;

  public List<Produto> getAll() {
    return produtoRepository.findAll();
  }

  public List<Produto> getByNome(String nome){
    return produtoRepository
    .findByNomeContainingIgnoreCase(nome);
  }

  public Produto save(ProdutoDto produtoForm) {
    Produto paraSalvar = toProduto(produtoForm);

    return produtoRepository.save(paraSalvar);
  }

  public boolean delete(String codigo) {
    Optional<Produto> produto = produtoRepository.findById(codigo);

    if(produto.isEmpty()) return false;

    produtoRepository.delete(produto.get());
    return true;
  }

  public Produto update(String codigo, ProdutoDto produtoForm){
    // gero o produto de origem a partir do formulário
    Produto origem = toProduto(produtoForm);

    // gerar 
    Optional<Produto> destino = produtoRepository.findById(codigo);
      
    if(destino.isEmpty()) return null;

    update(origem, destino.get());

    return produtoRepository.findById(codigo).get();
  }

  public void update(Produto origem, Produto destino) {
    destino.setNome(origem.getNome());
    destino.setPreco(origem.getPreco());
  }

  private Produto toProduto(ProdutoDto produtoForm) {
    return Produto.builder()
      .nome(produtoForm.getNome())
      .codigo(produtoForm.getCodigo())
      .preco(produtoForm.getPreco())
      .build();
  }

}
