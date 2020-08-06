package dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public abstract class objectDAO {
    @PersistenceContext(unitName = "pu")
    protected EntityManager em;



}
