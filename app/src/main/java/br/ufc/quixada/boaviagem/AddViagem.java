package br.ufc.quixada.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by darkbyte on 09/09/17.
 */

public class AddViagem extends Activity {
    private Button dataChegada;
    private Button dataSaida;
    private Date saida;
    private Date chegada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_viagem);
        dataChegada = (Button) findViewById(R.id.buttonChegada);
        dataSaida = (Button) findViewById(R.id.buttonSaida);
    }

    public void selecionarData(View v){
        showDialog(v.getId());
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        int dia = 0;
        int mes = 0;
        int ano = 0;
        DatePickerDialog.OnDateSetListener dataChegadalistener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                chegada = criarData(i2,i1,i);
                dataChegada.setText(i2+"/"+i1+"/"+i);
            }


        };
        DatePickerDialog.OnDateSetListener dataSaidaListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                saida = criarData(i2,i1,i);
                dataSaida.setText(i2+"/"+i1+"/"+i);
            }
        };

        switch (id) {
            case R.id.buttonChegada:
                return new DatePickerDialog(this,dataChegadalistener,ano,mes,dia);
            case R.id.buttonSaida:
                return new DatePickerDialog(this, dataSaidaListener, ano, mes, dia);
        }
        return null;
    }

    private Date criarData(int anoSelecionado, int mesSelecionado, int diaSelecionado)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoSelecionado, mesSelecionado, diaSelecionado);
        return calendar.getTime();
    }


}
