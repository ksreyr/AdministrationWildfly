package services;

import dao.PuntoDAO;
import model.Helado;
import model.Punto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PuntoService {
    @Inject
    PuntoDAO puntoDAO;

    List<Punto> puntoList;

    Punto punto;

    public List<Punto> getallPuntosList(){
        puntoList=puntoDAO.findAll();
        return puntoList;
    }
    public Punto findPuntoByName(String name){
        punto=puntoDAO.findByName(name);
        return punto;
    }
    public Punto findPuntoByID(int id){
        punto=puntoDAO.findByID(id);
        return punto;
    }

    public boolean hatHelado(List<Helado> helados, Helado helado){
        for (Helado h :
                helados) {
            if(h.getName().equals(helado.getName())){
                return true;
            }
        }
        return false;
    }

    public void update(Punto punto){
        puntoDAO.update(punto);
    }

}
