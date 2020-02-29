package bean;




import lombok.Data;
import model.User;
import services.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@Named("validationBean")
@ViewScoped
@Data
public class ValidationBean implements Serializable {
    String name;
    String password;
    @Inject
    UserService userService;

    public String validate(){
        try {
            User u = userService.findUserByName(name);
            userService.userValidation(u,password);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
             return "login?faces-redirec=true";
        }
    }

}
