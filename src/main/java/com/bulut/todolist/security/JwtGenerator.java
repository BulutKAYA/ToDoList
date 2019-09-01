package com.bulut.todolist.security;

import com.bulut.todolist.model.User;
import com.bulut.todolist.service.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(User user) {

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("email", String.valueOf(user.getEmail()));
        claims.put("password", user.getPassword());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "bulutkaya")
                .compact();
    }
}