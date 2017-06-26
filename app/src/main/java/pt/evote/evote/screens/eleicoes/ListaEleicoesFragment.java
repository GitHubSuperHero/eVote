package pt.evote.evote.screens.eleicoes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import pt.evote.evote.R;
import pt.evote.evote.eVoteApplication;
import pt.evote.evote.model.Eleicao;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaEleicoesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaEleicoesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaEleicoesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters
    private static final int LOGOUT = 2;
    ArrayList<Eleicao> listEleicao = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ListaEleicoesAdapter mAdapter;
    private eVoteApplication myApplication;

    private OnFragmentInteractionListener mListener;

    public ListaEleicoesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ListaEleicoesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaEleicoesFragment newInstance() {
        ListaEleicoesFragment fragment = new ListaEleicoesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_eleicoes, container, false);
        myApplication = (eVoteApplication) getActivity().getApplication();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new ListaEleicoesAdapter(listEleicao);
        mRecyclerView.setAdapter(mAdapter);

        setRecyclerViewScrollListener();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (listEleicao.size() == 0) {
            requestEleicoes();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
