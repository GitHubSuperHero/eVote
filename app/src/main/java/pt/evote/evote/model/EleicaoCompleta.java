package pt.evote.evote.model;

import java.util.ArrayList;
import java.util.Date;


public class EleicaoCompleta extends Eleicao {

    private ArrayList<Noticia> listaNoticias = new ArrayList<>();


    public EleicaoCompleta(int id, String name, String image, Date timeOpen, Date timeClose) {
        super(id, name, image, timeOpen, timeClose);

        addNoticia(new Noticia("Trump did things",
                "He did another bad thing... But is there anyone that didn't expect that?",
                "sapo.pt", "www.sapo.pt", "16/06/2017", ""));
    }

    public ArrayList<Noticia> getListaNoticias() {
        return listaNoticias;
    }

    public void setListaNoticias(ArrayList<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    public void addNoticia(Noticia noticia) {
        this.listaNoticias.add(noticia);
    }
}
