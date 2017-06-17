package pt.evote.evote;


import java.io.Serializable;
import java.util.Date;

public class EleicaoObj implements Serializable {

    private int id;
    private String name;
    private String image;
    private Date timeLimit;
    private boolean inscrito;

    EleicaoObj(int id, String name, String image, Date timeLimit){
        this.setId(id);
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
