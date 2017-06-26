package pt.evote.evote.screens;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import pt.evote.evote.R;
import pt.evote.evote.eVoteApplication;
import pt.evote.evote.model.EleicaoCompleta;
import pt.evote.evote.screens.candidatos.CandidatosFragment;
import pt.evote.evote.screens.noticias.NoticiasFragment;
import pt.evote.evote.screens.userProfile.ProfileFragment;
import pt.evote.evote.screens.vote.VoteFragment;

public class EleicaoCompletaActivity extends AppCompatActivity implements VoteFragment.OnFragmentInteractionListener,
        NoticiasFragment.OnFragmentInteractionListener, CandidatosFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener {

    private static final String ELEICAO_KEY = "ELEICAO";
    private static final String SELECTED_ITEM = "arg_selected_item";
    EleicaoCompleta mEleicao;
    BottomNavigationView mBottomNav;
    private eVoteApplication myApp;
    private int mSelectedItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleicao_completa_detalhes);

        myApp = (eVoteApplication) getApplication();
    try{
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }catch(NullPointerException e){
        Log.w("Back Button", e.getMessage());
    }

        Bundle b = this.getIntent().getExtras();
        if (b != null)
            mEleicao = (EleicaoCompleta) b.getSerializable(ELEICAO_KEY);
        else {
            errorToast();
        }

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.inflateMenu(R.menu.bottom_nav_items);

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }
        selectFragment(selectedItem);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.menu_noticias:
                frag = NoticiasFragment.newInstance(mEleicao);
                break;
            case R.id.menu_candidatos:
                frag = CandidatosFragment.newInstance(mEleicao);
                break;
            case R.id.menu_vote:
                frag = VoteFragment.newInstance(mEleicao);
                break;
            case R.id.menu_user:
                frag = ProfileFragment.newInstance(myApp.getLoggedInUser());
                break;
        }

        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        /*for (int i = 0; i< mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }*/

        updateToolbarText(item.getTitle());

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, frag, frag.getTag());
            ft.commit();
        }
    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
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
