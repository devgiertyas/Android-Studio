package com.example.dev.bmnmovies;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aluno on 02/04/18.
 */

public class AdapterFilmes extends BaseAdapter {

    Context context;
    ArrayList<Filme> filmes;

    public AdapterFilmes(Context context, ArrayList<Filme> filmes){
        this.context = context;
        this.filmes = filmes;
    }

    @Override
    public int getCount() {
        return filmes.size();
    }

    @Override
    public Object getItem(int i) {
        return filmes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_filme , parent, false);
        }

        Filme item = (Filme) getItem(position);

        TextView textFilme = convertView.findViewById(R.id.textFilme);
        ImageView imageFilme = convertView.findViewById(R.id.imageFilme);

        textFilme.setText(item.titulo);
        //imageFilme.setText(item.titulo);

        // returns the view for the current row
        return convertView;


    }
}
