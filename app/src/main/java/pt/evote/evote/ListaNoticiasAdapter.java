package pt.evote.evote;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class ListaNoticiasAdapter extends RecyclerView.Adapter<ListaNoticiasAdapter.NoticiaHolder> {

    private ArrayList<Noticia> mNoticias;

    static class NoticiaHolder extends RecyclerView.ViewHolder {

        private Noticia mNoticia;

        private TextView mTitle;
        private TextView mBody;
        private TextView mDate;
        private TextView mSource;

        NoticiaHolder(View v) {
            super(v);

            mTitle = (TextView) v.findViewById(R.id.textViewTitle);
            mBody = (TextView) v.findViewById(R.id.textViewBody);
            mDate = (TextView) v.findViewById(R.id.textViewDate);
            mSource = (TextView) v.findViewById(R.id.textViewSource);
            ///TODO: other fields

        }

        void bindEleicao(Noticia noticia) {
            mNoticia = noticia;
            mTitle.setText(noticia.getTitle());
            mBody.setText(noticia.getBody());
            mDate.setText(noticia.getDate());
            mSource.setText(noticia.getSource());
            ///TODO: other fields
        }
    }

    ListaNoticiasAdapter(ArrayList<Noticia> noticia) {
        mNoticias = noticia;
    }

    @Override
    public ListaNoticiasAdapter.NoticiaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.noticia_row, parent, false);
        return new ListaNoticiasAdapter.NoticiaHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(ListaNoticiasAdapter.NoticiaHolder holder, int position) {
        Noticia itemNoticia = mNoticias.get(position);
        holder.bindEleicao(itemNoticia);
    }

    @Override
    public int getItemCount() {
        return mNoticias.size();
    }



}
