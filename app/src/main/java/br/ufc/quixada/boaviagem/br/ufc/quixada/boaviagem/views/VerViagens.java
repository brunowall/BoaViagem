package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.general.ListPersonalizedAdapter;
import br.ufc.quixada.boaviagem.models.GastoRepository;
import br.ufc.quixada.boaviagem.models.Viagem;
import br.ufc.quixada.boaviagem.models.ViagemRepository;
import br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views.OptionsDialog;
public class VerViagens extends Activity implements OptionsDialog.OptionsDialogListener,RemoveConfirmDialog.RemoveConfirmListener {
    private ViagemRepository vr;
    private ListView listView;
    private AlertDialog ad;
    private GastoRepository gr;
    private AdapterView adapterView;
    private int itemclicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        listView = (ListView) findViewById(R.id.lista);
        gr=new GastoRepository();
        vr = new ViagemRepository();
        ListPersonalizedAdapter adapter = new ListPersonalizedAdapter(ViagemRepository.getViagens(),this,gr);
        listView.setAdapter(adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, final View view, int i, long l) {
                VerViagens.this.itemclicked = i;
                VerViagens.this.adapterView = adapterView;
                DialogFragment dialog =  new OptionsDialog();
                dialog.show(VerViagens.this.getFragmentManager(),"Options");
            }
        });




    }


    @Override
    public void onClickEditar() {
        Intent intent = new Intent(VerViagens.this,AddViagem.class);
        Viagem viagem=(Viagem) adapterView.getItemAtPosition(itemclicked);
        intent.putExtra("viagem",viagem);
        startActivity(intent);
        finish();

    }

    @Override
    public void onClickNovoGasto() {
        Intent intent2 = new Intent(VerViagens.this,NovoGastoActivity.class);
        startActivity(intent2);
    }

    @Override
    public void onClickGastosRealizados() {
        Intent intent3 = new Intent(VerViagens.this,ShowGastosActivity.class);
        Viagem viage = (Viagem) adapterView.getItemAtPosition(itemclicked);
        intent3.putExtra("idViagem",viage.getId());

        startActivity(intent3);
    }

    @Override
    public void onClickRemover() {
        RemoveConfirmDialog removeConfirmDialog = new RemoveConfirmDialog();
        removeConfirmDialog.show(this.getFragmentManager(),"Confirmar");
        return;
    }

    @Override
    public void onClickSim() {
        Long id = this.adapterView.getItemIdAtPosition(itemclicked);
        vr.removeViagem(id);
        finish();
        startActivity(getIntent());
        return;
    }

    @Override
    public void onClickNao() {
        finish();
        startActivity(getIntent());
        return;
    }
}
