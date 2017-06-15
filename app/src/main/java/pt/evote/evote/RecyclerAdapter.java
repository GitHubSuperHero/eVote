package pt.evote.evote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.EleicaoHolder> {

    private ArrayList<EleicaoObj> mEleicao;

    static class EleicaoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private EleicaoObj mEleicao;

        private TextView mItemName;
        private TextView mItemDate;
        private ImageView mItemLogo;


        private static final String ELEICAO_KEY = "ELEICAO";

        EleicaoHolder(View v) {
            super(v);

            mItemName = (TextView) v.findViewById(R.id.textNameView);
            mItemDate= (TextView) v.findViewById(R.id.textDateView);
            mItemLogo = (ImageView) v.findViewById(R.id.imageLogoView);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Click em eleicao

            Context context = itemView.getContext();
            Intent eleicaoDetalhesIntent = new Intent(context, EleicaoDetalhes.class);
            eleicaoDetalhesIntent.putExtra(ELEICAO_KEY, mEleicao.getId());
            context.startActivity(eleicaoDetalhesIntent);
        }


        void bindEleicao(EleicaoObj eleicao) {
            mEleicao = eleicao;
            mItemName.setText(mEleicao.getName());
            mItemDate.setText(mEleicao.getTimeLimit().toString());
            //mItemLogo.setImageURI(p.getImage());
        }
    }

    RecyclerAdapter(ArrayList<EleicaoObj> eleicaos) {
        mEleicao = eleicaos;
    }

    @Override
    public RecyclerAdapter.EleicaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.eleicaorow, parent, false);
        return new EleicaoHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(RecyclerAdapter.EleicaoHolder holder, int position) {
        EleicaoObj itemEleicao = mEleicao.get(position);
        holder.bindEleicao(itemEleicao);
    }

    @Override
    public int getItemCount() {
        return mEleicao.size();
    }
}
