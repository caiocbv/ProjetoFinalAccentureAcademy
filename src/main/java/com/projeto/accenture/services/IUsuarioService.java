package com.projeto.accenture.services;

import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.model.enums.TipoMovimento;

public interface IUsuarioService {
	public Usuario findByLogin(String Login);
	public Usuario cadastrarUsuario(UsuarioDTO udto);
	public Lancamento registrarLancamento(Lancamento lacamento, TipoMovimento tipoMovimento);
	
}
