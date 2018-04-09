package com.example.dev.bmnmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFilmes;
    private RecyclerView listview;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerFilmes);
        // Create an ArrayAdapter using the string array and a default spinner layout
        listview = (RecyclerView) findViewById(R.id.listview);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Filmes_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                listview.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

                AdapterFilmes adapterFilmes = new AdapterFilmes(MainActivity.this,filmesTeste(spinner.getSelectedItem().toString()));
               // listview.setAdapter(AdapterFilmes);


                listview.setAdapter(adapterFilmes);
               // mRecyclerCardAdapter.notifyDataSetChanged()

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


    public ArrayList<Filme> filmesTeste(String genero){
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        Filme f;
        implementation 'com.squareup.picasso:picasso:2.71828'
        if (genero.equals("Ação")) {

            f = new Filme();
            f.titulo = "Mumia";
            f.genero = "Ação";
            f.poster = "http://i.imgur.com/DvpvklR.png";
            filmes.add(f);

            f = new Filme();
            f.titulo = "Batman";
            f.genero = "Ação";
            f.poster = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg";
            filmes.add(f);

            f = new Filme();
            f.titulo = "Spiderman";
            f.genero = "Ação";
            f.poster = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg";
            filmes.add(f);
        }else{
            f = new Filme();
            f.titulo = "Mulan";
            f.genero = "Alimação";
            f.poster = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg";
            filmes.add(f);

        }

        return filmes;
    }
}

