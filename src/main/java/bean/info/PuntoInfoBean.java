package bean.info;

import lombok.Data;
import model.Punto;
import services.PuntoService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@Data
@RequestScoped
public class PuntoInfoBean {
    @Inject
    PuntoService puntoService;

    List<Punto> puntoList = new ArrayList<>();

    public List<Punto> allPuntos() {
        puntoList = puntoService.getallPuntosList();
        return puntoList;
    }
    public String linkHome() {

        return "index?faces-redirect=true";
    }
    public String puntoFill(String puntoID){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ID",puntoID);
        return "surtir?faces-redirect=true";
    }
}
