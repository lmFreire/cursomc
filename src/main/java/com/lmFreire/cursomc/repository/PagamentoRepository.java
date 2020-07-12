package com.lmFreire.cursomc.repository;

import com.lmFreire.cursomc.domain.Pagamento;
import com.lmFreire.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
