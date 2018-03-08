package com.example.dev.bmnmovies;

import java.util.ArrayList;

/**
 * Created by dev on 3/8/18.
 */

public class AppFilme {

    ArrayList<filmes> retorno = new ArrayList<filmes>();

    private ArrayList<filmes> filmetable;

    public AppFilme() {
        filmetable = new ArrayList<filmes>();

    }

    public void incluir(filmes f) {
        filmetable.add(f);
    }

    public void deletear(filmes f) {

        filmetable.remove(f);
    }

    public void atualizar(int id, filmes f) {
        for (int i = 0; i <= filmetable.size(); i++) {

            if (id == filmetable.get(i).id) {

                filmetable.set(i, f);
                break;
            }
        }
    }

    public ArrayList<filmes> consultar(String nome) {


        for (int i = 0; i <= filmetable.size(); i++) {

            if (nome.contains(filmetable.get(i).nome)) {

                retorno.add(filmetable.get(i));

                break;

            }
        }
        return  retorno;
    }
}
