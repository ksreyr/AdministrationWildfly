package bean;


import lombok.Data;
import model.Helado;
import model.User;
import services.HeladoService;
import services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("surtirEmpleadoBean")
@RequestScoped
@Data
public class SurtirEmpleadoBean implements Serializable {
    User user;
    @Inject
    HeladoService heladoService;

    @Inject
    UserService userService;

    String cantidad;

    List<Helado> heladoList;

    public String linkHome() {
        return "index?faces-redirect=true";
    }

    public String linkBack() {
        return "surtirEmpleado?faces-redirect=true";
    }

    public String linkSurtir(String id) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ID", id);
        return "surtir?faces-redirect=true";
    }

    public List<Helado> getDisponibleHelados() {
        heladoList = heladoService.getHeladosLessUsers();
        return heladoList;
    }
    public void resetVariables(){
        heladoList = heladoService.getHeladosLessUsers();
        cantidad=null;
    }
    public String sutir(String heladoID) {
        try {
            String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ID");
            //USER TO UPDATE

            User hUser= userService.findUser(Integer.parseInt(id));
            //HELADO TO UPDATE
            Helado heladoEnBodega = heladoService.getHeladoByID(Integer.parseInt(heladoID));
            //CANTIDAD
            int number = heladoEnBodega.getNumber();

            if (Integer.parseInt(cantidad )< number) {
                //Numero en Bodega
                number = number - Integer.parseInt(cantidad);
                //Descuento el valor del Helado ne bodega
                heladoEnBodega.setNumber(number);
                //Guardo el Helado en Bodega con el nuevo valor
                heladoService.editHelado(heladoEnBodega);

                //Helados de Usuario
                List<Helado> userHeladoList = hUser.getHelados();
                //Veo si Usuario tiene el Helado
                Boolean hat_Helado = userService.hatHelado(userHeladoList,heladoEnBodega);

                Helado userHelado = new Helado(heladoEnBodega.getName(),
                        heladoEnBodega.getPrice(),
                        Integer.parseInt(cantidad),hUser.getName());

                if(hat_Helado){
                    heladoService.updateHelado(userHeladoList,userHelado);
                }else {
                    userHeladoList.add(userHelado);
                    hUser.setHelados(userHeladoList);
                    userService.update(hUser);
                }
                resetVariables();
                return "Success";
            } else {
                return "No enougt Helados";
            }
        } catch (Exception e) {
            System.out.println("Something happen");
            e.printStackTrace();
            return "Not User";
        }
        //Helados de la Fabrica


    }


}
