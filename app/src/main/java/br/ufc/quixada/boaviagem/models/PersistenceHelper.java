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
        String sql1 = "CREATE TABLE viagem(id INTEGER PRIMARY KEY AUTOINCREMENT, destino Text, data_saida Date, data_chegada Date, Tipo String, orcamento REAL,num_pessoas INTEGER);";
        db.execSQL(sql1);
        String sql = "CREATE TABLE Gasto (id_viagem INTEGER PRIMARY KEY AUTOINCREMENT , descricao Text, local Text, categoria Text, texto Text, valor REAL,data Date);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
