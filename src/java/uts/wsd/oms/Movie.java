package uts.wsd.oms;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name="movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie implements Serializable {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "tenre")
    private String genre;

    @XmlElement(name = "releaseDate")
    private String releaseDate;
    
    @XmlElement(name = "price")
    private float price;

    @XmlElement(name = "copies")
    private String copies;


    public Movie() {
    }

    public Movie(String title, String genre, String releaseDate) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCopies() {
        return copies;
    }

    public void setCopies(String copies) {
        this.copies = copies;
    }
}
