package entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(mappedBy = "actor")
    private List<Movie> movie = new ArrayList<>();

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> music) {
        this.movie = music;
    }

    public void addMovie(Movie movie) {
        getMovie().add(movie);
        movie.getActor().add(this);
    }

    public void removeMovie(Movie movie) {
        getMovie().remove(movie);
        movie.getActor().remove(this);
    }

    public Actor() {
    }


    public Actor(String firstName, String nickname, String lastName) {
        this.firstName = firstName;
        this.nickname = nickname;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", music=" + movie +
                '}';
    }
}