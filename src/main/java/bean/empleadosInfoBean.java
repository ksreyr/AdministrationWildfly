package bean;

import lombok.Data;
import model.Helado;
import model.User;
import services.UserService;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("empleadosInfoBean")
@Transactional
@ViewScoped
@Data
public class empleadosInfoBean implements Serializable {
    @Inject
    private UserService userService;

    private List<User> getAllUsers;

    User user;

    private List<Helado> heladosOFaUser;

    public String linkHome() {
        return "index?faces-redirect=true";
    }

    public String linkBack() {
        return "empleadosInfo?faces-redirect=true";
    }

    public List<User> getAllUserList(){
        getAllUsers = userService.getAllUsers();
        return getAllUsers;
    }

    public String userInfo(String userID){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userID",userID);
        return "userInfo?faces-redirect=true";
    }

    public List<Helado> getUserHelados(){
        try {
            String id=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID");
            User user = userService.findUser(Integer.parseInt(id));
            heladosOFaUser=user.getHelados();
            return heladosOFaUser;
        } catch (Exception e) {
        }
        return null;
    }

}
