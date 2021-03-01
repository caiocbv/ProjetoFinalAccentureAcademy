package com.projeto.accenture.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.PlanosDeConta;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.model.enums.TipoMovimento;
import com.projeto.accenture.repositories.IContaRepository;
import com.projeto.accenture.repositories.IPlanoDeContaRepository;
import com.projeto.accenture.repositories.IUsuarioRepository;
import com.projeto.accenture.services.exceptions.ObjectNotFoundException;

@Service
public class IUsuarioService {
	
	@Autowired
	private IUsuarioRepository repoUser;
	
	@Autowired
	private IPlanoDeContaRepository repoPlanoConta;
	
	@Autowired
	private IContaRepository repoConta;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private UserDetailsManager userDetailsManager;
	
	
	// -------- MÉTODO PARA BUSCAR TODOS OS USUÁRIOS
	public List<Usuario> findAll(){
		return repoUser.findAll();
	}
	
	//-------- MÉTODO PARA BUSCAR POR ID OS USUÁRIOS
	public Usuario find (Integer id) {
		 Optional<Usuario> obj = repoUser.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
	
	//-------- MÉTODO PARA BUSCAR POR LOGIN OS USUÁRIOS
	public Usuario findLogin (String login) {
		 Optional<Usuario> obj = repoUser.findByLogin(login);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
	
	//-------- MÉTODO PARA CADASTRAR OS USUÁRIOS / CONTA E PLANO DE CONTA
	public Usuario insert(Usuario obj) {
		try {
			obj.setId(null);
			
			String hashedPassword = passwordEncoder.encode(obj.getSenha());
			obj.setSenha(hashedPassword);
			
			repoUser.save(obj);
			Conta conta = new Conta(obj.getLogin(), 0 , "Conta Corrente");
			repoConta.save(conta);
			
			
			PlanosDeConta plano = new PlanosDeConta("SALÁRIO", obj.getLogin(), TipoMovimento.RECEITAS);
			repoPlanoConta.save(plano);
			
			return obj;
			
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Usuário não encontrado!");
		}
		
		
	}
	
}
