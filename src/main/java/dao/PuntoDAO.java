package dao;

import model.Punto;

import java.util.List;
import java.util.Optional;

public class PuntoDAO extends objectDAO {
    public void createUser(Punto punto) {
        if (!punto.equals(null)) {
            em.persist(punto);
        }
    }

    public void update(Punto punto) {
        if (!punto.equals(null)) {
            em.merge(punto);
        }
    }

    public Punto findByID(int puntoID) {
        Optional<Punto> punto = Optional.ofNullable(em.find(Punto.class, puntoID));
        if (punto.isPresent()) {
            return punto.get();
        } else {
            return null;
        }
    }

    public List<Punto> findAll() {
        Optional<List> puntos= Optional.ofNullable(em.createQuery("SELECT p FROM Punto p").getResultList());
        if (puntos.isPresent()) {
            return puntos.get();
        } else {
            return null;
        }
    }
    public Punto findByName(String name) {
        Punto punto= (Punto) em.createQuery("SELECT p FROM Punto p WHERE p.name='"+name+"'").getSingleResult();
        Optional<Punto> puntoOptional=Optional.ofNullable(punto);
        if (puntoOptional.isPresent()) {
            return puntoOptional.get();
        } else {
            return null;
        }
    }

}
