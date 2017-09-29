package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.general;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.models.Gasto;

/**
 * Created by null on 20/09/17.
 */

public class ShowGastosAdapter extends BaseAdapter {
    private List<Gasto>gastos;
    private Activity activity;



    public ShowGastosAdapter(Activity activity, List<Gasto> gastos){
        this.gastos=gastos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return gastos.size();
    }

    @Override
    public Object getItem(int i) {
        return gastos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v  = (ViewGroup) activity.getLayoutInflater().inflate(R.layout.show_gastos,viewGroup,false);
        TextView descricao = v.findViewById(R.id.labelDesc);
        TextView preco = v.findViewById(R.id.labelPreco);
        TextView data = v.findViewById(R.id.labelData);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Gasto gasto = gastos.get(i);
        descricao.setText(gasto.getDescricao());
        preco.setText(gasto.getValor()+"");
        data.setText(sdf.format(gasto.getData()));
        return v;
    }
}
