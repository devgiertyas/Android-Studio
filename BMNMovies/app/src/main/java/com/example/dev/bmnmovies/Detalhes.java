package com.example.dev.bmnmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Detalhes extends AppCompatActivity {

    TextView txttitulo, txtano, txttempoduracao, txtatores;
    ImageView imageView;

    private String imdbID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        txttitulo = findViewById(R.id.txtTitulo);
        txtano = findViewById(R.id.txtAno);
        txttempoduracao = findViewById(R.id.txtTempoDeDuracao);
        txtatores = findViewById(R.id.txtAtores);
        imageView = findViewById(R.id.imageViewTeste);

        imdbID = getIntent().getExtras().getString("imdbID");

        DadosId(imdbID);


    }



    public void DadosId(String imdbID){


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.omdbapi.com/?i="+imdbID+"&apikey=faa8270c";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.GET
                , url
                ,null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Process the JSON
                try{


                        Filme filme = new Filme();
                        JSONObject item = response;

                        filme.Title = item.getString("Title");
                        //filme.Year  = Integer.parseInt(item.getString("Year"));
                        filme.imdbID = item.getString("imdbID");
                        filme.tempoduracao = item.getString("Runtime");
                        filme.Poster = item.getString("Poster");
                        filme.Atores = item.getString("Actors");


                        txttitulo.setText(filme.Title);
                      //  txtano.setText(filme.Year);
                        txttempoduracao.setText(filme.tempoduracao);
                        txtatores.setText(filme.Atores);
                        Picasso.get().load(filme.Poster).into(imageView);

                }catch (JSONException e){
                    e.printStackTrace();
                    Log.v("erro", "Não encontrado");
                }
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){

                        Log.v("erro", "That didn't work!");
                    }
                }
        );

        queue.add(jsonObjectRequest);
    }




}
