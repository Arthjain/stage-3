package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	/* creating two users with names 'admin' and 'user'. 
	Password for both users will be 'pwd'.*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
				.and()
				.withUser("Arth").password(passwordEncoder().encode("admin")).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	/*
	// define the rule that getting all countries can be accessed by only 'user'
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().httpBasic().and()
				.authorizeRequests().antMatchers("/countries").hasRole("USER")
				// authentication service JWT
				.antMatchers("/countries").hasRole("USER")
				// users of both roles can access /authenticate URL
				.antMatchers("/authenticate").hasAnyRole("USER","ADMIN");
	}
	
	*/
	
	// configuring security to use JWT specified filter
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().httpBasic().and()
		       .authorizeRequests()
		       .antMatchers("/authenticate").hasAnyRole("USER","ADMIN")
		       // new filter to validate JWT
		       .anyRequest().authenticated()
		       .and()
		       .addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
}
