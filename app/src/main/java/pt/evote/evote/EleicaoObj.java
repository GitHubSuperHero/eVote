package pt.evote.evote;

import android.net.Uri;

import java.util.Date;

public class EleicaoObj {

    private String name;
    private Uri image;
    private Date timeLimit;

    EleicaoObj(String name, Uri image, Date timeLimit){
        this.setName(name);
        this.setImage(image);
        this.setTimeLimit(timeLimit);

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
}
