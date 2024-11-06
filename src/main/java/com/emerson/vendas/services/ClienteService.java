package com.emerson.vendas.services;

import com.emerson.vendas.domain.Cliente;
import com.emerson.vendas.repositories.CategoriaRepository;
import com.emerson.vendas.repositories.ClienteRepository;
import com.emerson.vendas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public  Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: "
                + Cliente.class.getName())
        );
    }
}
