package bo.edu.ucbcba.hotel.controller;

import bo.edu.ucbcba.hotel.dao.usersEntityManager;
import bo.edu.ucbcba.hotel.model.Rooms;
import bo.edu.ucbcba.hotel.exceptions.ValidationException;
import bo.edu.ucbcba.hotel.model.Services;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoomController {

    public void create(String type,String view, boolean availability, boolean phone,boolean living,
                       boolean kitchenAccesories,boolean minibar,boolean desk,boolean ornaments){
        Rooms room = new Rooms();


        room.setType(type);
        room.setRoomView(view);
        room.setPhone(phone);
        room.setLiving(living);
        room.setKitchenAccesories(kitchenAccesories);
        room.setMinibar(minibar);
        room.setDesk(desk);
        room.setOrnaments(ornaments);

        EntityManager entityManager = usersEntityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(room);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static List<Rooms> searchRoom(String q) {
        int a=0;
        if(q.matches("[0-9]+")){
            if(q.isEmpty()) {
                a=0;
            } else {
                a=Integer.parseInt(q);
            }
        }
        EntityManager entityManager = usersEntityManager.createEntityManager();
        if(a!=0)
        {
            TypedQuery<Rooms> query = entityManager.createQuery("select s from Rooms s where s.roomNumber= :a ", Rooms.class);
            query.setParameter("a", a);
            List<Rooms> response = query.getResultList();
            entityManager.close();
            return response;
        }
        if (a == 0) {
            TypedQuery<Rooms> query = entityManager.createQuery("select s from Rooms s ", Rooms.class);
            //query.setParameter("a", a);
            List<Rooms> response = query.getResultList();
            entityManager.close();
            return response;
        }
        return null;
    }
    public void DeleteRoom(String q)
    {
        int a;
        if(q.matches("[0-9]+")){
            if(q.isEmpty()){
                a=0;
            }else{
                a=Integer.parseInt(q);
            }
            EntityManager entityManager = usersEntityManager.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Rooms.class,a));
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
