package bean;

import lombok.Data;
import model.Helado;
import services.HeladoService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("createHeladoBean")
@Transactional
@ViewScoped
@Data
public class CreateHeladoBean implements Serializable {

    private String name;

    private String price;

    private String number;

    List<Helado> helados;

    @Inject
    HeladoService heladoService;

    public List<Helado> allHelados(){
        helados=heladoService.getAllHelados();
        return helados;
    }

    public void createHelado(){
        Helado h = new Helado(name,Integer.parseInt(price),Integer.parseInt(number));
        heladoService.createHelado(h);
        allHelados();
    }


    public String linkHome(){
        return "index?faces-redirect=true";
    }
}
