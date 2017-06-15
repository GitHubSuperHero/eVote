package pt.evote.evote;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListaEleicoesActivity extends AppCompatActivity {

    ArrayList<EleicaoObj> listEleicaoObj = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleicoes);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new RecyclerAdapter(listEleicaoObj);
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

        listEleicaoObj.add(new EleicaoObj(1,"Associação Académica de Coimbra - OAF", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(2,"Automóvel Clube de Portugal - ACP", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(3,"Câmara Municipal de Coimbra", Uri.EMPTY, rightNow.getTime()));

        listEleicaoObj.add(new EleicaoObj(4,"(1) Associação Académica de Coimbra - OAF", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(5,"(1) Automóvel Clube de Portugal - ACP", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(6,"(1) Câmara Municipal de Coimbra", Uri.EMPTY, rightNow.getTime()));

        listEleicaoObj.add(new EleicaoObj(7,"(2) Associação Académica de Coimbra - OAF", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(8,"(2) Automóvel Clube de Portugal - ACP", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(9,"(2) Câmara Municipal de Coimbra", Uri.EMPTY, rightNow.getTime()));

        listEleicaoObj.add(new EleicaoObj(10,"(3) Associação Académica de Coimbra - OAF", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(11,"(3) Automóvel Clube de Portugal - ACP", Uri.EMPTY, rightNow.getTime()));
        listEleicaoObj.add(new EleicaoObj(12,"(3) Câmara Municipal de Coimbra", Uri.EMPTY, rightNow.getTime()));
    }
}
