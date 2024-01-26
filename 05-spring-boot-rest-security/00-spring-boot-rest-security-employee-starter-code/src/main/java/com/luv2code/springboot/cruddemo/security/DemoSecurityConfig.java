package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

//	 This function is used when we use spring defined table names(that is users and authorities).
//	@Bean
//	//Add Support for JDBC ... no more hardcoded users:-)
//	public UserDetailsManager userDetailsManager(DataSource dataSource) {
//		
//		//It tells Spring Security to use JDBC Authentication with our dataSource.
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	
	// This function is used when we define custom(user-defined) table names.
	@Bean
	//Add Support for JDBC ... no more hardcoded users:-)
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//define Query to retrieve authorities/roles by Username.
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?");
		
		//define Query to retrieve a user by Username.
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?");
		
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		
		http.authorizeHttpRequests(configurer->
				configurer
						.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
						.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
						.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
						.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
						.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
				
				);
		// use HTTP basic Authentication.
		http.httpBasic(Customizer.withDefaults());
		
		//Disable Cross Site Request Forgery (CSRF)
		//in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH.
		http.csrf(csrf-> csrf.disable());
		
		return http.build();
	}
	
	/*
	 * this is used when we give hard coded (users not in db).
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails john = User.builder()
				.username("john")
				//here noop means no operation. In this the password is saved as plain text.
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
	
*/
}