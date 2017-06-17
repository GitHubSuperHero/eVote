package pt.evote.evote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class ListaEleicoesActivity extends AppCompatActivity {

    ArrayList<EleicaoObj> listEleicaoObj = new ArrayList<>();

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

        mAdapter = new ListaEleicoesAdapter(listEleicaoObj);
        mRecyclerView.setAdapter(mAdapter);

        setRecyclerViewScrollListener();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (listEleicaoObj.size() == 0) {
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

        EleicaoObj o1 = new EleicaoObj(1,"Associação Académica de Coimbra - OAF", "", rightNow.getTime());
        o1.setInscrito(true);

        rightNow.add(Calendar.DAY_OF_MONTH,1);
        EleicaoObj o2 = new EleicaoObj(2,"Automóvel Clube de Portugal - ACP", "", rightNow.getTime());

        rightNow.add(Calendar.DAY_OF_MONTH,7);
        EleicaoObj o3 = new EleicaoObj(3,"Câmara Municipal de Coimbra", "", rightNow.getTime());


        listEleicaoObj.add(o3);
        listEleicaoObj.add(o2);
        listEleicaoObj.add(o1);

        Collections.sort(listEleicaoObj);
        //TODO: Sort by date
    }


    public void onBackPressed(){
        //setResult(LOGOUT);
        super.onBackPressed();
    }
}
