package com.gabriell.jwtEstudo.service;

import com.gabriell.jwtEstudo.entities.User;

import java.util.ArrayList;
import java.util.List;

public class simulador {
    public static ArrayList<User> banco = new ArrayList(List.of(
            new User("Gabriel", "123", "ROLE_USER"),
            new User("admin", "admin", "ROLE_ADMIN")
    )
    );

    public static ArrayList<User> getBanco() {
        return banco;
    }

    public void setBanco(ArrayList<User> banco) {
        simulador.banco = banco;
    }

    public static boolean Existe(User usuario){
        for(User u : banco){
            if(usuario.getUsername().equals(u.getUsername()) && usuario.getPassword().equals(u.getPassword())){
                return true;
            }
        }
        return false;
    }

}
