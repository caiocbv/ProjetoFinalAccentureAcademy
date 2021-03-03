package com.projeto.accenture.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.projeto.accenture.dto.LancamentoDTO;
import com.projeto.accenture.dto.PlanoContaDTO;
import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.model.PlanosDeConta;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.repositories.IContaRepository;
import com.projeto.accenture.repositories.ILancamentoRepository;
import com.projeto.accenture.repositories.IPlanoDeContaRepository;
import com.projeto.accenture.repositories.IUsuarioRepository;
import com.projeto.accenture.services.exceptions.ObjectNotFoundException;

@Service
public class LancamentoService {

	@Autowired
	private IContaRepository repoConta;
	
	@Autowired
	private ILancamentoRepository repoLancamento;
	
	@Autowired
	private IPlanoDeContaRepository repoPlano;
	
	@Autowired
	private IUsuarioRepository repoUser;
	
	
	public List<Lancamento> findAll(String login) {
		
		if(repoUser.findByLogin(login).isPresent()) {
			
			return repoLancamento.findAll();
		}
		
		throw new ObjectNotFoundException("Usuário não encontrado!");
		
	}
	
}


