package com.carledwin.ti.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carledwin.ti.cobranca.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

	Usuario findByLogin(String username);

}
