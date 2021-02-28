package com.projeto.accenture.model.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.projeto.accenture.model.Conta;


public interface IContaRepository extends CrudRepository<Conta, Integer> {
	public ArrayList<Conta> findByLogin(String login);
}
