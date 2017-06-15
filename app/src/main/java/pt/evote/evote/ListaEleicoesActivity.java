package pt.evote.evote;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListaEleicoesActivity extends AppCompatActivity {

    List<EleicaoObj> listEleicaoObj = new ArrayList<EleicaoObj>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleicoes);

        Calendar rightNow = Calendar.getInstance();

        listEleicaoObj.add(new EleicaoObj("Associação Académica de Coimbra - OAF", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj("Automóvel Clube de Portugal - ACP", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj("Câmara Municipal de Coimbra", Uri.EMPTY, rightNow.getTime()));

        ListView yourListView = (ListView) findViewById(R.id.listview);

        // get data from the table by the ListAdapter
        EleicaoAdapter customAdapter = new EleicaoAdapter(this, R.layout.eleicaorow, listEleicaoObj);

        yourListView .setAdapter(customAdapter);
    }
}
