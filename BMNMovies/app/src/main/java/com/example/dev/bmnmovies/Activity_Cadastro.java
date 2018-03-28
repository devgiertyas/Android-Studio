package com.example.dev.bmnmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Cadastro extends AppCompatActivity {

    private EditText editTextlogin;
    private EditText editTextSenha;
    private EditText editTextConfimasenha;
    private Button btnCadastrar;
    private loginclass login = new loginclass();
    private EditText editTextemail;
    private EditText editTextnome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cadastro);

        editTextlogin= (EditText) findViewById(R.id.editTextlogin);
        editTextSenha= (EditText) findViewById(R.id.editTextSenha);
        editTextConfimasenha=(EditText) findViewById(R.id.editTextConfimasenha);
        btnCadastrar=(Button)findViewById(R.id.btnCadastrar);
        editTextemail=(EditText) findViewById(R.id.editTextemail);
        editTextnome=(EditText) findViewById(R.id.editTextnome);









        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //  String senha = (editTextSenha.getText().toString());
               ///    String confirmacaodesenha=(editTextConfimasenha.getText().toString());
                ///   String Login=(editTextlogin.getText().toString());
                 //  boolean validasenha= login.ValidarSenha(senha,confirmacaodesenha);


                String ret=login.cadastrar(Activity_Cadastro.this, editTextnome.getText().toString(),editTextlogin.getText().toString(),editTextSenha.getText().toString(),editTextConfimasenha.getText().toString());
                if(ret.equals("ok"))
                {
                    Toast.makeText(Activity_Cadastro.this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                    Activity_Cadastro.this.finish();

                }

               else

                {

                    Toast.makeText(Activity_Cadastro.this, "Erro,Erro,Erro,Erro,Erro,Erro,Erro,Erro,Erro,Erro,Erro,", Toast.LENGTH_SHORT).show();

                }



            }
        });

    }
}
