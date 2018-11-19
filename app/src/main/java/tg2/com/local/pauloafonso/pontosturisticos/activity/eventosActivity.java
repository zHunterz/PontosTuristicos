package tg2.com.local.pauloafonso.pontosturisticos.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import tg2.com.local.pauloafonso.pontosturisticos.R;

public class eventosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        toolbar = (Toolbar) findViewById(R.id.toolbar_eventos);
        toolbar.setTitle("Pontos Turísticos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        webView = (WebView) findViewById(R.id.web_eventos);

        String text = "<html><body>"
                + "<h3 align=\"center\">Moto Energia</h3>"
                + "<p align=\"justify\">"
                + "O moto energia é um dos maiores encontros de motociclistas do Nordeste. O evento reúne Moto Clubes de todo o país, reunindo milhares de pessoas e turistas, já os motociclistas que ainda aproveitam o evento para desfilar suas maquinas pelas ruas da cidade e animar a galera com o ronco dos motores e toda beleza das maquinas ainda aproveita a visita para conhecer as belezas naturais e os outros atrativos turísticos de Paulo Afonso como a ponte metálica, ilha do urubu, complexo hidrelétrico e para relaxar um passeio de catamarã pelo cânion do Rio São Francisco"
                + "</p>"
                + "<h3 align=\"center\">Copa Vela</h3>"
                + "<p align=\"justify\">"
                + "O balneário Encantos Mil mais conhecida como Prainha é Palco da Copa Vela, evento que atraí desportistas de todo país em busca da competição náutica de velas como as classes hobie cat, laser, Dingue, Wind-Surf e Kitesurf, nesse cenário passou a ser palco do carnaval fora de época que tem uma característica peculiar a mistura de ritmos de grandes shows musicais em trios elétricos."
                + "</p>"
                + "<h3 align=\"center\">Celebrai</h3>"
                + "<p align=\"justify\">"
                + "Um momento de alegria, adoração e celebração nos dois dias do Celebrai, que a cada ano leva milhares de pessoas, também é marcado pela diversidade de público que comparece aos shows: evangélicos, católicos, simpatizantes, crianças, jovens e adultos; todos reunidos na consagração da festa da família em Paulo Afonso. Gente de diversas cidades da Bahia e dos estados vizinhos Sergipe, Alagoas e Pernambuco está presentes em caravanas. Mãos levantadas, gritos, lágrimas, aplausos. As coreografias feitas pelo público fazem um show à parte no espetáculo do Celebrai."
                + "</p>"
                + "<h3 align=\"center\">São João</h3>"
                + "<p align=\"justify\">"
                + "Os festejos juninos de Paulo Afonso, conta com as apresentações de quadrilhas tradicionais interagindo com o público, cidade cenográfica, casamento do matuto, queima de fogueira e as barracas com comidas típicas da região. O ponto alto acontece para quem quer curtir muita música, promovendo o São João animado pelo chamado forró pé-de-serra (sanfona, pandeiro e triângulo) e atrações Nacionais variadas para agradar todos os gostos."
                + "</p>"
                + "<h3 align=\"center\">Natal</h3>"
                + "<p align=\"justify\">"
                + "Em Dezembro, a cidade se reúne mais uma vez na principal praça de Paulo Afonso, o Parque das Mangueiras, para viver a magia do Natal. São duas semanas de shows dos mais variados estilos: Gospel, MPB, Pop Rock, Voz e Violão. Corais e grupos de recital trazem todos os dias a magia do natal, abrindo a programação. Além disso, a praça se transforma no país encantado de Papai Noel, onde sua casa fica instalada e este recebe crianças e familiares."
                + "</p>"
                + "</body></html>";

        webView.loadData(text,"text/html", "utf-8");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão
                startActivity(new Intent(eventosActivity.this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
