package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
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

    public String linkinfoPuntos() {
        return "puntoInfo?faces-redirect=true";
    }

    public String linkinfoEmpleados() {
        return "empleadosInfo?faces-redirect=true";
    }

    public String linkinfoBodegas() {
        return "bodegaInfo?faces-redirect=true";
    }

}

