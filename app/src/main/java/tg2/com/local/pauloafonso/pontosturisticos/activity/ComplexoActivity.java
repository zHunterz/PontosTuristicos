package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import tg2.com.local.pauloafonso.pontosturisticos.R;
import tg2.com.local.pauloafonso.pontosturisticos.adapter.TabAdapter;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.ComplexoinfosFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.ComplexomapaFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.UmbuzeiroInfosFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.UmbuzeiroMapaFragment;

public class ComplexoActivity extends AppCompatActivity {

    //Testando
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complexo);

        //Setando toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_complexo);
        toolbar.setTitle("Complexo Hidreletrico");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Configurando Fragments
        tabLayout = (TabLayout) findViewById(R.id.tab_complexo);
        viewPager = (ViewPager) findViewById(R.id.vp_complexo);
        //Adicionando fragments
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.AddFragment(new ComplexoinfosFragment(), "Informações");
        tabAdapter.AddFragment(new ComplexomapaFragment(), "Mapa");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão
                startActivity(new Intent(ComplexoActivity.this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
