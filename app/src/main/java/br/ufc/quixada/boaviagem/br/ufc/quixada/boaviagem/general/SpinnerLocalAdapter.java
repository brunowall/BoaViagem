package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.general;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.models.Viagem;
import br.ufc.quixada.boaviagem.models.ViagemRepository;

/**
 * Created by null on 17/09/17.
 */

public class SpinnerLocalAdapter extends ArrayAdapter<Viagem>
{
    private Activity activity;
    private List<Viagem> viagens;
    public SpinnerLocalAdapter(Activity act,int textViewResourceId,List<Viagem> viagens){
       super(act,textViewResourceId,viagens);
       this.activity =  act;
       this.viagens = viagens;
    }
    @Override
    public int getCount() {
        return viagens.size();
    }

    @Override
    public Viagem getItem(int i) {
        return viagens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return viagens.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView tview = new TextView(activity);
        tview.setTextColor(Color.BLACK);

        tview.setText(viagens.get(i).getDestino());

        return tview;
    }


}
