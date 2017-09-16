package br.ufc.quixada.boaviagem.models;

import java.util.Date;

/**
 * Created by darkbyte on 15/09/17.
 */

public class Viagem {
    private String destino;
    private Date dataSaida;
    private Date dataChegada;
    private Tipo tipoViagem;

    public String getDestino() {
        return destino;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public void setTipoViagem(Tipo tipoViagem) {
        this.tipoViagem = tipoViagem;
    }

    public Tipo getTipoViagem() {

        return tipoViagem;
    }
}