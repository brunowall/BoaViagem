package br.ufc.quixada.boaviagem.models;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by darkbyte on 16/09/17.
 */
//gerencia as viagens
public class ViagemRepository {
    private static List<Viagem> viagens = new LinkedList<Viagem>();
    private static long idGenerator = 1;
    public static List<Viagem> getViagens() {
        return viagens;
    }
    public void addViagem(Viagem viagem){
        if(viagem.getId()!=0){
            removeViagem(viagem.getId());
        }
        viagens.add(viagem);
        viagem.setId(idGenerator);
        idGenerator++;
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

    public Viagem getById(Long id){
        for(Viagem vIterator:viagens){
            if(vIterator.getId()==id)
                return vIterator;
        }
        return null;
    }

    public  void removeViagem(long id){
        for(Viagem v: viagens){
            if(v.getId()==id){
                viagens.remove(v);

                return;
            }
            Log.d("Teste-remocao", "removeViagem: Teste De remocao"+id);
        }
        return;
    }


}
