package com.example.dev.bmnmovies;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    TextView txttitulo, txtano, txttempoduracao, txtatores, txtPergunta;
    ImageView imageView;
    Button btVerfilme, btnCancelar, btnOk;

    private String imdbID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        txttitulo = findViewById(R.id.txtTitulo);
        txtano = findViewById(R.id.txtAno);
        txttempoduracao = findViewById(R.id.txtTempoDeDuracao);
        txtatores = findViewById(R.id.txtAtores);
        txtPergunta = findViewById(R.id.txtPergunta);
        imageView = findViewById(R.id.imageViewTeste);
        btVerfilme = findViewById(R.id.btVerfilme);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnOk = findViewById(R.id.btnOk);

        imdbID = getIntent().getExtras().getString("imdbID");

        DadosId(imdbID);

        btVerfilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                callQuestion("Você aceita ser direcionado ao site do filme?");

            }
        });
    }

    private void callQuestion(String msg2) {


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_question);

        TextView txtPergunta = dialog.findViewById(R.id.txtPergunta);
        Button btnOk = dialog.findViewById(R.id.btnOk);
        Button btnCancelar = dialog.findViewById(R.id.btnCancelar);

        txtPergunta.setText(msg2);
        btnCancelar.setText("Não");
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });
        btnOk.setText("Sim");
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://xmovies8.nu/movies/search?s=" + txttitulo.getText());
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);

                dialog.dismiss();
            }
        });

        dialog.show();

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
                        filme.Year  = item.getString("Year");
                        filme.imdbID = item.getString("imdbID");
                        filme.tempoduracao = item.getString("Runtime");
                        filme.Poster = item.getString("Poster");
                        filme.Atores = item.getString("Actors");


                        txttitulo.setText(filme.Title);
                        txtano.setText(filme.Year);
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
