package dao;

import entites.Actor;

public interface ActorDAO {

    /** creates artist and adds to database */
    void createActor();

    /** shows all artists from the database */
    void showAllActors();

    /** updates artist, takes id in the parameters */
    void updateArtist(int id);

    /** deletes artist, takes id in the parameters */
    void deleteActor(int id);

    /** finds artist by id */
    Actor findArtistById(int id);
}
