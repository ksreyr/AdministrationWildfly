package bean;


import lombok.Data;
import model.Helado;
import model.User;
import services.HeladoService;
import services.UserService;

import javax.faces.context.FacesContext;
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

    int cantidad;

    List<Helado> heladoList;

    public String linkSurtir(String id) {
        user = userService.findUser(Integer.parseInt(id));
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User",user);
        return "surtir?faces-redirect=true";
    }

    public List<Helado> getDisponibleHelados() {
        heladoList = heladoService.getHeladosLessUsers();
        return heladoList;
    }

    public String sutir(String heladoID) {
        try {
            user=(User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        } catch (Exception e) {
            System.out.printf("I do not have User");
        }
        //Helados de la Fabrica
        Helado heladoEnBodega = heladoService.getHeladoByID(Integer.parseInt(heladoID));
        int number = heladoEnBodega.getNumber();
        number=number-cantidad;
        heladoEnBodega.setNumber(number);
        heladoService.editHelado(heladoEnBodega);
        Helado userHelado = new Helado(heladoEnBodega.getName(),heladoEnBodega.getPrice(),cantidad,user);
        userHelado.setNumber(cantidad);

        //Helados de Usuario
        List<Helado> userHeladoList = user.helados;
        userHeladoList.add(userHelado);
        user.setHelados(userHeladoList);
        userService.update(user);

        //Actualizar
        heladoList = heladoService.getAllHelados();
        return "surtirEmpleado?faces-redirect=true";
    }


}
