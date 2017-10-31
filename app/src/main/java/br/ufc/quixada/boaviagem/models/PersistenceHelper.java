package br.ufc.quixada.boaviagem.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by darkbyte on 28/10/17.
 */

public class PersistenceHelper extends SQLiteOpenHelper {
    public static final String NAME_DB =  "ExemploVeiculo";
    public static final int VERSION =  1;
    PersistenceHelper(Context context){
        super(context,NAME_DB,null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Gasto (id_viagem NUMERIC, descricao Text, local Text, categoria Text, texto Text, valor REAL,data Date);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
