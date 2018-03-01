package com.example.dev.bmnmovies;

import android.content.Context;
import android.content.SharedPreferences;

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
            //salvar no banco

        salvarNoBD(contexto,nome,login,senha);


        return "ok";

    }
private void salvarNoBD(Context contexto,String nome,String login,String senha){

    SharedPreferences sharedpref= contexto.getSharedPreferences("loginclass",Context.MODE_PRIVATE);


    sharedpref.getString("nome","9116789136");


    editor.("nome",nome);




}


}
