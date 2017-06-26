package pt.evote.evote.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Leonardo on 26/06/2017.
 */

public class Lista implements Serializable {

    private ArrayList<Candidato> candidatos;
    private String nomeLista;
    private String fotoURI;
    private String descricao;

    public Lista(String nome, String descricao, String fotoURI) {

        this.setNomeLista(nome);
        this.setFotoURI(fotoURI);
        this.setDescricao(descricao);
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getFotoURI() {
        return fotoURI;
    }

    public void setFotoURI(String fotoURI) {
        this.fotoURI = fotoURI;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addCandidato(Candidato candidato) {
        this.candidatos.add(candidato);
    }
}
