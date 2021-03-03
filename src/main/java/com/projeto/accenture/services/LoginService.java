package com.projeto.accenture.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.accenture.config.JWTConstants;
import com.projeto.accenture.dto.LoginDTO;
import com.projeto.accenture.dto.SessaoDTO;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.repositories.IUsuarioRepository;
import com.projeto.accenture.services.exceptions.ObjectNotFoundException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class ILoginService {
	
	@Autowired
	private IUsuarioRepository repoUser;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public SessaoDTO validarLogin(LoginDTO loginDto){
		
		try {
			
			Optional<Usuario> login = repoUser.findByLogin(loginDto.getLogin());
			
			if (login.isPresent()) {
				
				Usuario usuario = login.get();
				
				
				boolean validPassword = passwordEncoder.matches(loginDto.getSenha(), usuario.getSenha());
				
				if (!validPassword) {
					throw new ObjectNotFoundException("Senha incorreta: " + loginDto.getSenha());
				}
				
				long tempoToken = 1 * 60 * 60 * 1000;
				SessaoDTO sessao = new SessaoDTO();
				
				sessao.setDataInicio(new Date(System.currentTimeMillis()));
				sessao.setDataFim(new Date(System.currentTimeMillis() + tempoToken));
				sessao.setLogin(usuario.getLogin());
				sessao.setToken(JWTConstants.PREFIX + getJWTToken(sessao));
				usuario.setSenha(null);
				sessao.setUsuario(usuario);
				
				return sessao;
			}	
			
		}catch (IllegalArgumentException e) {
			
			throw new IllegalArgumentException("Usuário não encontrado");
		}
		
		throw new ObjectNotFoundException("Usuário não encontrado");
		
	}
	
		
	private String getJWTToken(SessaoDTO sessao) {
		String role = "ROLE_USER";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);

		String token = Jwts.builder().setSubject(sessao.getLogin())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(sessao.getDataInicio()).setExpiration(sessao.getDataFim())
				.signWith(SignatureAlgorithm.HS512, JWTConstants.KEY.getBytes()).compact();

		return token;
	}

}
