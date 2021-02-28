package com.projeto.accenture.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.projeto.accenture.model.Conta;

public interface IContaRepository extends JpaRepository<Conta, Integer> {

}
