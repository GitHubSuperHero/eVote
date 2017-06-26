package pt.evote.evote.screens.eleicoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import pt.evote.evote.R;
import pt.evote.evote.eVoteApplication;
import pt.evote.evote.model.Eleicao;


public class ListaEleicoesActivity extends AppCompatActivity {

    private static final int LOGOUT = 2;
    ArrayList<Eleicao> listEleicao = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ListaEleicoesAdapter mAdapter;
    private eVoteApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleicoes);

        getSupportActionBar().setTitle(R.string.lista_eleicoes);

        myApplication = (eVoteApplication) getApplication();

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
        myApplication.fetchElections(listEleicao);
        Collections.sort(listEleicao);
    }


    public void onBackPressed() {
        //setResult(LOGOUT);
        super.onBackPressed();
    }
}