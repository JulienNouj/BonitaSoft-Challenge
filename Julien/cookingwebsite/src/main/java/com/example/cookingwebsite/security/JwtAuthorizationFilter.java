package com.example.cookingwebsite.security;

import com.example.cookingwebsite.service.CustomUserDetailsService;
import com.example.cookingwebsite.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");
        
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            
            String username = jwtTokenUtil.extractUsername(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // Verify JWT and set authentication
                if (jwtTokenUtil.isTokenValid(token, username)) {
                    WebAuthenticationDetails details = new WebAuthenticationDetails(request);
                    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>()));
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
