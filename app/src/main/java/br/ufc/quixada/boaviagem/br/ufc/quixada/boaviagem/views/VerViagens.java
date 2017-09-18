package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.general.ListPersonalizedAdapter;
import br.ufc.quixada.boaviagem.models.GastoRepository;
import br.ufc.quixada.boaviagem.models.ViagemRepository;

public class VerViagens extends Activity{
    private ViagemRepository vr;
    private ListView listView;
    private GastoRepository gr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        listView = (ListView) findViewById(R.id.lista);
        gr=new GastoRepository();

        ListPersonalizedAdapter adapter = new ListPersonalizedAdapter(ViagemRepository.getViagens(),this,gr);
        listView.setAdapter(adapter);
    }
}
