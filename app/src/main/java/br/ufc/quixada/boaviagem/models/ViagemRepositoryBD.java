package br.ufc.quixada.boaviagem.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by darkbyte on 31/10/17.
 */

public class ViagemRepositoryBD implements ViagemDao {
    private SQLiteDatabase bd;
    private PersistenceHelper ph;
    public ViagemRepositoryBD(Context context){
        ph = new PersistenceHelper(context);
    }
    @Override
    public void addViagem(Viagem viagem) {
        this.bd = ph.getWritableDatabase();

        bd.insert("viagem",null,this.getValues(viagem));
        bd.close();
    }

    @Override
    public List<String> getLocais() {
        this.bd = ph.getReadableDatabase();
        Cursor cursor = bd.rawQuery("select * from viagem",null);
        List<String> locais = new LinkedList<String>();

        while (cursor.moveToNext()){
            locais.add(cursor.getString(cursor.getColumnIndex("destino")));
        }
        cursor.close();
        this.bd.close();
        return locais;
    }

    @Override
    public String[] arrayViagems() {
        return new String[0];
    }

    public List<Viagem> getViagens(){
        this.bd = ph.getReadableDatabase();
        Cursor cursor = bd.rawQuery("select * from viagem",null);
        List<Viagem> viagens = new LinkedList<Viagem>();
        while (cursor.moveToNext()){
            viagens.add(buildViagem(cursor));
        }
        cursor.close();
        this.bd.close();
        return viagens;
    }

    @Override
    public Viagem getById(Long id) {
        this.bd = ph.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM viagem WHERE id= ?", new String[] { String.valueOf(id)});
        Viagem viagem = new Viagem();

        if(cursor.moveToNext()) {
            viagem.setId(cursor.getLong(cursor.getColumnIndex("id")));
            Tipo tipo = Tipo.LAZER;
            tipo.setValue(cursor.getString(cursor.getColumnIndex("tipo")));
            viagem.setOrcamento(cursor.getDouble(cursor.getColumnIndex("orcamento")));
            viagem.setTipoViagem(tipo);
            viagem.setNumPessoas(cursor.getInt(cursor.getColumnIndex("num_pessoas")));
            viagem.setDestino(cursor.getString(cursor.getColumnIndex("destino")));
        }
        cursor.close();
        this.bd.close();
        return viagem;
    }

    @Override
    public void removeViagem(long id) {
        this.bd = ph.getWritableDatabase();
        this.bd.delete("viagem","id=?", new String[]{String.valueOf(id)});
        this.bd.close();
    }

    public ContentValues getValues(Viagem viagem){
        ContentValues cv = new ContentValues();
        cv.put("orcamento",viagem.getOrcamento());
        cv.put("data_saida",viagem.getDataSaida().toString());
        cv.put("data_chegada",viagem.getDataChegada().toString());
        cv.put("destino",viagem.getDestino());
        cv.put("tipo",viagem.getTipoViagem().getValue());
        cv.put("orcamento",viagem.getOrcamento());
        return cv;
    }

    public Viagem buildViagem(Cursor cursor){
        return getById(cursor.getLong(cursor.getColumnIndex("id")));
    }
}
