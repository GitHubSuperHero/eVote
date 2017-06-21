package pt.evote.evote;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class CandidatoDetalhesActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    Candidato mCandidato;

    private static final String CANDIDATO_KEY = "CANDIDATO";

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidato_detalhes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Detalhes do Candidato");
        setSupportActionBar(toolbar);


        Bundle b = this.getIntent().getExtras();
        if (b != null)
            mCandidato = (Candidato) b.getSerializable(CANDIDATO_KEY);
        else{
            errorToast();
        }


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), mCandidato);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_candidato_detalhes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public static class CandidatoDetalhesFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String CANDIDATO_KEY = "CANDIDATO";
        Candidato mCandidato;

        public CandidatoDetalhesFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static CandidatoDetalhesFragment newInstance(Candidato mCandidato) {
            CandidatoDetalhesFragment fragment = new CandidatoDetalhesFragment();
            Bundle args = new Bundle();
            args.putSerializable(CANDIDATO_KEY, mCandidato);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mCandidato = (Candidato) getArguments().getSerializable(CANDIDATO_KEY);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_candidato_detalhes, container, false);

            //TODO: Populate layout

            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class CandidatoCampanhaFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String CANDIDATO_KEY = "CANDIDATO";
        Candidato mCandidato;

        public CandidatoCampanhaFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static CandidatoCampanhaFragment newInstance(Candidato mCandidato) {
            CandidatoCampanhaFragment fragment = new CandidatoCampanhaFragment();
            Bundle args = new Bundle();
            args.putSerializable(CANDIDATO_KEY, mCandidato);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mCandidato = (Candidato) getArguments().getSerializable(CANDIDATO_KEY);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_candidato_campanha, container, false);

            //TODO: Populate layout

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        Candidato mCandidato;

        public SectionsPagerAdapter(FragmentManager fm, Candidato mCandidato) {
            super(fm);

            this.mCandidato = mCandidato;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            switch(position){
                case 0: return CandidatoDetalhesFragment.newInstance(mCandidato);
                case 1: return CandidatoCampanhaFragment.newInstance(mCandidato);
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
                    return "Candidato";
                case 1:
                    return "Campanha";
            }
            return null;
        }
    }
}
