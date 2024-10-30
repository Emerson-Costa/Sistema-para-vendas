package com.emerson.vendas.repositories;

import com.emerson.vendas.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

}
