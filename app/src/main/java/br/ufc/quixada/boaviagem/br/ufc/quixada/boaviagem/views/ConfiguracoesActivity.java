package br.ufc.quixada.boaviagem.br.ufc.quixada.boaviagem.views;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import br.ufc.quixada.boaviagem.R;

/**
 * Created by null on 20/09/17.
 */

public class ConfiguracoesActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
