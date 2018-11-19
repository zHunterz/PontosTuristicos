package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import tg2.com.local.pauloafonso.pontosturisticos.R;

public class gastronomiaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia);
        toolbar = (Toolbar) findViewById(R.id.toolbar_gastronomia);
        toolbar.setTitle("Pontos Turísticos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        webView = (WebView) findViewById(R.id.web_gastronomia);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + "O Turismo e a Gastronomia são inseparáveis, pois não têm como se pensar em turismo, sem prever entre outros itens, a alimentação para curta ou longa permanência, onde o viajante não pode abster-se dela, e desta fora, sempre tende a experimentar a cozinha local."
                + "</p>"
                + "<p align=\"justify\">"
                + "Em Paulo Afonso, pode-se provar o Acarajé, a Buchada, a Rabada, o Bode Assado ou guisado, a Galinha de capoeira, o Doce de umbu. O peixe frito, ou em moquecas, dentre eles a tilápia, são opção imperdível. Todos estes pratos fazem parte da nossa culinária, que tem grande variedade de alternativas para todos os gostos. Pizzarias, bares, sorveterias e lanchonetes oferecem variadas opções mais leves, como sanduíches, salgados, crepes e massas. É de dar água na boca!"
                + "</p>"
                + "</body></html>";

        webView.loadData(text,"text/html", "utf-8");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão
                startActivity(new Intent(gastronomiaActivity.this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
