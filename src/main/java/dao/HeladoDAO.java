package dao;

import model.Helado;

import java.util.List;

public class HeladoDAO extends objectDAO {

    public void create(Helado helado)  {
        em.persist(helado);
    }

    public void update(Helado helado) {
        em.merge(helado);
        em.flush();
    }

    public void delete(Helado helado){em.remove(helado);}

    public List<Helado> getAllHelados() {
        List<Helado> helados = em.createQuery("SELECT h FROM Helado h").getResultList();
        return helados;
    }
    public List<Helado> getAllHeladosByUser(String name) {
        List<Helado> helados = em.createNamedQuery("Helado.findHeladoByUserName",Helado.class).setParameter("name",name).getResultList();
        //em.createQuery("SELECT h FROM Helado h where h.user = "+id).getResultList();
        return helados;
    }
    public List<Helado> getAllHeladosLessByUser() {
        List<Helado> helados = em.createQuery("SELECT h FROM Helado h where h.owner = 'Bodega'").getResultList();
        //em.createQuery("SELECT h FROM Helado h where h.user = "+id).getResultList();
        return helados;
    }

    public Helado findByID(int id) {
        Helado helado = em.find(Helado.class, id);
        return helado;
    }
    public Helado findByNameAndOwner(String name,String owner){
        Helado helado = (Helado) em.createQuery("SELECT h FROM Helado h WHERE h.name='"+name+"' and h.owner = '"+owner+"'").getSingleResult();
        return helado;
    }


}
