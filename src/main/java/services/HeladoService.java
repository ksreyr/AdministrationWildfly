package services;

import dao.HeladoDAO;
import lombok.Data;
import model.Helado;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
@Data
public class HeladoService implements Serializable {

    @Inject
    HeladoDAO heladoDAO;

    Helado helado;
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

    public Helado getHeladoByID(int heladoID) {
        if(heladoDAO.findByID(heladoID).isPresent()){
            helado = heladoDAO.findByID(heladoID).get();
            return helado;
        }else{
            return null;
        }

    }

    public void editHelado(Helado helado) {
        heladoDAO.update(helado);

    }

    public Helado getHeladoByName(String name, String owner) {
        helado = heladoDAO.findByNameAndOwner(name, owner);
        return helado;
    }

    public void updateHelado(List<Helado> helados, Helado helado) {
        for (Helado h :
                helados) {
            if (h.getName().equals(helado.getName())) {
                h.setNumber(helado.getNumber()+h.getNumber());
                heladoDAO.update(h);
            }
        }
    }
    public String precioTotal(List<Helado> helados){
       int priceTotal=0;
        for (Helado h:
             helados) {
            priceTotal=priceTotal+(h.getPrice()*h.getNumber());
        }
        return Integer.toString(priceTotal);
    }
}

