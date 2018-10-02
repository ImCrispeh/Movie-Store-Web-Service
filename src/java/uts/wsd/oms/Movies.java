package uts.wsd.oms;

import javax.xml.bind.annotation.*;
import java.util.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movies")
public class Movies implements Serializable {

    @XmlElement(name = "movie")
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public ArrayList<Movie> getList() {
        return movies;
    }

    public void addMovie(Movie movie) {
        int i = movies.indexOf(movie);
        if (i > -1)
            movies.get(i).incrementCopies(movie.getCopies());
        else
            movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        int i = movies.indexOf(movie);
        if (i > -1 && movies.get(i).getCopies() > 1)
            movies.get(i).decrementCopies(movie.getCopies());
        else
            movies.remove(movie);
    }
    
    public void removeMovie(String title, String releaseDate) {
        if(movies.stream().filter(m -> m.getTitle().equals(title) && m.getReleaseDate().equals(releaseDate)).findFirst().isPresent())
        {
            removeMovie(movies.stream().filter(m -> m.getTitle().equals(title) && m.getReleaseDate().equals(releaseDate)).findFirst().get());
        }
    }
}
