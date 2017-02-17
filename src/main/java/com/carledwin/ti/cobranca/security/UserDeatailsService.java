package com.carledwin.ti.cobranca.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDeatailsService {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
}
