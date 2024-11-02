package com.emerson.vendas.services;

import com.emerson.vendas.domain.Categoria;
import com.emerson.vendas.repositories.CategoriaRepository;
import com.emerson.vendas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public  Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: "
                + Categoria.class.getName())
        );
    }
}
