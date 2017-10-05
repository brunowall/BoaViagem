package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by null on 02/10/17.
 */

public class DatePickerFragment extends DialogFragment {
    public interface DatePickerListener {
       public void datePickerChosed(String datpicker,int dia, int mes,int ano);
    }
    private DatePickerListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.listener = (DatePickerListener) getActivity();
        int dia  = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        final String botao = (String) this.getActivity().getIntent().getExtras().getString("botaodata");

        final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                DatePickerFragment.this.listener.datePickerChosed(botao,i2,i1,i);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener,ano,mes,dia);

        return datePickerDialog;
    }
}
