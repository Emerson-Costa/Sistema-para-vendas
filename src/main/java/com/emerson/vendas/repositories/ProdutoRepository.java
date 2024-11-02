package com.emerson.vendas.repositories;

import com.emerson.vendas.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

}
