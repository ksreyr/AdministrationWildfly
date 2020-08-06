package services;

import dao.PuntoDAO;
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
    public Punto getPunto(String name){
        punto=puntoDAO.findByName(name);
        return punto;
    }
}
