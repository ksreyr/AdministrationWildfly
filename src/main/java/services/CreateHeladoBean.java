package services;

import controllers.HeladoDAO;
import controllers.UserDAO;
import model.Helado;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CreateHeladoBean {
    @Inject
    HeladoDAO heladoDAO;
    @Inject
    UserDAO userDAO;


    String heladoId;
    String heladoName;
    String heladoPrice;



    public void createHelado() {
        Helado helado = new Helado();
        helado.setName(heladoName);
        helado.setPrice(Integer.parseInt(heladoPrice));
        heladoDAO.create(helado);
    }

    public String getHeladoId() {
        return heladoId;
    }

    public void setHeladoId(String heladoId) {
        this.heladoId = heladoId;
    }

    public String getHeladoName() {
        return heladoName;
    }

    public void setHeladoName(String heladoName) {
        this.heladoName = heladoName;
    }

    public String getHeladoPrice() {
        return heladoPrice;
    }

    public void setHeladoPrice(String heladoPrice) {
        this.heladoPrice = heladoPrice;
    }
}
