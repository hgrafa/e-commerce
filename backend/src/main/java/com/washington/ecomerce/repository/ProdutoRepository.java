package com.washington.ecomerce.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washington.ecomerce.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>{

  List<Produto> findByNomeContainingIgnoreCase(String text);
  
}
