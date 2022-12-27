package com.washington.ecomerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Produto {

  @Id
  private String codigo;

  private String nome;

  private Double preco;
  
}
