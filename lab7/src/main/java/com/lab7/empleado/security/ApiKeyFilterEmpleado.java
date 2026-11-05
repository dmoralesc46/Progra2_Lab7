package com.lab7.empleado.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class ApiKeyFilterEmpleado extends OncePerRequestFilter {
    private static final String API_KEY_HEADER = "Authorization";
    private final String apiKey;

    public ApiKeyFilterEmpleado(@Value("${app.security.api-key}") String apiKey){
        this.apiKey = apiKey;
    }

    protected void doFilterInternal(HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    )throws IOException, ServletException{
        String requestApiKey = request.getHeader(API_KEY_HEADER);
        if(apiKey.equals(requestApiKey)){
            filterChain.doFilter(request, response);
        }else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("aplication/json");
            response.getWriter().write("{\"error\":\"Unauthorized\"}");;
        }
    }
}
