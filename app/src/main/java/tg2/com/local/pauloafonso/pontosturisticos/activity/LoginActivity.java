package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import tg2.com.local.pauloafonso.pontosturisticos.R;
import tg2.com.local.pauloafonso.pontosturisticos.config.ConfiguracaoFirebase;
import tg2.com.local.pauloafonso.pontosturisticos.helper.Base64Custom;
import tg2.com.local.pauloafonso.pontosturisticos.helper.Preferencias;
import tg2.com.local.pauloafonso.pontosturisticos.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private TextView txtCadastrar;
    private EditText txt_login_email;
    private EditText txt_login_senha;
    private Button btnLogar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;
    private DatabaseReference firebase;
    private String idLogado;
    private ValueEventListener valueEventListenerUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        verificaUsuarioLogado();

        txtCadastrar = (TextView) findViewById(R.id.txt_login_cadastrese);
        txt_login_email = (EditText) findViewById(R.id.txt_login_email);
        txt_login_senha = (EditText) findViewById(R.id.txt_login_senha);
        btnLogar = (Button) findViewById(R.id.btn_logar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setEmail(txt_login_email.getText().toString());
                usuario.setSenha(txt_login_senha.getText().toString());

                if (usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Digite as informações nos campos", Toast.LENGTH_SHORT).show();
                }else{
                    validarLogin();
                }
            }
        });

        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validarLogin(){
        autenticacao = ConfiguracaoFirebase.getAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    idLogado = Base64Custom.codificar64(usuario.getEmail());

                    firebase = ConfiguracaoFirebase.getFirebase();
                    valueEventListenerUsuario = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Usuario usuarioLogado = dataSnapshot.getValue(Usuario.class);
                            Preferencias preferencias = new Preferencias(LoginActivity.this);
                            preferencias.salvarDados(idLogado);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    };

                    firebase.addListenerForSingleValueEvent(valueEventListenerUsuario);
                    abrirTelaPrincipal();
                    Toast.makeText(LoginActivity.this, "Suecsso ao fazer login", Toast.LENGTH_SHORT).show();
                }else{
                    String erro = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        erro = "Email ou senha incorreto";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "Email ou senha incorreto";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this,erro, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verificaUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getAutenticacao();
        if (autenticacao.getCurrentUser() != null){
            abrirTelaPrincipal();
        }
    }

    private void abrirTelaPrincipal(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
