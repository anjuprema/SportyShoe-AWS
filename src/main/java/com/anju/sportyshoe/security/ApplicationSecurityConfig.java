package com.anju.sportyshoe.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passworEndoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll()
		//.antMatchers("/user/**").hasRole("ADMIN")
		//.antMatchers("/product/**").hasRole("USER")
		//.antMatchers("/purchase/**").permitAll()
		.anyRequest().authenticated().and().httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {

		UserDetails adminUser = User.builder().username("admin").password(passworEndoder.encode("123456"))
				.authorities(ApplicationUserRole.ADMIN.getGrandtedAuthorities()).build();

		UserDetails loggedInUser = User.builder().username("user").password(passworEndoder.encode("654321"))
				.authorities(ApplicationUserRole.USER.getGrandtedAuthorities()).build();

		return new InMemoryUserDetailsManager(adminUser, loggedInUser);

	}

}
