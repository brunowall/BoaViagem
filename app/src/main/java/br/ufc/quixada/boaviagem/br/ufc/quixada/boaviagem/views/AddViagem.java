package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.ufc.quixada.boaviagem.R;
import br.ufc.quixada.boaviagem.models.Tipo;
import br.ufc.quixada.boaviagem.models.Viagem;
import br.ufc.quixada.boaviagem.models.ViagemRepository;


public class AddViagem extends Activity {
    private Button dataChegada;
    private Button dataSaida;
    private Date saida;
    private Date chegada;
    private ViagemRepository viagens;
    private EditText campoDestino;
    private RadioGroup tipo;
    private EditText orcamento;
    private EditText numPessoas;
    private long viagemid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_viagem);
        dataChegada = (Button) findViewById(R.id.buttonChegada);
        dataSaida = (Button) findViewById(R.id.buttonSaida);
        campoDestino = (EditText) findViewById(R.id.campoDestino);
        this.orcamento = findViewById(R.id.orcamento);
        this.numPessoas = findViewById(R.id.npess);

        this.tipo = (RadioGroup) findViewById(R.id.tipo);
        this.tipo.check(R.id.radioLazer);
        viagens = new ViagemRepository();
        if(getIntent().getExtras() != null && getIntent().getExtras().get("viagem") != null) {
            Viagem v = (Viagem) getIntent().getExtras().get("viagem");
            buildScreenByViagem(v);
        }

    }

    public void selecionarData(View v){
        showDialog(v.getId());
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        DatePickerDialog.OnDateSetListener dataChegadalistener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                chegada = criarData(i,i1,i2);
                dataChegada.setText(i2+"/"+(i1+1)+"/"+i);
            }


        };
        DatePickerDialog.OnDateSetListener dataSaidaListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                saida = criarData(i,i1,i2);
                dataSaida.setText(i2+"/"+(i1+1)+"/"+i);
            }
        };

        switch (id) {
            case R.id.buttonChegada:

                return new DatePickerDialog(this,dataChegadalistener,ano,mes,dia);
            case R.id.buttonSaida:
                return new DatePickerDialog(this, dataSaidaListener, ano, mes, dia);
        }
        return null;
    }


    private Date criarData(int anoSelecionado, int mesSelecionado, int diaSelecionado)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoSelecionado, mesSelecionado, diaSelecionado);
        return calendar.getTime();
    }

    public void criarViagem(View view){
        try{

            Viagem viagem = new Viagem();
            viagem.setId(viagemid);
            viagem.setDestino(campoDestino.getText().toString());
            Tipo tipo = Tipo.LAZER;
            tipo.setValue(((RadioButton)findViewById(this.tipo.getCheckedRadioButtonId())).getText().toString());
            viagem.setTipoViagem(tipo);
            viagem.setDataChegada(chegada);
            viagem.setDataSaida(saida);
            viagem.setOrcamento(Double.parseDouble(this.orcamento.getText().toString()));
            viagem.setNumPessoas(Integer.parseInt(numPessoas.getText().toString()));
            viagem.setDestino(campoDestino.getText().toString());
            viagens.addViagem(viagem);
            Toast t = Toast.makeText(this,"Viagem adicionada com sucesso",Toast.LENGTH_SHORT);
            t.show();
            finish();
        }catch(Exception e){
            Toast toast = Toast.makeText(this,"Erro ao adicionar viagem por favor preencha os campos corretamente",Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    // dado uma viagem criar a tela para a definicao
    public void buildScreenByViagem(Viagem v){
        this.campoDestino.setText(v.getDestino());
        this.dataSaida.setText(new SimpleDateFormat("dd/MM/yyyy").format(v.getDataSaida()));
        this.dataChegada.setText(new SimpleDateFormat("dd/MM/yyyy").format(v.getDataChegada()));
        this.numPessoas.setText(v.getNumPessoas()+"");
        this.saida = v.getDataSaida();
        this.chegada = v.getDataSaida();
        if (v.getTipoViagem().equals(Tipo.LAZER))
        this.tipo.check(R.id.radioLazer);
        else  this.tipo.check(R.id.radio);
        this.orcamento.setText(v.getOrcamento()+"");
        this.viagemid = v.getId();
    }

}
