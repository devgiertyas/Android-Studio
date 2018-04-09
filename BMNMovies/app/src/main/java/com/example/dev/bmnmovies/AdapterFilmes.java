package com.example.dev.bmnmovies;

import android.content.Context;
//import android.support.v7.app.AlertController;
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
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (holder != null){

            holder.textFilme.setText( filmes.get(position).titulo);
            Picasso.get().load(filmes.get(position).poster).into(holder.imageFilme);
/*
            holder.imageButtonSpeech.setOnClickListener {

                var text = holder.textViewTitle.text.toString()
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null)
            }

            holder.cardContainer.setOnClickListener {
                if (side == 0){
                    holder.textViewTitle.text = data[position].word
                    holder.cardContainer.setBackgroundColor(context.resources.getColor(R.color.colorFrontSide))
                    side = 1
                }else{
                    holder.textViewTitle.text = data[position].definition
                    holder.cardContainer.setBackgroundColor(context.resources.getColor(R.color.colorBackSide))
                    side = 0
                }
            }

            holder.cardContainer.setOnLongClickListener {
                listener.onItemClick(data[position])
                true
            }*/
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
