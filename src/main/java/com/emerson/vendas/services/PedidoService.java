package com.emerson.vendas.services;

import com.emerson.vendas.domain.Pedido;
import com.emerson.vendas.repositories.PedidoRepository;
import com.emerson.vendas.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public  Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: "
                + Pedido.class.getName())
        );
    }
}
