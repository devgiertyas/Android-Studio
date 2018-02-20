package com.example.dev.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText val1, val2;
    TextView resultado;
    float n1 , n2, divisao, mult, menos, mais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = (EditText) findViewById(R.id.editTextval1);
        val2 = (EditText) findViewById(R.id.editTextval2);
        resultado = (TextView) findViewById(R.id.txtResultado);

    }


    public void ClickDivisao(View v ){
        n1 = Float.parseFloat(val1.getText().toString());
        n2 = Float.parseFloat(val2.getText().toString());

        divisao = n1 / n2;

        resultado.setText(divisao+"");

    }


    public void ClickVezes(View v) {
        n1 = Float.parseFloat(val1.getText().toString());
        n2 = Float.parseFloat(val2.getText().toString());

        mult = n1 * n2;

        resultado.setText(mult+"");

    }

    public  void ClickMais(View v){
        n1 = Float.parseFloat(val1.getText().toString());
        n2 = Float.parseFloat(val2.getText().toString());

        mais = n1 + n2;

        resultado.setText(mais+"");

    }

    public  void ClickMenos(View v){
        n1 = Float.parseFloat(val1.getText().toString());
        n2 = Float.parseFloat(val2.getText().toString());

        menos = n1 - n2;

        resultado.setText(menos+"");

    }


}
