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
import tg2.com.local.pauloafonso.pontosturisticos.fragment.CachoeiraInfoFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.CachoeiraMapaFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.CanionsInfoFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.CanionsMapaFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.UmbuzeiroInfosFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.UmbuzeiroMapaFragment;

public class CachoeiraActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cachoeira);

        //Setando toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_cahoeira);
        toolbar.setTitle("Cachoeira de Paulo Afonso");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Configurando Fragments
        tabLayout = (TabLayout) findViewById(R.id.tab_cachoeira);
        viewPager = (ViewPager) findViewById(R.id.vp_cachoeira);
        //Adicionando fragments
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.AddFragment(new CachoeiraInfoFragment(), "Informações");
        tabAdapter.AddFragment(new CachoeiraMapaFragment(), "Mapa");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão
                startActivity(new Intent(CachoeiraActivity.this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}
