package com.projeto.accenture.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.projeto.accenture.model.Conta;

@Repository
public interface IContaRepository extends JpaRepository<Conta, Integer>{

	Optional<Conta> findByLogin(String login); 
}
