package com.projeto.accenture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.accenture.dto.LoginDTO;
import com.projeto.accenture.dto.SessaoDTO;
import com.projeto.accenture.services.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@ApiOperation(value = "API PARA LOGIN DO USUÁRIO")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public SessaoDTO loginUsuario(@Validated @RequestBody LoginDTO loginDto) {
		 
		return loginService.validarLogin(loginDto);
	}

}
