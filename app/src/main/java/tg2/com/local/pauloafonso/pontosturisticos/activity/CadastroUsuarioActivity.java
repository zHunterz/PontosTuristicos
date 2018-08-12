package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import tg2.com.local.pauloafonso.pontosturisticos.R;
import tg2.com.local.pauloafonso.pontosturisticos.config.ConfiguracaoFirebase;
import tg2.com.local.pauloafonso.pontosturisticos.helper.Base64Custom;
import tg2.com.local.pauloafonso.pontosturisticos.helper.Preferencias;
import tg2.com.local.pauloafonso.pontosturisticos.model.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText txt_cadastro_nome;
    private EditText txt_cadastro_email;
    private EditText txt_cadastro_senha;
    private Button btnCadastrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        getSupportActionBar().hide();

        txt_cadastro_nome = (EditText) findViewById(R.id.txt_cadastro_nome);
        txt_cadastro_email = (EditText) findViewById(R.id.txt_cadastro_email);
        txt_cadastro_senha = (EditText) findViewById(R.id.txt_cadastro_senha);
        btnCadastrar = (Button) findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();

                usuario.setNome(txt_cadastro_nome.getText().toString());
                usuario.setEmail(txt_cadastro_email.getText().toString());
                usuario.setSenha(txt_cadastro_senha.getText().toString());
                cadastrarUsuario();
            }
        });

    }

    private void cadastrarUsuario(){
        autenticacao = ConfiguracaoFirebase.getAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(CadastroUsuarioActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastroUsuarioActivity.this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();

                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    String identificadorUsuario = Base64Custom.codificar64(usuario.getEmail());
                    usuario.setId(identificadorUsuario);
                    usuario.salvarUsuario();

                    Preferencias preferencias = new Preferencias(CadastroUsuarioActivity.this);
                    preferencias.salvarDados(identificadorUsuario);
                    abrirLoginUsuario();
                }else{

                    String erro = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erro = "Digite uma senha mais forte, contendo letras e números";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "Email inválido, digite um email válido";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "Email já cadastrado";
                    } catch (Exception e) {
                        erro = "Erro ao cadastrar";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroUsuarioActivity.this, erro, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void abrirLoginUsuario(){
        Intent intent = new Intent(CadastroUsuarioActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
