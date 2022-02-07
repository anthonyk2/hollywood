package entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    private String movieTitle;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ManyToMany
    private List<Actor> actor = new ArrayList<>();

    public List<Actor> getActor() {
        return actor;
    }

    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }

    // add and remove methods: useful for connecting these two entities

    public void addActor(Actor actor) {
        getActor().add(actor);
        actor.getMovie().add(this);
    }

    public void removeActor(Actor actor) {
        getActor().remove(actor);
        actor.getMovie().remove(this);
    }



    public Movie() {
    }

    public Movie(String movieTitle, int year) {
        this.movieTitle = movieTitle;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", year=" + year +
                ", actor=" + actor +
                '}';
    }
}