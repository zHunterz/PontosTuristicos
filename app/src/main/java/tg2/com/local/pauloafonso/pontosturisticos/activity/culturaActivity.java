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
                + "Paulo Afonso é uma cidade cheia de atrativos naturais, porém, ao chegar na cidade, já é notório o cuidado com o qual a cidade foi crescendo. Temos belas praças, dentre elas, a Praça das Mangueiras é um ponto onde não se pode deixar de ir e tirar belíssimas fotos. Temos também a Praça da Tribuna, onde aconteciam várias manifestações culturais. O calçadão da Av. Getúlio Vargas é um belo lugar para apreciar os bares, lanchonetes e uma grande quantidade de lojas. "
                + "</p>"
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
