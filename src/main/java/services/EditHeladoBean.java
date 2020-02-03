package services;

import controllers.HeladoDAO;
import controllers.UserDAO;
import model.Helado;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EditHeladoBean {

    @Inject
    HeladoDAO heladoDAO;
    @Inject
    UserDAO userDAO;

    String userID;

    String name;
    String price;



    public User getUser() {
        if (!userID.isBlank()) {
            return userDAO.getUserByID(Integer.parseInt(userID));
        } else {
            return null;
        }
    }

    public List<Helado> listAllHeladoByUser() {
        List<Helado> helados = heladoDAO.getAllHeladosByUser(Integer.parseInt("1"));
        return helados;
    }


    public Helado getHelado() {
        return heladoDAO.findByID(Integer.parseInt(heladoID()));
    }

    public String heladoID() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idHelado");
    }


    public void updateHelado() {
        Helado helado = getHelado();
        helado.setName(name);
        helado.setPrice(Integer.parseInt(price));
        if(getUser()!= null) {
            helado.setUser(getUser());
        }
        heladoDAO.update(helado);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


}
