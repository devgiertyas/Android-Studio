package com.example.dev.bmnmovies;

/**
 * Created by dev on 2/26/18.
 */

public class loginclass {

    public boolean logar(String usuario, String senha){

        boolean valido = true;
        if (!usuario.equals("admin") || !senha.equals("admin"))
        {
            valido = false;
        }

        return valido;

    }

}
