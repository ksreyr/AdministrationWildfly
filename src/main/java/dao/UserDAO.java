package dao;

import model.User;

import java.util.List;

public class UserDAO extends objectDAO {

    public void createUser(User user) {
        em.persist(user);
    }

    public void update(User user) {

        em.merge(user);
    }

    public void delete(User user){
        em.remove(user);
    }

    public List<User> getAllUsers() {
        List<User> users = em.createQuery("SELECT U FROM User u").getResultList();
        return users;
    }

    public  List<User> getAllUsersByHelado(int id){
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u = "+id).getResultList();
        return users;
    }

    public User getUserByID(int id) {
        User user = em.find(User.class, id);
        return user;

    }

}
