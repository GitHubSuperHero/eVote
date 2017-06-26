package pt.evote.evote.model;

import java.util.ArrayList;
import java.util.Date;


public class EleicaoCompleta extends Eleicao {

    private ArrayList<Noticia> listaNoticias = new ArrayList<>();


    public EleicaoCompleta(int id, String name, String image, Date timeOpen, Date timeClose) {
        super(id, name, image, timeOpen, timeClose);
        //TODO: fetch noticias?
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
