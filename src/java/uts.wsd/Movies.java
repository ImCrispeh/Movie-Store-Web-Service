package uts.wsd;

import javax.xml.bind.annotation.*;
import java.util.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movies")
public class Movies implements Serializable {

    @XmlElement(name = "movie")
    private ArrayList<Movie> list = new ArrayList<Movie>();

    public ArrayList<Movie> getList() {
        return list;
    }

    public void addMovie(Movie movie) {
        list.add(movie);
    }

    public void removemovie(Movie movie) {
        list.remove(movie);
    }
}