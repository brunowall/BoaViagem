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

    ViagemRepositoryBD(Context context){
        PersistenceHelper ph = new PersistenceHelper(context);
        this.bd = ph.getReadableDatabase();
    }
    @Override
    public void addViagem(Viagem viagem) {
        bd.insert("viagem",null,this.getValues(viagem));
    }

    @Override
    public List<String> getLocais() {

        Cursor cursor = bd.rawQuery("select * from viagem",null);
        List<String> locais = new LinkedList<String>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            locais.add(cursor.getString(cursor.getColumnIndex("destino")));
        }
        cursor.close();
        return locais;
    }

    @Override
    public String[] arrayViagems() {
        return new String[0];
    }

    @Override
    public Viagem getById(Long id) {
        Cursor cursor = bd.rawQuery("SELECT * FROM viagem WHERE id= ?", new String[] { String.valueOf(id)});
        cursor.moveToFirst();
        Viagem viagem = new Viagem();
        viagem.setId(cursor.getLong(cursor.getColumnIndex("id")));
        Tipo tipo = null;
        tipo.setValue(cursor.getString(cursor.getColumnIndex("tipo")));
        viagem.setOrcamento(cursor.getDouble(cursor.getColumnIndex("orcamento")));
        viagem.setTipoViagem(tipo);
        viagem.setNumPessoas(cursor.getInt(cursor.getColumnIndex("num_pessoas")));
        return viagem;
    }

    @Override
    public void removeViagem(long id) {
        this.bd.delete("viagem","id=?", new String[]{String.valueOf(id)});

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
}
