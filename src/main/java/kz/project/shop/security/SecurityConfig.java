//package kz.project.shop.security;
//
//import kz.project.shop.security.JwtAuthenticationFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//public class SecurityConfig {
//
//    private final JwtAuthenticationFilter jwtFilter;
//
//    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
//        this.jwtFilter = jwtFilter;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable());
//
//        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        http.exceptionHandling(eh -> eh
//                .authenticationEntryPoint((req, res, ex) -> res.sendError(401, "Unauthorized"))
//                .accessDeniedHandler((req, res, ex) -> res.sendError(403, "Forbidden"))
//        );
//
//        http.authorizeHttpRequests(auth -> auth
//                .requestMatchers("/api/auth/**").permitAll()
//                .requestMatchers(HttpMethod.GET, "/api/products/**", "/api/categories/**").permitAll()
//                .requestMatchers("/api/roles/**").hasRole("ADMIN")
//                .requestMatchers("/api/users/**").authenticated()
//                .anyRequest().authenticated()
//        );
//
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}


package kz.project.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.sessionManagement(sm ->
                sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.exceptionHandling(eh -> eh
                .authenticationEntryPoint((req, res, ex) ->
                        res.sendError(401, "Unauthorized"))
                .accessDeniedHandler((req, res, ex) ->
                        res.sendError(403, "Forbidden"))
        );

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/login", "/api/auth/register").permitAll()
                .requestMatchers("/api/auth/change-password").authenticated()
                .requestMatchers(HttpMethod.GET, "/api/products/", "/api/categories/").permitAll()
                .requestMatchers("/api/roles/").hasRole("ADMIN")
                .requestMatchers("/api/users/").authenticated()
                .anyRequest().authenticated()
        );

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}