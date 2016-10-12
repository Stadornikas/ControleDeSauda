package br.com.fiap.controledesaude2sis;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Usuario> lista = new ArrayList<>();
    Context context = this;

    //variável para ligar com o XML
    TextView cadastrarTextView;
    Button entrarButton;
    EditText loginEditText;
    EditText senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = (EditText) findViewById(R.id.loginEditText);
        senhaEditText = (EditText) findViewById(R.id.senhaEditText);

        cadastrarTextView = (TextView) findViewById(R.id.cadastrarTextView);
        cadastrarTextView.setOnClickListener(cadastrarListener);

        entrarButton = (Button) findViewById(R.id.entrarButton);
        entrarButton.setOnClickListener(entrarListener);
    }

    View.OnClickListener cadastrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, CadastroActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener entrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String login = loginEditText.getText().toString();
            String senha = senhaEditText.getText().toString();
            Usuario usuario = pesquisarUsuario(login, senha);
            if (usuario != null){
                Bundle bundle = new Bundle();
                bundle.putString("nome", usuario.getNome());
                Intent intent = new Intent(context, ControleActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else{
                Toast.makeText(context, "Usuário não cadastrado", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private Usuario pesquisarUsuario(String login, String senha){
        Usuario usuario = null;
        for(Usuario u : lista){
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
                usuario = u;
                break;
            }
        }
        return usuario;
    }
}
