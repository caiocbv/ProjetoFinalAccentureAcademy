package com.projeto.accenture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.accenture.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
