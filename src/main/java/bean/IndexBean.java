package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named("indexBean")
@RequestScoped
public class IndexBean implements Serializable {

    public String linkCrearUsuario() {
        return "createUser?faces-redirect=true";
    }

    public String linkCrearHelado() {
        return "createHelado?faces-redirect=true";
    }

    public String linkSurtirEmpleado() {
        return "surtirEmpleado?faces-redirect=true";
    }

    public String linkinofPuntos() {
        return "surtirPunto?faces-redirect=true";
    }

    public String linkinofEmpleados() {
        return "empleadosInfo?faces-redirect=true";
    }

    public String linkinofBodegas() {
        return "bodegaInfo?faces-redirect=true";
    }

}

