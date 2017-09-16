package br.ufc.quixada.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        }

    }


