package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.general;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views.VerViagens;
import br.ufc.quixada.boaviagem.models.Viagem;

/**
 * Created by darkbyte on 16/09/17.
 */

public class ListPersonalizedAdapter extends BaseAdapter {
    private List<Viagem>viagens;
    private  Activity act;

    public ListPersonalizedAdapter(List<Viagem>viagens, VerViagens activity){
        this.viagens=viagens;
        this.act=activity;
    }
    @Override
    public int getCount() {
        return viagens.size();
    }

    @Override
    public Object getItem(int i) {
        return viagens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = act.getLayoutInflater().inflate(R.layout.activity_ver_viagens, viewGroup, false);
        Viagem viagem = viagens.get(i);
        TextView destino =(TextView) view2.findViewById(R.id.destinoViagem);
        TextView data =(TextView) view2.findViewById(R.id.data);
        TextView gasto = (TextView) view2.findViewById(R.id.gasto);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        destino.setText(viagem.getDestino());
        data.setText(sdf.format(viagem.getDataChegada()) +" a "+sdf.format(viagem.getDataChegada()));
        gasto.setText("Gasto Total R$: ");
        return view2;
    }
}
