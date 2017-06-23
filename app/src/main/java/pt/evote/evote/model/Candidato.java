package pt.evote.evote.model;

import java.io.Serializable;

public class Candidato implements Serializable {

    private String nomeCandidato;
    private String fotoURI;
    private String descricao;

    public Candidato(String nome, String descricao, String fotoURI) {

        this.setNomeCandidato(nome);
        this.setFotoURI(fotoURI);
        this.setDescricao(descricao);
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
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
}
