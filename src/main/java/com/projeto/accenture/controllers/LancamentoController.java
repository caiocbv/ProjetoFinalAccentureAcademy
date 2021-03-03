package com.projeto.accenture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.accenture.dto.LancamentoDTO;
import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.services.ILancamentoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1/lancamento")
public class LancamentoController {
	@Autowired
	private ILancamentoService service;
	
	@ApiOperation(value = "Listar Lancamentos do Usuário")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<LancamentoDTO>> findByUsuario(@Validated @RequestBody UsuarioDTO obj){
		ResponseEntity<List<LancamentoDTO>> retorno = this.service.findByConta(obj.getLogin());
		return retorno;
	}
	
	
}
