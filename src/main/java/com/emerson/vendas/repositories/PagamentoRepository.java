package com.emerson.vendas.repositories;

import com.emerson.vendas.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {

}
