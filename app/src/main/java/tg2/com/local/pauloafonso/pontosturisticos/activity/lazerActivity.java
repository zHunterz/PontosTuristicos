package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import tg2.com.local.pauloafonso.pontosturisticos.R;


public class lazerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazer);

        toolbar = (Toolbar) findViewById(R.id.toolbar_lazer);
        toolbar.setTitle("Pontos Turísticos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        webView = (WebView) findViewById(R.id.web_lazer);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + getString(R.string.txt_lazer)
                + "</p>"
                + "</body></html>";

        webView.loadData(text,"text/html", "utf-8");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão
                startActivity(new Intent(lazerActivity.this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
