//package kz.project.shop.security;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends GenericFilter {
//
//    private final JwtService jwtService;
//    private final UserDetailsServiceImpl userDetailsService;
//
//    public JwtAuthenticationFilter(JwtService jwtService,
//                                   UserDetailsServiceImpl userDetailsService) {
//        this.jwtService = jwtService;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest http = (HttpServletRequest) request;
//        String header = http.getHeader("Authorization");
//
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.substring(7);
//
//            if (jwtService.isTokenValid(token)) {
//                String email = jwtService.extractUsername(token);
//                UserDetails userDetails =
//                        userDetailsService.loadUserByUsername(email);
//
//                UsernamePasswordAuthenticationToken auth =
//                        new UsernamePasswordAuthenticationToken(
//                                userDetails,
//                                null,
//                                userDetails.getAuthorities()
//                        );
//
//                auth.setDetails(
//                        new WebAuthenticationDetailsSource().buildDetails(http));
//
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//}


package kz.project.shop.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService,
                                   UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        // 👇 ЛОГ №1 — ДО ВСЕХ IF
        System.out.println("HEADER = " + header);

        if (header == null || !header.startsWith("Bearer ")) {
            System.out.println("NO OR BAD AUTH HEADER");
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        // 👇 ЛОГ №2 — ПРОВЕРКА ТОКЕНА
        System.out.println("TOKEN VALID = " + jwtService.isTokenValid(token));

        if (!jwtService.isTokenValid(token)) {
            System.out.println("TOKEN IS INVALID");
            filterChain.doFilter(request, response);
            return;
        }

        String email = jwtService.extractUsername(token);

        // 👇 ЛОГ №3 — EMAIL ИЗ JWT
        System.out.println("EMAIL = " + email);

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(email);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }}