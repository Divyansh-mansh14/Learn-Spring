package com.example.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails john = User.builder()
				.username("john")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(john, mary, susan);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer ->
				configurer
						.requestMatchers("/").hasRole("EMPLOYEE")
						.requestMatchers("/leaders/**").hasRole("MANAGER")
						.requestMatchers("/systems/**").hasRole("ADMIN")
						.anyRequest().authenticated()
					)
		
					//it is used to show our custom login form
					.formLogin(form ->
							form
								//here we are passing the url of the login form.
								.loginPage("/showLoginPage")
								//Here we have to submit our form data for spring to perform authentication of userId and password
								//No controller RequestMapping is required for this. Spring will handle it Automatically
								.loginProcessingUrl("/authenticateTheUser")
								//this means that anyone can see the login form 
								.permitAll()
					)
					
					.logout(logout -> logout.permitAll()
					)
					
					
					.exceptionHandling(configurer->
							configurer.accessDeniedPage("/access-denied")
					
					);
		
		
					
		return http.build();
	}
}
