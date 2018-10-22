package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import tg2.com.local.pauloafonso.pontosturisticos.R;
import tg2.com.local.pauloafonso.pontosturisticos.config.ConfiguracaoFirebase;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle nToggle;
    private FirebaseAuth autenticacao;
    private NavigationView navView;
    private Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autenticacao = ConfiguracaoFirebase.getAutenticacao();

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("Pontos Turísticos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);

        navView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_logout:
                        deslogarUsuario();
                        return true;
                    case R.id.nav_belvedere:
                        startActivity(new Intent(MainActivity.this, BelvedereActivity.class));
                        return true;
                    case R.id.nav_catarina:
                        startActivity(new Intent(MainActivity.this, CatarinaActivity.class));
                        return true;
                    case R.id.nav_umbuzeiro:
                        startActivity(new Intent(MainActivity.this, UmbuzeiroActivity.class));
                        return true;
                    case R.id.nav_hidreletrico:
                        startActivity(new Intent(MainActivity.this, ComplexoActivity.class));
                        return true;
                    case R.id.nav_mangueiras:
                        startActivity(new Intent(MainActivity.this, MangueiraActivity.class));
                        return true;
                    case  R.id.nav_mariabonita:
                        startActivity(new Intent(MainActivity.this, MariaBonitaActivity.class));
                        return true;
                    case  R.id.nav_mochila:
                        startActivity(new Intent(MainActivity.this, MochilaActivity.class));
                        return true;
                    case  R.id.nav_canions:
                        startActivity(new Intent(MainActivity.this, CaniosActivity.class));
                        return true;
                    case  R.id.nav_cachoeiroa:
                        startActivity(new Intent(MainActivity.this, CachoeiraActivity.class));
                        return true;
                    default:
                        return false;
                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (nToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deslogarUsuario(){
        autenticacao.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

