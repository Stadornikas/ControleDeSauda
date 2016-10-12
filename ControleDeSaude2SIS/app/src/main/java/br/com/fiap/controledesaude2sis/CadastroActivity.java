package br.com.fiap.controledesaude2sis;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    Context context = this;
    EditText nomeEditText;
    EditText loginEditText;
    EditText senhaEditText;
    Button cadastrarSenhaButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        loginEditText = (EditText)findViewById(R.id.loginEditText);
        senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        cadastrarSenhaButton = (Button) findViewById(R.id.cadastrarSenhaButton);

        cadastrarSenhaButton.setOnClickListener(cadastrarListener);
    }

    View.OnClickListener cadastrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nome = nomeEditText.getText().toString();
            String login = loginEditText.getText().toString();
            String senha = senhaEditText.getText().toString();

            if(!nome.equals("") && !login.equals("") && !senha.equals("")){
                MainActivity.lista.add(new Usuario(nome, login, senha));
                Toast.makeText(context,"Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(context, "Segura essa torrada", Toast.LENGTH_SHORT).show();
        }
    };
}
