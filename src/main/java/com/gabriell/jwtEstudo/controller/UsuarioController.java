package com.gabriell.jwtEstudo.controller;

import com.gabriell.jwtEstudo.service.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @GetMapping("/usuarios")
    public String usuarios(@RequestHeader("Authorization") String authHeader) {

        String token = authHeader.replace("Bearer ", "");

        String username = JwtService.extrairUsername(token);

        return "Usuarios acessados por: " + username;
    }
}
