package pac;

import dao.ActorDAO;
import entites.Actor;
import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class ActorManagement implements ActorDAO {
    private Scanner sc = new Scanner(System.in);
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


    }

    @Override
    public void deleteActor(int id) {


    }

    /**
     * if no actor found, throw EntityNotFoundException
     */
    @Override
    public Actor findArtistById(int id) {
        return null;
    }


}