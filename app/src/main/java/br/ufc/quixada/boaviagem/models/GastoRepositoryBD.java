package br.ufc.quixada.boaviagem.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkbyte on 28/10/17.
 */

public class GastoRepositoryBD implements GastoDao{
    private SQLiteDatabase database;
    private ViagemDao viagemDao;
    public GastoRepositoryBD(Context context){
        PersistenceHelper ph = new PersistenceHelper(context);
        this.database = ph.getReadableDatabase();

    }
    @Override
    public List<Gasto> getGastoByViagem(long vID) {
        Cursor cursor = database.rawQuery("SELECT * FROM people WHERE id_viagem = ?", new String[] { String.valueOf(vID)});
        cursor.moveToFirst();
        List<Gasto>gastos = new ArrayList<Gasto>();
        while (!cursor.isAfterLast()){
            Gasto gasto = new Gasto();
            gasto.setValor(cursor.getFloat(cursor.getColumnIndex("valor")));
            gasto.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            gasto.setTexto(cursor.getString(cursor.getColumnIndex("texto")));
            gasto.setLocal(cursor.getString(cursor.getColumnIndex("local")));
            gasto.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            gasto.setViagem(viagemDao.getById(cursor.getLong(cursor.getColumnIndex("id_viagem"))));
            gastos.add(gasto);
        }
        return gastos;
    }

    @Override
    public float getGastobyviagem(Viagem v) {
        Cursor cursor = database.rawQuery("SELECT * FROM people WHERE id_viagem = ?", new String[] { String.valueOf(v.getId())});
        cursor.moveToFirst();
        float total = 0;
        List<Gasto>gastos = new ArrayList<Gasto>();
        while (!cursor.isAfterLast()){
           total += cursor.getFloat(cursor.getColumnIndex("valor"));
        }
        return total;
    }
    @Override
    public void addGasto(Gasto gasto) {
        this.database.insert("Gasto",null,this.getValues(gasto));
    }
    public ContentValues getValues(Gasto gasto){
        ContentValues contentValues =  new ContentValues();
        contentValues.put("descricao",gasto.getDescricao());
        contentValues.put("texto",gasto.getTexto());
        contentValues.put("data",gasto.getData().toString());
        contentValues.put("valor",gasto.getValor());
        contentValues.put("id_viagem",gasto.getViagem().getId());
        return contentValues;
    }
}
