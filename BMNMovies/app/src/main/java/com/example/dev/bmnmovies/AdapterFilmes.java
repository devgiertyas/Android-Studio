package com.example.dev.bmnmovies;

import android.content.Context;
//import android.support.v7.app.AlertController;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by aluno on 02/04/18.
 */

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.ViewHolder>{

    Context context;
    ArrayList<Filme> filmes;

    public AdapterFilmes(Context context, ArrayList<Filme> filmes){
        this.context = context;
        this.filmes = filmes;
    }

    @Override
    public AdapterFilmes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cell = null;
        if (parent != null) {
            this.context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            cell = inflater.inflate(R.layout.item_filme, parent, false);
        }
        return new ViewHolder(cell);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (holder != null){

            holder.textFilme.setText( filmes.get(position).Title);
            Picasso.get().load(filmes.get(position).Poster).into(holder.imageFilme);

            holder.imageFilme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Uri uri = Uri.parse("https://xmovies8.nu/movies/search?s="+filmes.get(position).Title);
                    Intent it = new Intent(Intent. ACTION_VIEW, uri);
                    context.startActivity(it);


                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView textFilme ;
       ImageView imageFilme;
       public ViewHolder(View itemView) {
           super(itemView);

           if (itemView != null){
               this.textFilme = itemView.findViewById(R.id.textFilme);
               this.imageFilme = itemView.findViewById(R.id.imageFilme);
           }

       }
   }
}
