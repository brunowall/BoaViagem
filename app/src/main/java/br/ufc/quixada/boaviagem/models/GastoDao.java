package br.ufc.quixada.boaviagem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkbyte on 28/10/17.
 */

public interface GastoDao {
    public List<Gasto> getGastoByViagem(long vID);
    public float getGastobyviagem(Viagem v);
    public void addGasto(Gasto gasto);
    public void removeGastoByViagem(Long vID);
}
