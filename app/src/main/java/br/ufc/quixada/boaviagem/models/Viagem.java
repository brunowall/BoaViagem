package br.ufc.quixada.boaviagem.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by darkbyte on 15/09/17.
 */

public class Viagem implements Serializable{
    private String destino;
    private Date dataSaida;
    private Date dataChegada;
    private Tipo tipoViagem;
    private int numPessoas;
    private long id;
    private double orcamento;


    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tipo getTipoViagem() {
        return tipoViagem;
    }

    @Override
    public String toString() {
        return destino+"\n"+dataSaida.toString()+" a"+" "+dataChegada;
    }
}