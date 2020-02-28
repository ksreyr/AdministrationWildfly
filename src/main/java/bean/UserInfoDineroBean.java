package bean;


import lombok.Data;
import model.Helado;
import model.User;
import services.HeladoService;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("userInfoDineroBean")
@Transactional
@ViewScoped
@Data
public class UserInfoDineroBean implements Serializable {

    @Inject
    UserService userService;
    @Inject
    HeladoService heladoService;

    String id;

    private List<Helado> helados;
    private  User user;

    @PostConstruct
    void init(){
         id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ID");
         user = userService.findUser(Integer.parseInt(id));
    }

    public String linkHome() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        return "index?faces-redirect=true";
    }

    public String linkBack() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        return "empleadosInfo?faces-redirect=true";
    }

    public List<Helado> getHeladosOfUser(){
        helados = userService.findUser(Integer.parseInt(id)).getHelados();
        return helados;
    }
    public int HeladoPriceSum(int id){
        Helado h = heladoService.getHeladoByID(id);
        return h.getNumber()*h.getPrice();
    }
}
