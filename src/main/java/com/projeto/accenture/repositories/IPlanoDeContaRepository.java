package com.projeto.accenture.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.accenture.dto.PlanoContaDTO;
import com.projeto.accenture.model.PlanosDeConta;

@Repository
public interface IPlanoDeContaRepository extends JpaRepository<PlanosDeConta, Integer> {
	
	Optional<PlanosDeConta> findById(Integer id);
	
}
