package com.washington.ecomerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document
@Data @NoArgsConstructor
public class Produto {

  @Id
  private String codigo;

  private String nome;

  private Double preco;
  
}
