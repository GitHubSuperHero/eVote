package pt.evote.evote.screens.candidatos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pt.evote.evote.R;
import pt.evote.evote.model.Candidato;
import pt.evote.evote.screens.ListasActivity;

public class ListaCandidatosAdapter extends RecyclerView.Adapter<ListaCandidatosAdapter.CandidatoHolder> {
    private ArrayList<Candidato> mCandidatos;

    static class CandidatoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Candidato mCandidato;

        private ImageView mImagem;
        private TextView mName;
        private TextView mDescription;

        private static final String CANDIDATO_KEY = "CANDIDATO";

        CandidatoHolder(View v) {
            super(v);

            mImagem = (ImageView) v.findViewById(R.id.imageCandidate);
            mName = (TextView) v.findViewById(R.id.textViewCandidateName);
            mDescription = (TextView) v.findViewById(R.id.textViewCandidateDescription);
            ///TODO: other fields

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context context = itemView.getContext();

            Bundle b = new Bundle();
            b.putSerializable(CANDIDATO_KEY, mCandidato);

            Intent candidatosIntent = new Intent(context, ListasActivity.class);
            candidatosIntent.putExtras(b);
            context.startActivity(candidatosIntent);
        }

        void bindEleicao(Candidato candidato) {
            mCandidato = candidato;
            //mImagem.setImageURI(mCandidato.getFotoURI()); //TODO: Convert to URI first
            mName.setText(mCandidato.getNomeCandidato());
            mDescription.setText(mCandidato.getDescricao());
            ///TODO: other fields
        }
    }

    ListaCandidatosAdapter(ArrayList<Candidato> candidatos) {
        mCandidatos = candidatos;
    }

    @Override
    public ListaCandidatosAdapter.CandidatoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_candidato, parent, false);
        return new ListaCandidatosAdapter.CandidatoHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ListaCandidatosAdapter.CandidatoHolder holder, int position) {
        Candidato itemCandidato = mCandidatos.get(position);
        holder.bindEleicao(itemCandidato);
    }

    @Override
    public int getItemCount() {
        return mCandidatos.size();
    }
}
