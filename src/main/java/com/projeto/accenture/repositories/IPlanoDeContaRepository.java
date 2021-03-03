package com.projeto.accenture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.PlanosDeConta;

@Repository
public interface IPlanoDeContaRepository extends JpaRepository<PlanosDeConta, Integer> {
	java.util.Optional<PlanosDeConta> findById(Integer id);
}
