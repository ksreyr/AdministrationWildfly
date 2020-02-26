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

    public String linkHome() {
        return "index?faces-redirect=true";
    }

    public String linkBack() {
        return "surtirEmpleado?faces-redirect=true";
    }

    public String linkSurtir(String id) {
        //user = userService.findUser(Integer.parseInt(id));
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ID", id);
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User",user);
        return "surtir?faces-redirect=true";
    }

    public List<Helado> getDisponibleHelados() {
        heladoList = heladoService.getHeladosLessUsers();
        return heladoList;
    }

    public String sutir(String heladoID) {
        try {
            String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ID");
            User hUser= userService.findUser(Integer.parseInt(id));
            Helado heladoEnBodega = heladoService.getHeladoByID(Integer.parseInt(heladoID));
            int number = heladoEnBodega.getNumber();
            if (cantidad < number) {
                number = number - cantidad;
                heladoEnBodega.setNumber(number);
                heladoService.editHelado(heladoEnBodega);
                Helado userHelado = new Helado(heladoEnBodega.getName(), heladoEnBodega.getPrice(), cantidad, user);
                userHelado.setNumber(cantidad);

                //Helados de Usuario
                List<Helado> userHeladoList = hUser.helados;
                userHeladoList.add(userHelado);
                hUser.setHelados(userHeladoList);
                user=hUser;
                userService.update(hUser);

                //Actualizar
                heladoList = heladoService.getAllHelados();
                return "surtir?faces-redirect=true";
            } else {
                return "No enougt Helados";
            }
        } catch (Exception e) {
            System.out.printf("I do not have User");
            return "Not User";
        }
        //Helados de la Fabrica


    }


}
