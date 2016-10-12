package br.com.fiap.controledesaude2sis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ControleActivity extends AppCompatActivity {

    TextView nomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);

        nomeTextView = (TextView) findViewById(R.id.nomeTextView);
        Bundle bundle = getIntent().getExtras();
        nomeTextView.setText(bundle.getString("nome"));
    }
}
