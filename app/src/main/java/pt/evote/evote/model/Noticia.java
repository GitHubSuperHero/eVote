package pt.evote.evote.model;

import java.io.Serializable;

public class Noticia implements Serializable {
    private String title;
    private String body;
    private String source;
    private String url;
    private String date;
    private String imageURI;

    public Noticia(String title, String body, String source, String url, String date, String imageURI) {
        this.setBody(body);
        this.setDate(date);
        this.setImageURI(imageURI);
        this.setSource(source);
        this.setTitle(title);
        this.setUrl(url);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }
}
