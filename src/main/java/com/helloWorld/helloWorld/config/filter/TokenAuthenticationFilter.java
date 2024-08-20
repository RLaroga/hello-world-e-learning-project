package com.helloWorld.helloWorld.config.filter;

import com.helloWorld.helloWorld.common.constant.HttpStatus;
import com.helloWorld.helloWorld.service.SessionService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private static final String[] EXCLUDED_PATHS = {"/api/auth/login", "/api/auth/register"};
    private final SessionService sessionService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        //skip filter for certain paths
        for (String excludedPath : EXCLUDED_PATHS) {
            if (path.startsWith(excludedPath)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        String token = request.getHeader("Authorization");

        if (token != null && sessionService.isTokenValid(token)) {
            // Token is valid, proceed with the request
            filterChain.doFilter(request, response);
        } else {
            // Token is invalid or missing, return an unauthorized response
            response.setStatus(HttpStatus.UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
        }
    }
}
