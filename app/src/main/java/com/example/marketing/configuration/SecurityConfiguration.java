package com.example.marketing.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration
{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.authorizeHttpRequests(requests -> requests
						.anyRequest().authenticated())
				.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.logout(LogoutConfigurer::permitAll)
				.csrf(CsrfConfigurer::disable)
				.build();
	}

	@Bean
	public UserDetailsService userDetailsService()
	{
		var user = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
