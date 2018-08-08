package tg2.com.local.pauloafonso.pontosturisticos.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "ptpa_preferences";
    private int MODE = 0;
    private SharedPreferences.Editor editor;
    private String CHAVE_IDENTIFICADOR = "idUsuario";

    public Preferencias(Context contextParametro){

        contexto = contextParametro;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void salvarDados(String idUsuario) {

        editor.putString(CHAVE_IDENTIFICADOR, idUsuario);
        editor.commit();

    }

    public String getId(){
        return preferences.getString(CHAVE_IDENTIFICADOR,null);
    }

}
