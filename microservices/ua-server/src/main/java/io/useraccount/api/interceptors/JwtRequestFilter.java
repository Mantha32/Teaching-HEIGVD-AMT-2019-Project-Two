package io.useraccount.api.interceptors;

import com.auth0.jwt.exceptions.JWTVerificationException;
import io.useraccount.api.util.JwtTokenUtil;
import org.apache.catalina.core.ApplicationFilterChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//For any incoming request this filter class gest executed: check a valid JWT token
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String userEmail = null;
        String jwtToken = null;
        final String BEARER = "Bearer ";
        // JWT Token is in the form "Bearer token". Remove Bearer word and get
        // only the Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith(BEARER)) {
            jwtToken = requestTokenHeader.substring(BEARER.length());
            try {
                userEmail = jwtTokenUtil.getUserEmailFromToken(requestTokenHeader);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (JWTVerificationException e) {
                System.out.println("JWT Token has expired");
            }
        }

        // Once we get the token validate it.
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        }

        chain.doFilter(request, response);
    }
}
