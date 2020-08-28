package bean;


import lombok.Data;
import model.Helado;
import model.Owner;
import model.Punto;
import model.User;
import services.HeladoService;
import services.PuntoService;
import services.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Named("surtirBean")
@RequestScoped
@Data
public class SurtirBean implements Serializable {
    User user;
    @Inject
    HeladoService heladoService;

    @Inject
    UserService userService;
    @Inject
    PuntoService puntoService;

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
            if (Objects.nonNull(userService.findUser(Integer.parseInt(id)))) {
                User hUser = userService.findUser(Integer.parseInt(id));
                //HELADO TO UPDATE

                Helado heladoEnBodega = heladoService.getHeladoByID(Integer.parseInt(heladoID));


                //CANTIDAD
                int number = heladoEnBodega.getNumber();

                if (Integer.parseInt(cantidad) < number) {
                    //Numero en Bodega
                    number = number - Integer.parseInt(cantidad);
                    //Descuento el valor del Helado ne bodega
                    heladoEnBodega.setNumber(number);
                    //Guardo el Helado en Bodega con el nuevo valor
                    heladoService.editHelado(heladoEnBodega);

                    //Helados de Usuario
                    List<Helado> userHeladoList = hUser.getHelados();
                    //Veo si Usuario tiene el Helado
                    Boolean hat_Helado = userService.hatHelado(userHeladoList, heladoEnBodega);

                    Helado userHelado = new Helado(heladoEnBodega.getName(),
                            heladoEnBodega.getPrice(),
                            Integer.parseInt(cantidad), hUser.getName());

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
            }else if(Objects.nonNull(puntoService.findPuntoByID(Integer.parseInt(id)))){
                Punto hPunto  = puntoService.findPuntoByID(Integer.parseInt(id));
                //HELADO TO UPDATE

                Helado heladoEnBodega = heladoService.getHeladoByID(Integer.parseInt(heladoID));


                //CANTIDAD
                int number = heladoEnBodega.getNumber();

                if (Integer.parseInt(cantidad) < number) {
                    //Numero en Bodega
                    number = number - Integer.parseInt(cantidad);
                    //Descuento el valor del Helado ne bodega
                    heladoEnBodega.setNumber(number);
                    //Guardo el Helado en Bodega con el nuevo valor
                    heladoService.editHelado(heladoEnBodega);

                    //Helados de Usuario
                    List<Helado> userHeladoList = hPunto.getHelados();
                    //Veo si Usuario tiene el Helado
                    Boolean hat_Helado = puntoService.hatHelado(userHeladoList, heladoEnBodega);

                    Helado userHelado = new Helado(heladoEnBodega.getName(),
                            heladoEnBodega.getPrice(),
                            Integer.parseInt(cantidad), hPunto.getName());

                    if(hat_Helado){
                        heladoService.updateHelado(userHeladoList,userHelado);
                    }else {
                        userHeladoList.add(userHelado);
                        hPunto.setHelados(userHeladoList);
                        puntoService.update(hPunto);
                    }
                    resetVariables();
                    return "Success";
                } else {
                    resetVariables();
                    return "No enougt Helados";

                }
            }else{
                throw new Exception("There is no Owner with that ID");
            }


        } catch (Exception e) {
            System.out.println("Something happen");
            e.printStackTrace();
            return "Not User";
        }
        //Helados de la Fabrica


    }


}
