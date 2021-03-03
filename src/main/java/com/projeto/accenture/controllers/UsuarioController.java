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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.helpers.Helper;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.services.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	// -------- MÉTODO DE LISTAR OS Usuarios, UTILIZEI UMA CLASSE DTO PARA FILTRAS AS INFORMAÇÕES PELO JSON
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<UsuarioDTO>> findAll(){
			
			List<Usuario> list = service.findAll();
			List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}
	
	@ApiOperation(value = "BUSCAR POR LOGIN DO USUÁRIO OU POR ID")
	@RequestMapping(value="/{param}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findByLogin(@PathVariable String param){
		
		Usuario obj = null;
		obj = Helper.isNumber(param) ? service.find(Integer.parseInt(param)) : service.findLogin(param);
		UsuarioDTO objtDTO = new UsuarioDTO(obj);
		
		return ResponseEntity.ok().body(objtDTO);
	}
	
	@ApiOperation(value = "CADASTRAR USUÁRIO")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Usuario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build(obj.getId());
		
		return ResponseEntity.created(uri).build();
	}

}
