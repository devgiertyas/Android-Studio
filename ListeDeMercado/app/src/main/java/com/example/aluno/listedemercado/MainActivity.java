package com.example.aluno.listedemercado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtItemComprar;
    ListView listaitem;
    Button add;
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lista);

    private List<String> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaitem = findViewById(R.id.listview);
        txtItemComprar = findViewById(R.id.editTextItemComprar);

        add = findViewById(R.id.btnAdd);


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                lista.add(txtItemComprar.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });


        lista = new ArrayList<String>();
        


        listaitem.setAdapter(adapter);

    }

    public void Salvar(){

        Gson gson = new Gson();
        Type typeListaDeItem = new TypeToken<List<String>>(){}.getType();

        String json = gson.toJson(lista, typeListaDeItem)
    }
}
