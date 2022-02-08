package pac;

import dao.ActorDAO;
import entites.Actor;
import entites.Movie;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class ActorManagement implements ActorDAO {
    private  Scanner sc = new Scanner(System.in);
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    @Override
    public void createActor() {

        EntityManager em = emf.createEntityManager();

        System.out.print("First Name: ");
        String firstName = sc.nextLine();

        System.out.print("\nNickname: ");
        String nickName = sc.nextLine();

        System.out.print("\nLast Name: ");
        String lastName = sc.nextLine();

        Actor actor = new Actor(firstName, nickName, lastName);

        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void showAllActors() {

        EntityManager em = emf.createEntityManager();
        List<Actor> res = em.createQuery("SELECT a FROM Actor a", Actor.class).getResultList();
        System.out.println(res);

    }

    @Override
    public void updateArtist(int id) {

        EntityManager em = emf.createEntityManager();
        Actor actor = em.find(Actor.class, id);
        em.getTransaction().begin();

        System.out.print("new first name: ");
        String newFirstName = sc.nextLine();

        System.out.print("\n new nickname: ");
        String newNickName = sc.nextLine();

        System.out.print("\n new last name: ");
        String newLastName = sc.nextLine();

        actor.setFirstName(newFirstName);
        actor.setNickname(newNickName);
        actor.setLastName(newLastName);
        em.getTransaction().commit();

    }

    @Override
    public void deleteActor(int id) {

        EntityManager em = emf.createEntityManager();
        Actor actor = em.find(Actor.class, id);
        em.getTransaction().begin();
        em.remove(actor);
        System.out.println(actor + " have been deleted!");
        em.getTransaction().commit();

    }

    /**
     * if no actor found, throw EntityNotFoundException
     */
    @Override
    public Actor findArtistById(int id) {

        EntityManager em = emf.createEntityManager();
        Actor actor = em.find(Actor.class, id);

        if (actor == null) {
            throw new EntityNotFoundException("Can't find actor by id: " + id);
        }

        System.out.println(actor);
        return actor;

    }

    /**
     * connects an actor to a movie, an actor can belong to many movies
     */
    public void connectActorToMovie(int actorId, int movieId) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Actor actor = em.find(Actor.class, actorId);
        Movie movie = em.find(Movie.class, movieId);

        actor.addMovie(movie);
        em.getTransaction().commit();
        em.close();

    }

}