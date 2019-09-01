package com.bulut.todolist.security;

import com.bulut.todolist.model.User;
import com.bulut.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthTokenFilter extends AbstractAuthenticationProcessingFilter {

    private JwtGenerator jwtGenerator;

    @Autowired
    private UserRepository userRepository;

    public JwtAuthTokenFilter() {
        super("/api/**");
        this.jwtGenerator = new JwtGenerator();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header = httpServletRequest.getHeader("Authorisation");

        if (header == null || !header.startsWith("Token ")) {
            throw new RuntimeException("JWT Token is missing");
        }

        String authenticationToken = header.substring(6);

        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        CustomUserDetails customUserDetails = (CustomUserDetails) authResult.getPrincipal();
        User user = userRepository.findUserByEmailAndPassword(customUserDetails.getUsername(), customUserDetails.getPassword());
        response.addHeader(SecurityConstants.HEADER_STRING,
                SecurityConstants.TOKEN_PREFIX+this.jwtGenerator.generate(user));
        chain.doFilter(request, response);
    }
}