package com.projeto.accenture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.accenture.model.Lancamento;


public interface ILancamentoRepository extends JpaRepository<Lancamento, Integer>{

}
