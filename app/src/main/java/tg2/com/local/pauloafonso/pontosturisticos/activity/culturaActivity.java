package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import tg2.com.local.pauloafonso.pontosturisticos.R;

public class culturaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultura);

        toolbar = (Toolbar) findViewById(R.id.toolbar_cultura);
        toolbar.setTitle("Pontos Turísticos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        webView = (WebView) findViewById(R.id.web_cultura);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + "Paulo Afonso é o resultado de uma mistura de cultura, cores, raças, costumes. O que nos faz muito ricos nesse aspecto. Aqui temos excelentes músicos, desenhistas, contadores de causos, poetas, atores, artesãos, enfim, uma infinidade de artistas das mais diversas vertentes."
                + "</p>"
                + "<p align=\"justify\">"
                + "No que se refere ao artesanato, no Povoado Malhada Grande um núcleo de produção artesanal, cria, há anos, em seus teares manuais, rústicos, peças de crochê e tricô, tapetes de fios, que têm atraído a atenção dos amantes da arte pura e regional e já foram até exportados para a Europa e Estados Unidos."
                + "</p>"
                + "<p align=\"justify\">"
                + "Temos também uma grande influência do cangaço, afinal, foi aqui que Lampião passou boa parte de sua vida, na região conhecida como Raso da Catarina. Daqui saíram 47 cangaceiros para o seu bando. E foi do Povoado Malhada da Caiçara, no município de Paulo Afonso, que  ele \"levou\" Maria Bonita, nossa conterrânea, que ficou conhecida como “a rainha do cangaço”. Um grupo folclórico “Cangaceiros de Lampião” existe há 60 anos."
                + "</body></html>";

        webView.loadData(text,"text/html", "utf-8");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão
                startActivity(new Intent(culturaActivity.this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}
