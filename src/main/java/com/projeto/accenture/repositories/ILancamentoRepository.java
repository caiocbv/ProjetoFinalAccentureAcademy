package com.projeto.accenture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.Lancamento;

@Repository
public interface ILancamentoRepository extends JpaRepository<Lancamento, Integer>{

	List<Lancamento> findByConta(Conta conta);

}
