package pt.evote.evote.screens;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pt.evote.evote.R;
import pt.evote.evote.model.Lista;

public class ListasActivity extends AppCompatActivity {

    private static final String LISTA_KEY = "LISTA";
    Lista mLista;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_candidatos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Listas");

        setSupportActionBar(toolbar);
    try {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }catch(NullPointerException e){
        Log.w("Back Button", e.getMessage());
    }

        Bundle b = this.getIntent().getExtras();
        if (b != null)
            mLista = (Lista) b.getSerializable(LISTA_KEY);
        else {
            errorToast();
        }


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), mLista);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void errorToast() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.erro_dados_campanha);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        finish();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class ListaCandidatosFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String LISTA_KEY = "LISTA";
        Lista mLista;

        public ListaCandidatosFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ListaCandidatosFragment newInstance(Lista mLista) {
            ListaCandidatosFragment fragment = new ListaCandidatosFragment();
            Bundle args = new Bundle();
            args.putSerializable(LISTA_KEY, mLista);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mLista = (Lista) getArguments().getSerializable(LISTA_KEY);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_lista_detalhes, container, false);

            //TODO: Populate layout

            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class ListaCampanhaFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String LISTA_KEY = "LISTA";
        Lista mLista;

        public ListaCampanhaFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ListaCampanhaFragment newInstance(Lista mLista) {
            ListaCampanhaFragment fragment = new ListaCampanhaFragment();
            Bundle args = new Bundle();
            args.putSerializable(LISTA_KEY, mLista);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mLista = (Lista) getArguments().getSerializable(LISTA_KEY);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_lista_campanha, container, false);

            //TODO: Populate layout

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        Lista mLista;

        public SectionsPagerAdapter(FragmentManager fm, Lista mLista) {
            super(fm);

            this.mLista = mLista;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            switch (position) {
                case 0:
                    return ListaCandidatosFragment.newInstance(mLista);
                case 1:
                    return ListaCampanhaFragment.newInstance(mLista);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Candidatos";
                case 1:
                    return "Campanha";
            }
            return null;
        }
    }
}
