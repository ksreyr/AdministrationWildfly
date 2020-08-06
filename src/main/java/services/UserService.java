package services;

import dao.HeladoDAO;
import dao.UserDAO;
import lombok.Data;
import model.Helado;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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
    public User findUserByName(String name){
        User u = userDAO.getUsetByName(name);
        return u;
    }
    public boolean userValidation(String name, String s){
        Optional<User> userfound = Optional.ofNullable(userDAO.getUsetByName(name));
        if(userfound.isPresent() && userfound.get().getPassword().equals(DigestUtils.sha256Hex(s))){
            return true;
        }else {
            return false;
        }

    }

}
