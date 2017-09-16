package br.ufc.quixada.boaviagem.models;

/**
 * Created by darkbyte on 16/09/17.
 */

public enum Tipo{

    LAZER("Lazer"),
    NEGOCIOS("Negocios");

    private String value = null;

    Tipo(String value){
        this.value = value;
    }


    public String getValue() {
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }


};
