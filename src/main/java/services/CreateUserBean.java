package services;

import controllers.UserDAO;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CreateUserBean {
    @Inject
    UserDAO userDao;

    String userName;



    public void createUser() {
        User user = new User();
        user.setName(userName);
        userDao.createUser(user);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
