package com.carledwin.ti.cobranca.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.carledwin.ti.cobranca.model.Grupo;
import com.carledwin.ti.cobranca.model.Usuario;
import com.carledwin.ti.cobranca.model.UsuarioSistema;
import com.carledwin.ti.cobranca.repository.Grupos;
import com.carledwin.ti.cobranca.repository.Permissoes;
import com.carledwin.ti.cobranca.repository.Usuarios;

@Component
public class ComercialUserDetailsService implements UserDeatailsService{

	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Grupos grupos;
	
	@Autowired
	private Permissoes permissoes;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = usuarios.findByLogin(username);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usário não encontrado!");
		}
		
		return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));
	}

	private Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		return authorities(grupos.findByUsuariosIn(usuario));
	}
	
	private Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
