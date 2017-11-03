package br.ufc.quixada.boaviagem.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by darkbyte on 28/10/17.
 */

public class GastoRepositoryBD implements GastoDao{
    private SQLiteDatabase database;
    private ViagemDao viagemDao;
    private PersistenceHelper ph;
    public GastoRepositoryBD(Context context){
        ph = new PersistenceHelper(context);
        viagemDao  = new ViagemRepositoryBD(context);
    }
    @Override
    public List<Gasto> getGastoByViagem(long vID) {
        this.database = ph.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM gasto WHERE id_viagem  = ?", new String[] { String.valueOf(vID)});
        cursor.moveToFirst();
        List<Gasto>gastos = new ArrayList<Gasto>();
        while (cursor.moveToNext()){
            Gasto gasto = new Gasto();
            gasto.setValor(cursor.getFloat(cursor.getColumnIndex("valor")));
            gasto.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            gasto.setTexto(cursor.getString(cursor.getColumnIndex("texto")));
            gasto.setLocal(cursor.getString(cursor.getColumnIndex("local")));
            gasto.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            gasto.setViagem(viagemDao.getById(cursor.getLong(cursor.getColumnIndex("id_viagem"))));
            Long time = cursor.getLong(cursor.getColumnIndex("data"));
            Date data = new Date(time);
            gasto.setData(data);
            gastos.add(gasto);
        }
        this.database.close();
        cursor.close();
        return gastos;
    }

    public void removeGastoByViagem(Long vID){
        database = ph.getWritableDatabase();
        database.rawQuery("delete FROM gasto WHERE id_viagem  = ?", new String[] { String.valueOf(vID)});
        database.close();
    }
    @Override
    public float getGastobyviagem(Viagem v) {
        this.database = ph.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM gasto WHERE id_viagem = ?", new String[] { String.valueOf(v.getId())});
        float total = 0;
        List<Gasto>gastos = new ArrayList<Gasto>();
        while (cursor.moveToNext()){
           total += cursor.getFloat(cursor.getColumnIndex("valor"));
        }
        this.database.close();
        cursor.close();
        return total;
    }
    @Override
    public void addGasto(Gasto gasto) {
        this.database = ph.getWritableDatabase();
        this.database.insert("gasto",null,this.getValues(gasto));
        this.database.close();
    }
    public ContentValues getValues(Gasto gasto){
        ContentValues contentValues =  new ContentValues();
        contentValues.put("descricao",gasto.getDescricao());
        contentValues.put("texto",gasto.getTexto());
        contentValues.put("data",gasto.getData().getTime());
        contentValues.put("valor",gasto.getValor());
        contentValues.put("id_viagem",gasto.getViagem().getId());
        return contentValues;
    }
}
