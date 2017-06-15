package pt.evote.evote;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;

public class EleicaoDetalhes extends AppCompatActivity {

    private static final String ELEICAO_KEY = "ELEICAO";
    int eleicaoID;
    EleicaoObj eleicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleicao_detalhes);

        Intent intent = getIntent();
        eleicaoID = intent.getIntExtra(ELEICAO_KEY, 0);

        eleicao = getEleicaoByID(eleicaoID);


    }

    private EleicaoObj getEleicaoByID(int eleicaoID) {
        //TODO
        Context context = getApplicationContext();
        CharSequence text = "Not Done. Showing a premade election!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        //


        return new EleicaoObj(1,"Associação Académica de Coimbra - OAF", Uri.EMPTY, Calendar.getInstance().getTime());
    }
}
