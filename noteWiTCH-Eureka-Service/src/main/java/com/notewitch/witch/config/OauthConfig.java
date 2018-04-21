package com.notewitch.witch.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;


@EnableOAuth2Sso
@Configuration
public class OauthConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
		.and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/eureka/**")
			.permitAll()
			.anyRequest()
			.authenticated();
	}
	
}
