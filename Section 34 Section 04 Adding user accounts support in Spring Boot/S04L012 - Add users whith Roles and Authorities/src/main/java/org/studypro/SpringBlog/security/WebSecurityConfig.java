package org.studypro.SpringBlog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
    MvcRequestMatcher.Builder mvc;

	@Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(requests -> requests
				.requestMatchers(antMatcher("/css/**"),
					antMatcher("/fonts/**"),
					antMatcher("/images/**"),
					antMatcher("/js/**")).permitAll()
				.requestMatchers(mvc.pattern("/"),
					mvc.pattern("/register")).permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login?error")				
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout?success")
			)
			.httpBasic(withDefaults());
		return http.build();
	}
}

/*
 * 
 * 
 import static org.springframework.security.config.Customizer.withDefaults;
private static final String[] WHITELIST = {
		"/",
        "/login",
        "/register",
        "/db-console/**",
        "/css/**",
        "/fonts/**",
        "/images/**",
        "/js/**"
    };


// todo: remove these after upgrading the db from infile db
		http.csrf().disable();
		http.headers().frameOptions().disable();




    @Bean
	@Order(1)                                                        
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		http
			.securityMatcher(WHITELIST)                                   
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().hasRole("USER")
			)
			.httpBasic(withDefaults());
		return http.build();
	}

    @Bean                                                            
	public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().authenticated()
			)
			.formLogin(withDefaults());
		return http.build();
	}


import static org.springframework.security.config.Customizer.withDefaults;






http
			.authorizeHttpRequests(requests -> requests
				.requestMatchers(mvc.pattern("/"),
				mvc.pattern("/login"),
				mvc.pattern("/register"),
				mvc.pattern("/db-console/**"),
				mvc.pattern("/css/**"),
				mvc.pattern("/fonts/**"),
				mvc.pattern("/images/**"),
				mvc.pattern("/js/**")).permitAll()
				.anyRequest().authenticated()
			).httpBasic(withDefaults()).formLogin(withDefaults());



@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(requests -> requests
			.requestMatchers(antMatcher("/css/**"),
			antMatcher("/fonts/**"),
			antMatcher("/images/**"),
			antMatcher("/js/**"),
			antMatcher("/db-console/**")).permitAll()
			.requestMatchers(mvc.pattern("/"),
			mvc.pattern("/register")).permitAll()
			.anyRequest().authenticated()
			).httpBasic(withDefaults()).formLogin(withDefaults());

		return http.build();
	}


 * 
 */
