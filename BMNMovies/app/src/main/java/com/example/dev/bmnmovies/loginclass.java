package com.example.dev.bmnmovies;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dev on 2/26/18.
 */

public class loginclass {

    public boolean login(Context contexto,String login,String senha) {
        boolean valido = true;


        SharedPreferences sharedPref = contexto.getSharedPreferences("LoginActivity", Context.MODE_PRIVATE);
        String loginDB = sharedPref.getString("login", "^7j*^$89");
        String senhaDB = sharedPref.getString("senha", "^7j*^$89");

        if (!login.equals(loginDB) || !senha.equals(senhaDB)) {
            valido = false;
        }

        return valido;
    }

    public  boolean ValidarSenha(String senha, String Confirmasenha)
    {

        boolean valido = true;
        if (!senha.equals(Confirmasenha))
        {
            valido = false;
        }

        return valido;

    }


    public String cadastrar(Context contexto, String nome,String login ,String senha,String resenha)

    {
        if (nome.length() <=4)
        {
            return "Nome deve ser maior que 5 caracteres";

        }
        if (login.length() <=4)
        {
            return "Nome deve ser maior que 5 caracteres";

        }
        if (senha.length() <=4)
        {
            return "Nome deve ser maior que 5 caracteres";

        }
        if(!senha.equals(resenha)){
            return "senha incorreta";

        }

        salvarNoDB(contexto, nome, login, senha);

        return "ok";

    }


    private void salvarNoDB(Context contexto, String nome,String login,String senha) {

        SharedPreferences sharedPref = contexto.getSharedPreferences("LoginAvtivity", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nome", nome);
        editor.putString("login", login);
        editor.putString("senha", senha);
        editor.commit();
    }


}
