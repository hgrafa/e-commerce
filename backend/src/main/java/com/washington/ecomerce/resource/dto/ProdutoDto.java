package com.washington.ecomerce.resource.dto;

import com.washington.ecomerce.model.Produto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class ProdutoDto {
  

  @NotEmpty(message = "o nome não deve estar vazio")
  private String nome;
  
  @NotEmpty(message = "o código não deve estar vazio")
  private String codigo;
  
  @NotEmpty(message = "o preco não deve estar vazio")
  private Double preco;

  public ProdutoDto(Produto produto){
    this.nome = produto.getNome();
    this.codigo = produto.getCodigo();
    this.preco = produto.getPreco();
  }

}
