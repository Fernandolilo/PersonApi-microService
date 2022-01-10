package com.systempro.person.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.systempro.person.security.JWTAuthenticationFilter;
import com.systempro.person.security.JWTAuthorizationFilter;
import com.systempro.person.security.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final Environment env;
	private final UserDetailsService userDetailsService;
	private final JWTUtil jwtUtil;

	@Autowired
	public SecurityConfig(Environment env, UserDetailsService userDetailsService, JWTUtil jwtUtil) {
		this.env = env;
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
	}

	private static final String[] PUBLIC_MATCHERS = { "/client/h2-console/**", "/h2-console/**" };

	private static final String[] PUBLIC_MATCHERS_GET = { "/client/client/**", "/client/departiment/**",
			"/client/function/**" };

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll()
				.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Bean
	CorsConfigurationSource configurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "DELETE", "PUT", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return (CorsConfigurationSource) source;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
