package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import tg2.com.local.pauloafonso.pontosturisticos.R;
import tg2.com.local.pauloafonso.pontosturisticos.adapter.TabAdapter;
import tg2.com.local.pauloafonso.pontosturisticos.config.ConfiguracaoFirebase;
import tg2.com.local.pauloafonso.pontosturisticos.helper.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle nToggle;
    private FirebaseAuth autenticacao;
    private NavigationView navView;
    private Toolbar toolbar;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autenticacao = ConfiguracaoFirebase.getAutenticacao();

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("Pontos Turísticos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slt_tabs);
        viewPager = (ViewPager) findViewById(R.id.vp_main_pagina);

        //Configurando Adapter
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);
        slidingTabLayout.setViewPager(viewPager);
        slidingTabLayout.setDistributeEvenly(true);

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
                    case R.id.nav_account:
                        return true;
                    case R.id.nav_settings:
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

