package com.example.dev.bmnmovies;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dev on 2/26/18.
 */

public class AppControle {



    public boolean login(Context contexto,String usuario,String senha) {


        boolean valido = true;
        SharedPreferences sharedPref = contexto.getSharedPreferences("AppControle", Context.MODE_PRIVATE);
        String loginDB = sharedPref.getString("login", "^7j*^$89");
        String senhaDB = sharedPref.getString("senha", "^7j*^$89");

        if (!usuario.equals(loginDB) || !senha.equals(senhaDB)) {
            valido = false;

        }


        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("logado", valido);
        editor.commit();

        return valido;
    }

    public String UsuarioLogadoNome(Context contexto){

        SharedPreferences sharedPref = contexto.getSharedPreferences("AppControle", Context.MODE_PRIVATE);
        sharedPref.getBoolean("logado",false);
        return sharedPref.getString("nome", "^7j*^$89");


    }

    public boolean UsuarioLogado(Context contexto){

        SharedPreferences sharedPref = contexto.getSharedPreferences("AppControle", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("logado", false );


    }

    public boolean DesLogado(Context contexto){

        boolean valido = false;
        SharedPreferences sharedPref = contexto.getSharedPreferences("AppControle", Context.MODE_PRIVATE);


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
        if(nome.length() > 20 || nome.length() <= 3){
            return "O nome deve conter no mínimo 6, e no máximo 20 caracteres";
        }

        if(login.length() > 20 || login.length() <= 4){
            return "O login deve conter no mínimo 5, e no máximo 20 caracteres";
        }

        if(senha.length() <= 5 || senha.length() > 15){
            return "Insira uma senha com no mínimo 6 e no máximo 15 caracteres";
        }

        if(!senha.equals(resenha)){
            return "Confirmação de senha não confere";
        }

        //salvar no banco
        salvarNoDB(contexto,nome,login,senha);

        return "ok";
    }

    private void salvarNoDB(Context contexto, String nome,String login,String senha) {

        SharedPreferences sharedPref = contexto.getSharedPreferences("AppControle", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nome", nome);
        editor.putString("login", login);
        editor.putString("senha", senha);
        editor.commit();
    }

    public void salvarEstrelas(Context contexto, String imdbID,Float valor) {

        SharedPreferences sharedPref = contexto.getSharedPreferences("AppControle", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(imdbID, valor);

        editor.commit();
    }

    public float LerEstrelas(Context contexto, String imdbID){

        SharedPreferences sharedPref = contexto.getSharedPreferences("AppControle", Context.MODE_PRIVATE);
        return sharedPref.getFloat(imdbID,7878);


    }

}
