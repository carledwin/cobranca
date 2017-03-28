package com.carledwin.ti.cobranca.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/titulos/**").authenticated()
					.antMatchers("/adminstradores/**").hasRole("ADM")
					.antMatchers("/despesas/**").hasRole("ADM")
					.antMatchers("/usuarios/**").hasRole("USER")
					.antMatchers("/css/**", "/index").permitAll()
					.antMatchers("/login").permitAll()
					.antMatchers("/h2-console").permitAll()
					.and()
				.formLogin().loginPage("/login").failureUrl("/error");
	}
	// @formatter:on

	// @formatter:off
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("user").roles("USER")
				.and()
				.withUser("adm").password("adm").roles("ADM");
	}
	
}
