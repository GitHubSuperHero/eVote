package pt.evote.evote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class ListaEleicoesAdapter extends RecyclerView.Adapter<ListaEleicoesAdapter.EleicaoHolder> {

    private ArrayList<EleicaoObj> mEleicao;

    static class EleicaoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private EleicaoObj mEleicao;

        private TextView mItemName;
        private TextView mItemDate;
        private ImageView mItemLogo;

        private TextView mInscrito;

        private static final String ELEICAO_KEY = "ELEICAO";

        EleicaoHolder(View v) {
            super(v);

            mItemName = (TextView) v.findViewById(R.id.textNameView);
            mItemDate= (TextView) v.findViewById(R.id.textDateView);
            mItemLogo = (ImageView) v.findViewById(R.id.imageLogoView);

            mInscrito = (TextView) v.findViewById(R.id.textViewInscrito);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Click em mEleicao

            Context context = itemView.getContext();

            Bundle b = new Bundle();
            b.putSerializable(ELEICAO_KEY, mEleicao);

            if(mEleicao.getClass() == EleicaoCompleta.class){
                Intent eleicaoDetalhesIntent = new Intent(context, EleicaoCompletaDetalhes.class);
                eleicaoDetalhesIntent.putExtras(b);
                context.startActivity(eleicaoDetalhesIntent);
            }
            else if(mEleicao.getClass() == EleicaoSimples.class){
                Intent eleicaoDetalhesIntent = new Intent(context, EleicaoSimplesActivity.class);
                eleicaoDetalhesIntent.putExtras(b);
                context.startActivity(eleicaoDetalhesIntent);
            }

        }

        void bindEleicao(EleicaoObj eleicao) {
            mEleicao = eleicao;
            mItemName.setText(mEleicao.getName());
            mItemDate.setText(DateUtils.getRelativeTimeSpanString(mEleicao.getTimeOpen().getTime(), System.currentTimeMillis(), DateUtils.DAY_IN_MILLIS));

            if(mEleicao.isInscrito()){
                mInscrito.setVisibility(View.VISIBLE);
            }
            //mItemLogo.setImageURI(p.getImageURI()); //convert string to uri first
        }
    }

    ListaEleicoesAdapter(ArrayList<EleicaoObj> eleicaos) {
        mEleicao = eleicaos;
    }

    @Override
    public ListaEleicoesAdapter.EleicaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_eleicao, parent, false);
        return new EleicaoHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(ListaEleicoesAdapter.EleicaoHolder holder, int position) {
        EleicaoObj itemEleicao = mEleicao.get(position);
        holder.bindEleicao(itemEleicao);
    }

    @Override
    public int getItemCount() {
        return mEleicao.size();
    }
}
