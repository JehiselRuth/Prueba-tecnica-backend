package com.pruebatec.pruebatecbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
        
    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;


@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                            .cors(withDefaults())
                            .headers(header -> header.frameOptions().sameOrigin())
                            .csrf(csrf -> csrf.disable())
                            .formLogin(form -> form.disable())
                            .logout(logout -> logout
                                            .logoutUrl("/api/logout")
                                            .deleteCookies("JSESSIONID"))
                            .authorizeHttpRequests((auth) -> auth
                                            // .antMatchers("/**").permitAll()
                                            .antMatchers("/api/register").permitAll()
                                            .antMatchers("/api/users").hasRole("ADMIN")
                                            .antMatchers("/api/users/**").hasAnyRole("ADMIN", "READ")
                                            .antMatchers("/api/login").hasAnyRole("ADMIN", "READ")
                                            .anyRequest()
                                            .authenticated())
                            .userDetailsService(service)
                            .sessionManagement(session -> session
                                            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                            .httpBasic(basic -> basic
                                            .authenticationEntryPoint(authenticationEntryPoint));

            return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
    }
}

}
