package pt.evote.evote.screens.eleicoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import pt.evote.evote.R;
import pt.evote.evote.model.Eleicao;
import pt.evote.evote.model.EleicaoCompleta;
import pt.evote.evote.model.EleicaoSimples;

public class ListaEleicoesActivity extends AppCompatActivity {

    ArrayList<Eleicao> listEleicao = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ListaEleicoesAdapter mAdapter;

    private static final int LOGOUT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleicoes);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new ListaEleicoesAdapter(listEleicao);
        mRecyclerView.setAdapter(mAdapter);

        setRecyclerViewScrollListener();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (listEleicao.size() == 0) {
            requestEleicoes();
        }
    }

    private int getLastVisibleItemPosition() {
        return mLinearLayoutManager.findLastVisibleItemPosition();
    }

    private void setRecyclerViewScrollListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int totalItemCount = mRecyclerView.getLayoutManager().getItemCount();
                if (totalItemCount == getLastVisibleItemPosition() + 1) {
                    requestEleicoes();
                }
            }
        });
    }

    private void requestEleicoes() {
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.HOUR, 8);

        Calendar close = rightNow;
        close.add(Calendar.HOUR, 18);

        Eleicao o1 = new EleicaoCompleta(1, "Associação Académica de Coimbra - OAF", "", rightNow.getTime(), close.getTime());
        o1.setInscrito(true);

        rightNow.add(Calendar.DAY_OF_MONTH, 1);
        close.add(Calendar.DAY_OF_MONTH, 1);
        Eleicao o2 = new EleicaoCompleta(2, "Automóvel Clube de Portugal - ACP", "", rightNow.getTime(), close.getTime());

        rightNow.add(Calendar.DAY_OF_MONTH, 7);
        close.add(Calendar.DAY_OF_MONTH, 7);
        Eleicao o3 = new EleicaoSimples(3, "Câmara Municipal de Coimbra", "", rightNow.getTime(), close.getTime());


        listEleicao.add(o3);
        listEleicao.add(o2);
        listEleicao.add(o1);

        Collections.sort(listEleicao);
        //TODO: Sort by date
    }


    public void onBackPressed() {
        //setResult(LOGOUT);
        super.onBackPressed();
    }
}