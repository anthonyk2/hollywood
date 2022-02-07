package dao;

public interface MovieDAO {

    /** creates a movie */
    void createMovie();

    /** allows user to choose movies to be listed from a chosen year */
    void showAllMoviesFromYear();

    /** deletes movie and removes all the actors that is connected to the move */
    void deleteMovie();

}
