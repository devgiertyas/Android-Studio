package com.example.aluno.dialogexample;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAlertSimple;
    private Button btnQuestion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertSimple = findViewById(R.id.btnAlertSimple);
        btnAlertSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callSimpleAlert("Olá Mundo");

            }
        });


        btnQuestion = findViewById(R.id.btnQuestion);
        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callQuestionAlert("Manda um Toast?");

            }
        });

    }

    private void callQuestionAlert(String msg2) {


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_question_alert);

        TextView textview = dialog.findViewById(R.id.textView2);
        Button btnOk2 = dialog.findViewById(R.id.btnOk2);
        Button btnCancelar = dialog.findViewById(R.id.btnCancelar);

        textview.setText(msg2);
        btnCancelar.setText("Cancelar");
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });
        btnOk2.setText("Ok");
        btnOk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Pega aqui esse toast", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void callSimpleAlert(String msg) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_simple_alert);

        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        Button btnOk = dialog.findViewById(R.id.btnOk);

        txtTitle.setText(msg);
        btnOk.setText("Ok");
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });


        dialog.show();

    }
}
