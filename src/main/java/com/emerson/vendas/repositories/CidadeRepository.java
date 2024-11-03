package com.emerson.vendas.repositories;

import com.emerson.vendas.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

}
