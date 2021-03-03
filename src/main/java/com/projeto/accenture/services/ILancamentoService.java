package com.projeto.accenture.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Optional;
import com.projeto.accenture.dto.LancamentoDTO;
import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.repositories.IContaRepository;
import com.projeto.accenture.repositories.ILancamentoRepository;

public class ILancamentoService {

	@Autowired
	private IContaRepository contaRepository;
	
	@Autowired
	private ILancamentoRepository lancamentoRepository;
	
	public ResponseEntity<List<LancamentoDTO>> findByConta(String login) {
		Optional<Conta> retornoConta = this.contaRepository.findByLogin(login);
		if(retornoConta.isPresent()) {
			List<Lancamento> list = this.lancamentoRepository.findByConta(retornoConta.get());
			List<LancamentoDTO> objtDTO = list.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(objtDTO);
		}else 		
		return null;
	}

}
