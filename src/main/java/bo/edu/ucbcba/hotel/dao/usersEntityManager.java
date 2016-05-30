package bo.edu.ucbcba.hotel.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// This is a singleton that give us a entity manager to manage
// in the entire DAO
public class usersEntityManager {
    private static usersEntityManager entityManager;

    private EntityManagerFactory entityManagerFactory;

    private usersEntityManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("HotelDB");
    }

    private static usersEntityManager getInstance() {
        if (entityManager == null)
            entityManager = new usersEntityManager();
        return entityManager;
    }

    public static EntityManager createEntityManager() {
        return getInstance().entityManagerFactory.createEntityManager();
    }
}