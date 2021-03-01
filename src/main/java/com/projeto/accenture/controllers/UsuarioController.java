package com.projeto.accenture.controllers;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.services.IUsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@ApiOperation(value = "BUSCAR POR ID DO USUÁRIO")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findId(@PathVariable Integer id){
		
		Usuario obj = service.find(id);
		UsuarioDTO objtDTO = new UsuarioDTO(obj);
		
		return ResponseEntity.ok().body(objtDTO);
	}
	
	@ApiOperation(value = "CADASTRAR USUÁRIO")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		
		return ResponseEntity.created(uri).build();
	}

}
