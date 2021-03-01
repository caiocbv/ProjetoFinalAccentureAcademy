package com.projeto.accenture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.accenture.model.Lancamento;

@Repository
public interface ILancamentoRepository extends JpaRepository<Lancamento, Integer>{

}
