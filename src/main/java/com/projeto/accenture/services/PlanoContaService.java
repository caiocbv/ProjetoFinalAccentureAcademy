package com.projeto.accenture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.accenture.dto.PlanoContaDTO;
import com.projeto.accenture.model.PlanosDeConta;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.repositories.IPlanoDeContaRepository;
import com.projeto.accenture.repositories.IUsuarioRepository;
import com.projeto.accenture.services.exceptions.ObjectNotFoundException;

@Service
public class PlanoContaService {
	
	@Autowired
	private IPlanoDeContaRepository repoPlano;
	
	@Autowired
	private IUsuarioRepository repoUser;
	
	
	public PlanosDeConta insert(PlanosDeConta obj , String login) {
		if(repoUser.findByLogin(login).isPresent()) {;
			obj.setId(null);
			obj.setLogin(login);
			return repoPlano.save(obj);
		}
		
		throw new ObjectNotFoundException("Usuário não encontrado!");
		
	}
	
	public List<PlanosDeConta> findAllPlano() {
		
		return repoPlano.findAll();
		
	}

}
