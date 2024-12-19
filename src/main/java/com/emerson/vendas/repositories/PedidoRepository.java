package com.emerson.vendas.repositories;

import com.emerson.vendas.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
