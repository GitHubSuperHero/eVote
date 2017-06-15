package pt.evote.evote;

import android.net.Uri;

import java.util.Date;

public class EleicaoObj {

    private int id;
    private String name;
    private Uri image;
    private Date timeLimit;
    private boolean inscrito;

    EleicaoObj(int id, String name, Uri image, Date timeLimit){
        this.setName(name);
        this.setImage(image);
        this.setTimeLimit(timeLimit);

        this.setInscrito(false);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
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
}
