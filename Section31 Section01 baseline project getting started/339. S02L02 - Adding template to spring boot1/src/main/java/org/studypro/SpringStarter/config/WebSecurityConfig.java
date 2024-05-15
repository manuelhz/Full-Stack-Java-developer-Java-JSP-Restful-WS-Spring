package org.studypro.SpringStarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.Enabl
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecuriry(prePostEnabled = true, secureEnnabled = true)
public class WebSecurityConfig {
    private static final String[] WHITELIST = {
        "/",
        "/login",
        "/register",
        "db-console"
    };
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers(WHITELIST)
        .permitAll()
        .anyRequest()
        .authenticated();
        return http.build();        
    }
}