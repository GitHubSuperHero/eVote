package pt.evote.evote.screens.noticias;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pt.evote.evote.R;
import pt.evote.evote.model.Noticia;

public class ListaNoticiasAdapter extends RecyclerView.Adapter<ListaNoticiasAdapter.NoticiaHolder> {

    private ArrayList<Noticia> mNoticias;

    ListaNoticiasAdapter(ArrayList<Noticia> noticia) {
        mNoticias = noticia;
    }

    @Override
    public ListaNoticiasAdapter.NoticiaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_noticia, parent, false);
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

    static class NoticiaHolder extends RecyclerView.ViewHolder {

        private Noticia mNoticia;

        private TextView mTitle;
        private TextView mBody;
        private TextView mDate;
        private TextView mSource;
        private ImageView mImage;

        NoticiaHolder(View v) {
            super(v);

            mTitle = (TextView) v.findViewById(R.id.textViewTitle);
            mBody = (TextView) v.findViewById(R.id.textViewBody);
            mDate = (TextView) v.findViewById(R.id.textViewDate);
            mSource = (TextView) v.findViewById(R.id.textViewSource);
            mImage = (ImageView) v.findViewById(R.id.imageViewNews);
            ///TODO: other fields like the URL

        }

        void bindEleicao(Noticia noticia) {
            mNoticia = noticia;

            mTitle.setText(mNoticia.getTitle());
            mBody.setText(mNoticia.getBody());
            mDate.setText(mNoticia.getDate());
            mSource.setText(mNoticia.getSource());

            if (mNoticia.getImageURI() != null && !mNoticia.getImageURI().isEmpty()) {
                mImage.setImageURI(Uri.parse(mNoticia.getImageURI()));
            }
            ///TODO: other fields like the URL
        }
    }

}
