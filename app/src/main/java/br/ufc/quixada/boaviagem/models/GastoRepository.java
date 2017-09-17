package br.ufc.quixada.boaviagem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkbyte on 16/09/17.
 */

public class GastoRepository {
    private List<Gasto> gastoList = new ArrayList<Gasto>();

    public List<Gasto> getGastoList() {
        return gastoList;
    }
    public void addGasto(Gasto gasto){
        gastoList.add(gasto);
    }

}
