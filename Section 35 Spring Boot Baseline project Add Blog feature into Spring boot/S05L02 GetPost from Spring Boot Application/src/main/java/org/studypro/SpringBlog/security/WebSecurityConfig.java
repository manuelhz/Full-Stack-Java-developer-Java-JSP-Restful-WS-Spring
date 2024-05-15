package org.studypro.SpringBlog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.studypro.SpringBlog.util.constants.Privileges;
import org.studypro.SpringBlog.util.constants.Roles;

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
				.requestMatchers(mvc.pattern("/profile/**"))
					.authenticated()
				.requestMatchers(mvc.pattern("/admin/**"))
					.hasAnyAuthority(Privileges.ACCESS_ADMIN_PANEL.getPrivilege(), Roles.ADMIN.getRole())
				.requestMatchers(mvc.pattern("/editor/**"))
					.hasAnyAuthority(Roles.ADMIN.getRole(), Roles.EDITOR.getRole())				
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
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        		.logoutSuccessUrl("/")
			)
			.httpBasic(withDefaults());
		return http.build();
	}
}