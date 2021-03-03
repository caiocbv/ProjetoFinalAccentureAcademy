package com.projeto.accenture.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Optional;
import com.projeto.accenture.dto.LancamentoDTO;
import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.model.PlanosDeConta;
import com.projeto.accenture.repositories.IContaRepository;
import com.projeto.accenture.repositories.ILancamentoRepository;
import com.projeto.accenture.repositories.IPlanoDeContaRepository;

public class ILancamentoService {

	@Autowired
	private IContaRepository contaRepository;
	
	@Autowired
	private ILancamentoRepository lancamentoRepository;
	
	@Autowired
	private IPlanoDeContaRepository planoDeContaRepository;
	
	public ResponseEntity<List<LancamentoDTO>> findByConta(String login) {
		Optional<Conta> retornoConta = this.contaRepository.findByLogin(login);
		if(retornoConta.isPresent()) {
			List<Lancamento> list = this.lancamentoRepository.findByConta(retornoConta.get());
			List<LancamentoDTO> objtDTO = list.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(objtDTO);
		}else 		
		return null;
	}

	public ResponseEntity<LancamentoDTO> registrarLancamentoDTO(LancamentoDTO obj) {
		Optional<Conta> conta = this.contaRepository.findByLogin(obj.getLogin());
		Optional<PlanosDeConta> planoDeConta = this.planoDeContaRepository.getById(obj.getPlanoConta());
		if(conta.isPresent()) {
			Lancamento lancamento = new Lancamento(conta.get(), planoDeConta.get(),
													obj.getValor(), obj.getDescricao(),
													planoDeConta.get().getTipoMovimento().getCod(), obj.getDataLancamento());
			
		}else {
			return null;
		}
	}

}
