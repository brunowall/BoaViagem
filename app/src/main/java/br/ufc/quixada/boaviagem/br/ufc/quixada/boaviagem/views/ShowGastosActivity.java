package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.general.ShowGastosAdapter;
import br.ufc.quixada.boaviagem.models.Gasto;
import br.ufc.quixada.boaviagem.models.GastoDao;
import br.ufc.quixada.boaviagem.models.GastoRepository;

/**
 * Created by null on 20/09/17.
 */

public class ShowGastosActivity extends Activity {
    private ListView listView;
    GastoDao gastoRepository;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        gastoRepository = new GastoRepository();
        long id = (long) getIntent().getExtras().getLong("idViagem");
        ShowGastosAdapter sga = new ShowGastosAdapter(this,gastoRepository.getGastoByViagem(id));
        listView = findViewById(R.id.lista);
        listView.setAdapter(sga);
    }
}
