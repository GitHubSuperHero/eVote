package pt.evote.evote.screens;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pt.evote.evote.R;
import pt.evote.evote.model.EleicaoSimples;
import pt.evote.evote.screens.vote.VoteFragment;

public class EleicaoSimplesActivity extends AppCompatActivity implements VoteFragment.OnFragmentInteractionListener {

    private static final String ELEICAO_KEY = "ELEICAO";
    EleicaoSimples mEleicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleicao_simples);

        Bundle b = this.getIntent().getExtras();
        if (b != null)
            mEleicao = (EleicaoSimples) b.getSerializable(ELEICAO_KEY);

        Fragment frag = VoteFragment.newInstance(mEleicao);

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.containerEleicaoSimples, frag, frag.getTag());
            ft.commit();
        } else {
            errorToast();
        }
    }

    private void errorToast() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.errorRetriveElection);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
