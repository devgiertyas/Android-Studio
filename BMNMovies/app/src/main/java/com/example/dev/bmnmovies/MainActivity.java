package com.example.dev.bmnmovies;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFilmes;
    private RecyclerView listview;
    EditText txtPesquisa;

    ArrayList<Filme> filmes;
    AdapterFilmes adapterFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPesquisa = (EditText) findViewById(R.id.txtPesquisa);
        // Create an ArrayAdapter using the string array and a default spinner layout
        listview = (RecyclerView) findViewById(R.id.listview);

        filmes = new ArrayList<Filme>();

        listview.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapterFilmes = new AdapterFilmes(MainActivity.this,filmes );

        listview.setAdapter(adapterFilmes);

        txtPesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (txtPesquisa.getText().toString().length() > 3 ) {

                    DadosPesquisa(txtPesquisa.getText().toString());
                }
            }
        });

    }

    public void DadosPesquisa(String texto){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.omdbapi.com/?s="+texto+"&apikey=faa8270c";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.GET
                , url
                ,null
                , new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Process the JSON
                        try{
                            // Get the JSON array
                             JSONArray array = response.getJSONArray("Search");

                            //obj.getJSONArray""
                            // Loop through the array elements
                            filmes.clear();
                            for(int i=0;i<array.length();i++){
                                // Get current json object

                                Filme filme = new Filme();
                                JSONObject item = array.getJSONObject(i);

                                filme.Title = item.getString("Title");
                                filme.Year  = item.getInt("Year");
                                filme.imdbID = item.getString("imdbID");
                               filme.Type = item.getString("Type");
                                filme.Poster = item.getString("Poster");

                                filmes.add(filme);
                                adapterFilmes.notifyDataSetChanged();
                            }
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



/*
    RequestQueue queue = Volley.newRequestQueue(this);
    String url ="http://www.google.com";

    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    mTextView.setText("Response is: "+ response.substring(0,500));
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mTextView.setText("That didn't work!");
        }
    });

// Add the request to the RequestQueue.
queue.add(stringRequest);
*/

// Request a string response from the provided URL.
        /*StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       Log.v("ret", response);

                        Gson gson = new Gson();
                        Type typeListaDeItem = new TypeToken<List<Filme>>(){}.getType();

                        List<Filme> listaDoBanco = gson.fromJson(response, typeListaDeItem);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("erro", "That didn't work!");
            }
        });*/

// Add the request to the RequestQueue.