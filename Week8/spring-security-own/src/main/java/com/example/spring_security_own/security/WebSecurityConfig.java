package com.example.spring_security_own.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.spring_security_own.security.jwt.AuthEntryPointJwt;
import com.example.spring_security_own.security.jwt.AuthTokenFilter;
import com.example.spring_security_own.security.services.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
	private final UserDetailsServiceImpl userDetailsService;
	private final AuthEntryPointJwt unauthorizedHandler;

	public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, AuthEntryPointJwt unauthorizedHandler) {
		this.userDetailsService = userDetailsService;
		this.unauthorizedHandler = unauthorizedHandler;
	}

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

//DaoAuthenticationProvider = The engine that validates username + password using your database + bcrypt.
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());// to compare passwords using bcrypt
		return authProvider;// this authProvider will be used by authentication manager
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())// we disable csrf bc we are not using cookies for session tracking
				.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
				// exception handling for unauthorized requests
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				// make sure we use stateless session; session won't be used to store user's
				// state.
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll()
						.requestMatchers("/api/test/**").permitAll().anyRequest().authenticated());
//Use my custom authentication provider when checking username + password.
//		Because you created your own:
//
//			UserDetailsServiceImpl
//
//			PasswordEncoder (BCrypt)
//
//			UserDetailsImpl
//
//			Spring Security must know:
//
//			HOW to load the user
//
//			HOW to check the password
//
//			Your custom DaoAuthenticationProvider handles this.
//		When login happens
//
//		Use my provider to authenticate
//
//		Not Spring Security’s default one(this means we are not adding usernamepasswordauth filter manually).
		// we are just telling spring security to use our custom auth provider
		http.authenticationProvider(authenticationProvider());
		// Before Spring's default login filter runs, run my JWT filter.
//		Because:
//
//			Every request should check the Authorization: Bearer <token>
//
//			Extract token
//
//			Validate token
//
//			Load UserDetails
//
//			Set Authentication in SecurityContext
//
//			This is done in AuthTokenFilter.
//
//			Spring Security has many filters.
//			UsernamePasswordAuthenticationFilter is used for form login.
//			We want our JWT filter to run before that.
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
