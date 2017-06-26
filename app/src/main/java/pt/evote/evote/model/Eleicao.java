package pt.evote.evote.model;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public abstract class Eleicao implements Serializable, Comparable<Eleicao>, Comparator<Eleicao> {

    private int id;
    private String name;
    private String imageURI;
    private Date timeOpen;
    private Date timeClose;
    private boolean inscrito;

    private ArrayList<Lista> listaLista = new ArrayList<>();

    Eleicao(int id, String name, String image, Date timeOpen, Date timeClose) {
        this.setId(id);
        this.setName(name);
        this.setImageURI(image);
        this.setTimeOpen(timeOpen);
        this.setTimeClose(timeClose);

        this.setInscrito(false);

        addLista(new Lista("Lista A", "A lista do povo", ""));

        addLista(new Lista("Lista B", "A lista dos ricos", ""));
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

    public Date getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(Date timeClose) {
        this.timeClose = timeClose;
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

    @Override
    public int compareTo(@NonNull Eleicao o) {
        return this.timeOpen.compareTo(o.timeOpen);
    }

    @Override
    public int compare(Eleicao o, Eleicao t1) {
        return o.timeOpen.compareTo(t1.timeOpen);
    }

    public ArrayList<Lista> getListaLista() {
        return listaLista;
    }

    public void setListaLista(ArrayList<Lista> listaLista) {
        this.listaLista = listaLista;
    }

    public void addLista(Lista lista) {
        this.listaLista.add(lista);
    }

    public Date getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(Date timeOpen) {
        this.timeOpen = timeOpen;
    }
}
