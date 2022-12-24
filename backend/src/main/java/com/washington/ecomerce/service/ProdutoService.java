package com.washington.ecomerce.service;

import org.springframework.stereotype.Service;

import com.washington.ecomerce.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {
  
  private ProdutoRepository produtoRepository;

}
