package bo.edu.ucbcba.hotel.controller;

import bo.edu.ucbcba.hotel.dao.usersEntityManager;
import bo.edu.ucbcba.hotel.model.Clients;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by CésarIvan on 19/05/2016.
 */
public class ClientController {
    public void create(String firstName,String lastName, int ci, int phone ){

        Clients client=new Clients();
        client.setClientCi(ci);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhone(phone);


        EntityManager entityManager = usersEntityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Clients> searchClients(String CI) {
        int ci=0;
        if(CI.matches("[0-9]+")){
            if(CI.isEmpty()) {
                ci=0;
            } else {
                ci=Integer.parseInt(CI);
            }
        }
        EntityManager entityManager = usersEntityManager.createEntityManager();
        if(ci!=0)
        {
            TypedQuery<Clients> query = entityManager.createQuery("select s from Clients s where s.ClientCi= :a ", Clients.class);
            query.setParameter("a", ci);
            List<Clients> response = query.getResultList();
            entityManager.close();
            return response;
        }
        if (ci == 0) {
            TypedQuery<Clients> query = entityManager.createQuery("select s from Clients s ", Clients.class);
            //query.setParameter("a", a);
            List<Clients> response = query.getResultList();
            entityManager.close();
            return response;
        }
        return null;
    }


    public void delete (int id) {

        EntityManager entityManager = usersEntityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Clients.class,(id)));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

}

