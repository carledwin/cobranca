package com.carledwin.ti.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carledwin.ti.cobranca.model.Usuario;
import com.carledwin.ti.cobranca.repository.Usuarios;

@Service
public class UsuarioService {

	@Autowired
	private Usuarios repository;

	public List<Usuario> findAll(){
		return repository.findAll();
	}
}
