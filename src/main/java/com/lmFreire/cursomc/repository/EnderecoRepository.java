package com.lmFreire.cursomc.repository;

import com.lmFreire.cursomc.domain.Cliente;
import com.lmFreire.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
