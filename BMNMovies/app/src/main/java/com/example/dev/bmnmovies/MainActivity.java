package com.example.dev.bmnmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFilmes;
    private ListView listview;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerFilmes);
        // Create an ArrayAdapter using the string array and a default spinner layout
        listview = (ListView) findViewById(R.id.listview);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Filmes_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                AdapterFilmes adapterFilmes = new AdapterFilmes(MainActivity.this,filmesTeste(spinner.getSelectedItem().toString()));
                listview.setAdapter(adapterFilmes);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


    public ArrayList<Filme> filmesTeste(String genero){
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        Filme f;

        if (genero.equals("Ação")) {

            f = new Filme();
            f.titulo = "Mumia";
            f.genero = "Ação";
            filmes.add(f);

            f = new Filme();
            f.titulo = "Batman";
            f.genero = "Ação";
            filmes.add(f);

            f = new Filme();
            f.titulo = "Spiderman";
            f.genero = "Ação";
            filmes.add(f);
        }else{
            f = new Filme();
            f.titulo = "Mulan";
            f.genero = "Alimação";
            filmes.add(f);

        }

        return filmes;
    }
}

