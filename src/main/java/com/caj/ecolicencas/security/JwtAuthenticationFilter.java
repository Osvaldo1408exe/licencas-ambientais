package com.caj.ecolicencas.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwt;

    public JwtAuthenticationFilter(UserDetailsService userDetailsService, JwtUtils jwt) {
        this.userDetailsService = userDetailsService;
        this.jwt = jwt;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            var token = authorizationHeader.replace("Bearer ", "");
            var username = jwt.verify(token);

            var user = userDetailsService.loadUserByUsername(username);

            var authentication = new UsernamePasswordAuthenticationToken(user,
                null, user.getAuthorities());

            var context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);
        }

        filterChain.doFilter(request, response);
    }
}
