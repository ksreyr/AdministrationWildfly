package dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Transactional
public abstract class objectDAO<T> {
    @PersistenceContext(unitName = "pu")
    protected EntityManager em;

    public void create(@NotNull T t){
        em.persist(t);
    }

}
