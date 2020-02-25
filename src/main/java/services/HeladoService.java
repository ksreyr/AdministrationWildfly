package services;

import dao.HeladoDAO;
import lombok.Data;
import model.Helado;
import model.User;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Data
public class HeladoService implements Serializable {

    @Inject
    HeladoDAO heladoDAO;

    List<Helado> helados;

    public void createHelado(Helado helado) {
        heladoDAO.create(helado);
    }

    public void deleteHelado(Helado helado) {
        heladoDAO.delete(helado);
    }

    public List<Helado> getAllHelados() {
        helados = heladoDAO.getAllHelados();
        return helados;
    }
    public List<Helado> getHeladosLessUsers() {
        helados = heladoDAO.getAllHeladosLessByUser();
        return helados;
    }
    public Helado getHeladoByID(int heladoID){
        Helado helado=heladoDAO.findByID(heladoID);
        return helado;
    }

    public void editHelado(Helado helado){
        heladoDAO.update(helado);
    }
}
