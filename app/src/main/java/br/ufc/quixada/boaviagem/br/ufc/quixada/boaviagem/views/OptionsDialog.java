package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import br.ufc.quixada.boaviagem.R;


/**
 * Created by null on 27/09/17.
 */

public class OptionsDialog extends DialogFragment {

    private OptionsDialogListener listener;

    public interface OptionsDialogListener{
        public void onClickEditar();
        public void onClickNovoGasto();
        public void onClickGastosRealizados();
        public void onClickRemover();

    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        this.listener=(OptionsDialogListener)this.getActivity();

        final CharSequence[] items = {
                getString(R.string.editar),
                getString(R.string.novo_gasto),
                getString(R.string.gastos_realizados),
                getString(R.string.remover) };
        builder.setTitle("Opções");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                listener.onClickEditar();
                                break;
                            case 1:
                                listener.onClickNovoGasto();
                                break;
                            case 2:
                                listener.onClickGastosRealizados();
                                break;
                            case 3:
                                listener.onClickRemover();
                                break;
                        }
                    }
                });
        return builder.create();
    }
}