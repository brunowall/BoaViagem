package br.ufc.quixada.boaviagem.models;

import java.util.List;

/**
 * Created by darkbyte on 28/10/17.
 */

public interface ViagemDao {
    public void addViagem(Viagem viagem);
    public List<String> getLocais();
    public String [] arrayViagems();
    public Viagem getById(Long id);
    public  void removeViagem(long id);
    public List<Viagem> getViagens();
}
