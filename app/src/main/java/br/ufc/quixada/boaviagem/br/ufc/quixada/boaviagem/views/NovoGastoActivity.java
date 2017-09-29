package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.general.SpinnerLocalAdapter;
import br.ufc.quixada.boaviagem.models.Gasto;
import br.ufc.quixada.boaviagem.models.GastoRepository;
import br.ufc.quixada.boaviagem.models.ViagemRepository;

public class NovoGastoActivity extends Activity {
    private Spinner local;
    private Spinner categoria;
    private ViagemRepository viagemRepository;
    private Date dateGasto;
    private Button botaoData;
    private EditText descricao;
    private EditText valor;
    private GastoRepository gastoRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_gasto);
        viagemRepository= new ViagemRepository();
        local = findViewById(R.id.localSpinner);
        categoria =  findViewById(R.id.categoriaSpinner);
        botaoData = findViewById(R.id.buttonData);
        descricao = findViewById(R.id.descricao);
        valor = findViewById(R.id.valor);
        gastoRepository = new GastoRepository();

        ArrayAdapter<CharSequence> adapte = ArrayAdapter.createFromResource(this,R.array.categoriasGasto,android.R.layout.simple_spinner_item);
        categoria.setAdapter(adapte);
        SpinnerLocalAdapter adapter2 = new SpinnerLocalAdapter(this,android.R.layout.simple_spinner_item,ViagemRepository.getViagens());
        this.local.setAdapter(adapter2);
    }
    public void clickData(View view){
        showDialog(R.id.buttonData);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener dataListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                botaoData.setText(i2+"/"+i1+"/"+i);
                dateGasto = criarData(i,i1,i2);
            }
        };
        if (id==R.id.buttonData){
           return new DatePickerDialog(this,dataListener,ano,mes,dia);
        }
        return null;
    }

    private Date criarData(int anoSelecionado, int mesSelecionado, int diaSelecionado)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoSelecionado, mesSelecionado, diaSelecionado);
        return calendar.getTime();
    }
    public void criarGasto(View view){
        try {
            Gasto g = new Gasto();
            g.setData(dateGasto);
            g.setCategoria(categoria.getSelectedItem().toString());
            g.setDescricao(descricao.getText().toString());
            g.setLocal(local.getSelectedItem().toString());
            g.setValor(Float.parseFloat(valor.getText().toString()));
            g.setViagem(viagemRepository.getById((long) local.getSelectedItemId()));
            gastoRepository.addGasto(g);
            Toast t = Toast.makeText(this, "Gasto criado com sucesso", Toast.LENGTH_LONG);
            t.show();
        }catch (Exception e){
            Toast t = Toast.makeText(this, "erro ao criar gasto", Toast.LENGTH_LONG);
            t.show();
        }
    }
}
