package com.gabriell.jwtEstudo.service;

import com.gabriell.jwtEstudo.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;

public class JwtService {
    private static final Key SECRET_KEY =
            Keys.hmacShaKeyFor("minha-chave-secreta-minha-chave-secreta".getBytes());

    public static String gerarToken(User username) {
        return Jwts.builder()
                .setSubject(username.getUsername())
                .claim("role", username.getRole())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String extrairUsername(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean tokenValido(String token, String username) {

        String usernameToken = extrairUsername(token);

        return usernameToken.equals(username);
    }

    public static String extrairRole(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        return claims.get("role", String.class);
    }


    }
