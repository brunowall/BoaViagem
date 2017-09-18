package br.ufc.quixada.boaviagem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkbyte on 16/09/17.
 */

public class GastoRepository {
    private static List<Gasto> gastoList = new ArrayList<Gasto>();

    public List<Gasto> getGastoList() {
        return gastoList;
    }
    public void addGasto(Gasto gasto){
        gastoList.add(gasto);
    }
    public float getGastobyviagem(Viagem v){
        float value = 0;

        for(Gasto g: gastoList){
            if(g.getViagem().getId()==v.getId())
                value+=g.getValor();
        }

        return value;
    }
}



