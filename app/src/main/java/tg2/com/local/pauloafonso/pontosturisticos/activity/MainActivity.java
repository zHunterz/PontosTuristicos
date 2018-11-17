package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;

import tg2.com.local.pauloafonso.pontosturisticos.R;
import tg2.com.local.pauloafonso.pontosturisticos.config.ConfiguracaoFirebase;

public class MainActivity extends AppCompatActivity {

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle nToggle;
    private FirebaseAuth autenticacao;
    private NavigationView navView;
    private Toolbar toolbar;
    private ImageView img_lazer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autenticacao = ConfiguracaoFirebase.getAutenticacao();

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("Pontos Turísticos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);

        img_lazer = (ImageView) findViewById(R.id.img_lazer);
        img_lazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, lazerActivity.class));
            }
        });

        navView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        permissoes();
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

        //Começa aqui
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (nToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void permissoes(){

        String[] permissao = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(), COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            }else{
                ActivityCompat.requestPermissions(this, permissao, 1234);
            }
        }else{
            ActivityCompat.requestPermissions(this, permissao, 1234);
        }
    }

    private void deslogarUsuario(){
        autenticacao.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

