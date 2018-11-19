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
import tg2.com.local.pauloafonso.pontosturisticos.fragment.MemorialMapaFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.MemorialinfosFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.ponteInfosFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.ponteMapaFragment;

public class ponteActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponte);
        //Setando toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_ponte);
        toolbar.setTitle("Ponte Metálica Dom Pedro II");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Configurando Fragments
        tabLayout = (TabLayout) findViewById(R.id.tab_ponte);
        viewPager = (ViewPager) findViewById(R.id.vp_ponte);
        //Adicionando fragments
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.AddFragment(new ponteInfosFragment(), "Informações");
        tabAdapter.AddFragment(new ponteMapaFragment(), "Mapa");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão
                startActivity(new Intent(ponteActivity.this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
