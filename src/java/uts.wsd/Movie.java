package uts.wsd;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name="movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie implements Serializable {

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Genre")
    private String genre;

    @XmlElement(name = "Ryear")
    private String rYear;


    public Movie() {
    }

    public Movie(String title, String genre, String rYear) {
        this.title = title;
        this.genre = genre;
        this.rYear = rYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getrYear() {
        return rYear;
    }

    public void setrYear(String rYear) {
        this.rYear = rYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
