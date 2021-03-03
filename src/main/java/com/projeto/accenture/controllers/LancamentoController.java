package com.projeto.accenture.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.accenture.dto.LancamentoDTO;
import com.projeto.accenture.dto.PlanoContaDTO;
import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.model.PlanosDeConta;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.services.LancamentoService;
import com.projeto.accenture.services.PlanoContaService;
import com.projeto.accenture.services.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1/lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoService serviceLancamento;
	
	@Autowired
	private UsuarioService serviceUser;
	
	@Autowired
	private PlanoContaService serivcePlano;

// -------------------- MÉTODOS PLANOS DE CONTA ---------------------------------	
	@ApiOperation(value = "CADASTRAR PLANO DE CONTA")
	@RequestMapping(value="/planodeconta",method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody PlanosDeConta obj , @RequestParam String login){
		
		serivcePlano.insert(obj, login);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		
		return ResponseEntity.created(uri).build();	
		
	}
	
	@ApiOperation(value = "LISTA DE TODOS OS PLANOS DE CONTA")
	@RequestMapping(value="/planodeconta",method = RequestMethod.GET)
	public ResponseEntity<List<PlanosDeConta>> findAll(){
		
		List<PlanosDeConta> list = serivcePlano.findAllPlano();
		return ResponseEntity.ok().body(list);
	}
	
	
// -------------------- MÉTODOS LANCAMENTOS---------------------------------	
	@ApiOperation(value = "LISTA DE TODOS OS LANCAMENTOS")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LancamentoDTO>> findAllLancamento(@Validated @RequestParam String login){
		
		List<Lancamento> list = serviceLancamento.findAll(login);
		List<LancamentoDTO> listDTO = list.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
}
