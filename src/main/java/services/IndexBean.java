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
public class IndexBean {


    @Inject
    HeladoDAO heladoDAO;
    @Inject
    UserDAO userDAO;


    public List<Helado> listAllHelados() {
        List<Helado> helados = heladoDAO.getAllHelados();
        return helados;
    }

    public List<User> listAllUsers() {
        List<User> users = userDAO.getUsers();
        return users;
    }

    public String createHeladoXHTML() {
        return "createHelado?faces-redirect=true";
    }

    public String createUserXHTML() {
        return "createUser?faces-redirect=true";
    }

    public String indexXHTML() {
        return "index?faces-redirect=true";
    }


    public String editHeladoXHTML(String id) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idHelado", id);
        return "editHelado?faces-redirect=true";
    }

    public String editUserXHTML(String id) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idUser", id);
        return "editUser?faces-redirect=true";
    }


}

