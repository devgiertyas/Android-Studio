package com.example.dev.bmnmovies;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dev on 2/26/18.
 */

public class loginclass {



    public boolean login(Context contexto,String usuario,String senha) {


        boolean valido = true;
        SharedPreferences sharedPref = contexto.getSharedPreferences("loginclass", Context.MODE_PRIVATE);
        String loginDB = sharedPref.getString("nome", "^7j*^$89");
        String senhaDB = sharedPref.getString("senha", "^7j*^$89");

        if (!usuario.equals(loginDB) || !senha.equals(senhaDB)) {
            valido = false;

        }


        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("logado", valido);
        editor.commit();

        return valido;
    }

    public boolean UsuarioLogado(Context contexto){

        SharedPreferences sharedPref = contexto.getSharedPreferences("loginclass", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("logado", false );

    }

    public boolean DesLogado(Context contexto){

        boolean valido = false;
        SharedPreferences sharedPref = contexto.getSharedPreferences("loginclass", Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("logado", false);
        editor.commit();
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

        if(!senha.equals(resenha)){
            return "Confirmação de senha incorreta";

        }
            //salvar no banco

        salvarNoDB(contexto,nome,login,senha);


        return "ok";

    }
    private void salvarNoDB(Context contexto, String nome,String login,String senha) {

        SharedPreferences sharedPref = contexto.getSharedPreferences("loginclass", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nome", nome);
        editor.putString("login", login);
        editor.putString("senha", senha);
        editor.commit();
    }


}
