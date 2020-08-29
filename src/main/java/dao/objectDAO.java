package dao;


import exceptions.entityNotFoundException;
import org.h2.api.ErrorCode;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.OptionalInt;

@Transactional
public abstract class objectDAO<T> {
    @PersistenceContext(unitName = "pu")
    protected EntityManager em;

    public void create(@NotNull T t) {
        em.merge(t);
    }
    public void update(@NotNull T t) throws entityNotFoundException {
        if(em.contains(t)){
            em.merge(t);
        }else{
            throw new entityNotFoundException("There is not a Entity to merge");
        }
    }
}
