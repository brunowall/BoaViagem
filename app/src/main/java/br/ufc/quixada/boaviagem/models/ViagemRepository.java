package br.ufc.quixada.boaviagem.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by darkbyte on 16/09/17.
 */
//gerencia as viagens
public class ViagemRepository {
    private static List<Viagem> viagens = new LinkedList<Viagem>();

    public static List<Viagem> getViagens() {
        return viagens;
    }
    public void addViagem(Viagem viagem){
        viagens.add(viagem);
    }

}
