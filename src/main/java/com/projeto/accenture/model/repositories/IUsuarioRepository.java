package com.projeto.accenture.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.accenture.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
