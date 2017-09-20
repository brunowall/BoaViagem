package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.app.Activity;
import android.app.AlertDialog;
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

public class VerViagens extends Activity {
    private ViagemRepository vr;
    private ListView listView;
    private AlertDialog ad;
    private GastoRepository gr;
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
                final int itemclicked = i;
                final CharSequence[] items = {
                        getString(R.string.editar),
                        getString(R.string.novo_gasto),
                        getString(R.string.gastos_realizados),
                        getString(R.string.remover) };

                final AlertDialog.Builder builder = new AlertDialog.Builder(VerViagens.this);
                final AlertDialog ad;
                builder.setTitle("Opções");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(VerViagens.this,AddViagem.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent2 = new Intent(VerViagens.this,NovoGastoActivity.class);
                                startActivity(intent2);
                                break;
                            case 3:
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(VerViagens.this);
                                AlertDialog alertDialog;
                                builder1.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Viagem viage = (Viagem) adapterView.getItemAtPosition(itemclicked);
                                        vr.removeViagem(viage.getId());
                                        VerViagens.this.recreate();
                                        return;

                                    }
                                });
                                builder1.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        return;
                                    }
                                });

                                builder1.setMessage("Deseja realmente apagar essa viagem?");
                                alertDialog = builder1.create();
                                alertDialog.show();

                                break;
                        }
                    }
                });
                ad = builder.create();
                ad.show();

            }
        });
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);



    }




}
