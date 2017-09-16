package br.ufc.quixada.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    public EditText usuario;
    public EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.usuario = (EditText) findViewById(R.id.usuario);
        this.senha = (EditText) findViewById(R.id.senha);
    }

    public void entrarClicked(View view){
        String mensagemErro = "Usuario e/ou senha invalidos";
        String usuarioDigitado = usuario.getText().toString();
        String senhaDigitado = senha.getText().toString();

        if(!usuarioDigitado.equals("leitor") || !senhaDigitado.equals("123")){
            Toast toast = Toast.makeText(this,mensagemErro,Toast.LENGTH_LONG);
            toast.show();
        }else{
            Intent i = new Intent(this,TelaInicial.class);


            startActivity(i);
        }

    }
}
