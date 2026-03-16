package com.gabriell.jwtEstudo.controller;

import com.gabriell.jwtEstudo.entities.User;
import com.gabriell.jwtEstudo.service.JwtService;
import io.jsonwebtoken.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class AuthController {
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User usuario) {

        if (usuario.getUsername().equals("gabriel") &&
                usuario.getPassword().equals("123")) {

            String token = JwtService.gerarToken(usuario.getUsername());

            return Map.of("token", token);
        }

        return Map.of("erro", "login invalido");
    }
}

