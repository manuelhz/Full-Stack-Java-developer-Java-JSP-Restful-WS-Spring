package org.studypro.SpringRestDemo.security;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
            User.withUsername("manu")
            .password("123")
            .authorities("read")
            .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(requests -> requests
				.requestMatchers(antMatcher("/token"),
					antMatcher("/"),
					antMatcher("/swagger-ui/**"),
					antMatcher("/v3/api-docs/**")).permitAll()
                .requestMatchers(antMatcher("/test")).authenticated()
                
        );

                
			
        
   

        return http.build();

    }
    
}
