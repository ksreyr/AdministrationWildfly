package bean;


import lombok.Data;
import model.Helado;
import model.User;
import services.HeladoService;
import services.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("surtirEmpleadoBean")
@Transactional
@ViewScoped
@Data
public class SurtirEmpleadoBean implements Serializable {
    User user;
    @Inject
    HeladoService heladoService;

    @Inject
    UserService userService;

    List<Helado> heladoList;

    public void linkSurtir(String id){
        user = userService.findUser(Integer.parseInt(id));
       // return "surtirAction?faces-redirect=true";
    }

    public List<Helado> heladosDisponibles(){
    return null;
    }


}
