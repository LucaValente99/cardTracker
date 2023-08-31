package com.luca.cardTracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConf {
	
	/*
	 * Con questo bean faccio si che qualsiasi richiesta http preveda un'autenticazione
	 * di tipo basic con caratteristiche di default fornitegli tramite il metodo withDefualts importato 
	 * staticamente.
	 * 
	 * L'autenticazione basic prevede che il server richieda il form 
	 * per fare l'immissione dei param per autenticarsi
	 */
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests() 
		.anyRequest().authenticated() //ogni richiesta va autenticata
		.and()
		.httpBasic(withDefaults()); //autenticazione basic con configurazione conf di default
		return http.build();
	}
	
	@Bean
	UserDetailsService userDetailService() {
		UserDetails user = User.builder()
				.username("luca")
				.password(passwordEncoder()
				.encode("pass"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
