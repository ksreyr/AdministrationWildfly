package bean;


import lombok.Data;
import model.Helado;
import services.HeladoService;
import services.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;



@Named("bodegaInfoBean")
@ViewScoped
@Data
public class BodegaInfoBean implements Serializable {

    @Inject
    HeladoService heladoService;

    List<Helado> helados;

    @Inject
    UserService userService;

    String total;


    public String linkHome() {
        return "index?faces-redirect=true";
    }

    public List<Helado> getAllHeladosBodega(){
        helados=heladoService.getHeladosLessUsers();
        return helados;
    }
    public String totalGelb(){
        List<Helado> helados= heladoService.getHeladosLessUsers();
        total=heladoService.precioTotal(helados);
        return total;
    }

}
