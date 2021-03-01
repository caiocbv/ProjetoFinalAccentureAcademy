package com.projeto.accenture.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByLogin (String login);

	Optional<UsuarioDTO> save(UsuarioDTO obj);

}
