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
import pt.evote.evote.model.Lista;
import pt.evote.evote.screens.ListasActivity;

public class ListaListaAdapter extends RecyclerView.Adapter<ListaListaAdapter.ListaHolder> {
    private ArrayList<Lista> mLista;

    ListaListaAdapter(ArrayList<Lista> lista) {
        mLista = lista;
    }

    @Override
    public ListaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_lista, parent, false);
        return new ListaHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ListaHolder holder, int position) {
        Lista itemLista = mLista.get(position);
        holder.bindEleicao(itemLista);
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    static class ListaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private static final String LISTA_KEY = "LISTA";
        private Lista mLista;
        private ImageView mImagem;
        private TextView mName;
        private TextView mDescription;

        ListaHolder(View v) {
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
            b.putSerializable(LISTA_KEY, mLista);

            Intent listaIntent = new Intent(context, ListasActivity.class);
            listaIntent.putExtras(b);
            context.startActivity(listaIntent);
        }

        void bindEleicao(Lista lista) {
            mLista = lista;
            //mImagem.setImageURI(mLista.getFotoURI()); //TODO: Convert to URI first
            mName.setText(mLista.getNomeLista());
            mDescription.setText(mLista.getDescricao());
            ///TODO: other fields
        }
    }
}
