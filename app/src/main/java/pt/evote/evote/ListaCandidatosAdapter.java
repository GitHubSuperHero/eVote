package pt.evote.evote;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaCandidatosAdapter extends RecyclerView.Adapter<ListaCandidatosAdapter.CandidatoHolder>{
    private ArrayList<Candidato> mCandidatos;

    static class CandidatoHolder extends RecyclerView.ViewHolder {

        private Candidato mCandidato;

        private ImageView mImagem;
        private TextView mName;
        private TextView mDescription;

        CandidatoHolder(View v) {
            super(v);

            mImagem = (ImageView) v.findViewById(R.id.imageCandidate);
            mName = (TextView) v.findViewById(R.id.textViewCandidateName);
            mDescription = (TextView) v.findViewById(R.id.textViewCandidateDescription);
            ///TODO: other fields

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
