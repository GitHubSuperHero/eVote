package pt.evote.evote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EleicaoAdapter extends ArrayAdapter<EleicaoObj> {

    public EleicaoAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public EleicaoAdapter(Context context, int resource, List<EleicaoObj> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.eleicaorow, null);
        }

        EleicaoObj p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.textView);
            ImageView tt2 = (ImageView) v.findViewById(R.id.imageView);

            if (tt1 != null) {
                tt1.setText(p.getName());
            }

            if (tt2 != null) {
                //tt2.setImageURI(p.getImage());
            }
        }
        return v;
    }
}
