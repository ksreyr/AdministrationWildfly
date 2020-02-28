package services;

import dao.HeladoDAO;
import dao.UserDAO;
import lombok.Data;
import model.Helado;
import model.User;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Data
public class UserService implements Serializable {

    private List<User> users;

    @Inject
    HeladoDAO heladoDAO;

    @Inject
    UserDAO userDAO;


    public void saveUser(User user){
       userDAO.createUser(user);
    }

    public void deletUSer(User user){
        userDAO.delete(user);
    }

    public void update(User user){
        userDAO.update(user);
    }

    public List<User> getAllUsers(){
        users=userDAO.getAllUsers();
        return users;
    }

    public User findUser(int id){
        User user =userDAO.getUserByID(id);
        return user;
    }

    public boolean hatHelado(List<Helado> helados, Helado helado){
        for (Helado h :
                helados) {
            if(h.getName().equals(helado.getName())){
                return true;
            }
        }
        return false;
    }


}
