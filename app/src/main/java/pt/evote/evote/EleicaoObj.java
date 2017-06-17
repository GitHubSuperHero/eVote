package pt.evote.evote;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class EleicaoObj implements Serializable {

    private int id;
    private String name;
    private String imageURI;
    private Date timeLimit;
    private boolean inscrito;

    private ArrayList<Noticia> listaNoticias = new ArrayList<>();

    EleicaoObj(int id, String name, String image, Date timeLimit){
        this.setId(id);
        this.setName(name);
        this.setImageURI(image);
        this.setTimeLimit(timeLimit);

        this.setInscrito(false);

        addNoticia(new Noticia("Trump did things",
                "He did another bad thing... But is there anyone that didn't expect that?",
                "sapo.pt", "www.sapo.pt", "16/06/2017", ""));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String image) {
        this.imageURI = image;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInscrito() {
        return inscrito;
    }

    public void setInscrito(boolean inscrito) {
        this.inscrito = inscrito;
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
