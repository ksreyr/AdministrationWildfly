package bean;

import lombok.Data;
import model.Punto;
import services.PuntoService;

import javax.enterprise.context.RequestScoped;
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
}
