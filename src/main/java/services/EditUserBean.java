package services;

import controllers.UserDAO;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Named
@RequestScoped
public class EditUserBean {

    @Inject
    UserDAO userDao;

    String name;

    String userId;





    public List<User> getAllUserByHelado(String HeladoId){
        if(!HeladoId.isBlank()) {
            return userDao.getUsersByHelado(Integer.parseInt(HeladoId));
        }
        return null;
    }

    public String getUserinfo() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idUser");
    }

    public User getUser() {
        return userDao.getUserByID(Integer.parseInt(getUserinfo()));
    }

    public void updateUser() {
        User user = userDao.getUserByID(getUser().getUserID());
        user.setName(name);
        userDao.update(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
