package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.ufc.quixada.boaviagem.R;

/**
 * Created by darkbyte on 09/09/17.
 */
    public class TelaInicial extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tela_inicial);

        }

        public void selecionarOpcao(View view){

            if(((TextView) view).getText().toString().equals("Nova viagem")){
                Intent intent =  new Intent(this,AddViagem.class);
                startActivity(intent);

            }

            if(((TextView) view).getText().toString().equals("Novo gasto")){
                Intent intent =  new Intent(this,NovoGastoActivity.class);
                startActivity(intent);
            }
            if(((TextView) view).getText().toString().equals("Minhas viagens")){
                Intent intent =  new Intent(this,VerViagens.class);
                startActivity(intent);
            }
        }

    }


