package com.example.dev.bmnmovies;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFilmes;
    private RecyclerView listview;
    EditText txtPesquisa;


    ArrayList<Filme> filmes;
    AdapterFilmes adapterFilmes;

    MenuItem txtLogado;

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

                if (txtPesquisa.getText().toString().length() > 2 ) {


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
                                filme.Year  = item.getString("Year");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menudo, menu);
        txtLogado = menu.findItem(R.id.txtLogado);
       ;

        txtLogado.setTitle(new AppControle().UsuarioLogadoNome(MainActivity.this));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mn_logout){

            callQuestion("Deseja realmente sair?");

        }

        return super.onOptionsItemSelected(item);
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

                new AppControle().DesLogado(MainActivity.this);
                System.exit(0);

                dialog.dismiss();
            }
        });

        dialog.show();

    }

    @Override
    public void onBackPressed() {

        callQuestion2(("Deseja realmente sair?"));


    }

    private void callQuestion2(String msg2) {


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


                System.exit(0);

                dialog.dismiss();

            }
        });

        dialog.show();

    }
}

