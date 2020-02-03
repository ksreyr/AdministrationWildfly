package controllers;

import model.Helado;

import java.util.List;

public class HeladoDAO extends objectDAO {

    public void create(Helado helado) {
        em.persist(helado);
    }

    public List<Helado> getAllHelados() {
        List<Helado> helados = em.createQuery("SELECT h FROM Helado h").getResultList();
        return helados;
    }
    public List<Helado> getAllHeladosByUser(int id) {
        List<Helado> helados = em.createQuery("SELECT h FROM Helado h where h.user = "+id).getResultList();
        return helados;
    }

    public Helado findByID(int id) {
        Helado helado = em.find(Helado.class, id);
        return helado;
    }

    public void update(Helado helado) {
        em.merge(helado);
    }
}
