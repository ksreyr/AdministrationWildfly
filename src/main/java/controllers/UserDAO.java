package controllers;

import model.User;

import java.util.List;

public class UserDAO extends objectDAO {

    public void createUser(User user) {
        em.persist(user);
    }

    public List<User> getUsers() {
        List<User> users = em.createQuery("SELECT U FROM User u").getResultList();
        return users;
    }

    public  List<User> getUsersByHelado(int id){
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u = "+id).getResultList();
        return users;
    }

    public User getUserByID(int id) {
        User user = em.find(User.class, id);
        return user;

    }

    public void update(User user) {
        em.merge(user);
    }
}
