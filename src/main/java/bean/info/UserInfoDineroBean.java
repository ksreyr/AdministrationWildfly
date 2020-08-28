package bean.info;


import lombok.Data;
import model.Helado;
import model.User;
import services.HeladoService;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("userInfoDineroBean")
@ViewScoped
@Data
public class UserInfoDineroBean implements Serializable {

    @Inject
    UserService userService;

    @Inject
    HeladoService heladoService;

    private String id;

    private List<Helado> helados;

    private  User user;

    private String total;

    @PostConstruct
    void init(){
        id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID");
        user = userService.findUser(Integer.parseInt(id));
    }


    public String linkHome() {
        return "index?faces-redirect=true";
    }

    public String linkBack() {
        return "empleadosInfo?faces-redirect=true";
    }

    public List<Helado> getHeladosOfUser(){
        helados = userService.findUser(Integer.parseInt(id)).getHelados();
        return helados;
    }
    public int heladoPriceSum(int id){
        Helado h = heladoService.getHeladoByID(id);
        return h.getNumber()*h.getPrice();
    }
    public String totalMoney(){
        List<Helado> helados= userService.findUser(Integer.parseInt(id)).getHelados();
        total=heladoService.precioTotal(helados);
        return total;
    }
}
