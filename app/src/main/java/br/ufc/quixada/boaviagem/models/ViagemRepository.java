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
    public List<String> getLocais(){
        List<String>locais = new LinkedList<String>();
        for(Viagem v:viagens){
            locais.add(v.getDestino());
        }
        return locais;
    }

    public String [] arrayViagems(){
        String [] array = new String[viagens.size()];
        for (int i = 0; i<viagens.size();i++){
            array[i]=viagens.get(i).toString();
        }
        return array;
    }

}
