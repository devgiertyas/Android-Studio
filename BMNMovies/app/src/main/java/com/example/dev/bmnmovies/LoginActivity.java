package com.example.dev.bmnmovies;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUser;
    private EditText editTextsenha;
    private Button buttonEntrar;
    private loginclass login = new loginclass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUser = (EditText)findViewById(R.id.editTextUser);
        editTextsenha = (EditText)findViewById(R.id.editTextsenha);
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);

    }

            public void clickbuttonEntrar(View v){

                String usuario = (editTextUser.getText().toString());
                String senha = (editTextsenha.getText().toString());
                boolean valido = login.logar(usuario, senha);

                if (valido) {

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();

                }

    }

}
