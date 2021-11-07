package level.up.kaabar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MainUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List res = entityManager.createQuery("select u from user u").getResultList();

    }
}
