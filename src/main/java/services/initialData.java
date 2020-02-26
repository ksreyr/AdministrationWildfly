package services;

import model.Helado;
import model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Singleton
@Startup
public class initialData {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    void init(){
        User user = new User("paula",new ArrayList<Helado>());
        Helado helado = new Helado("casero",1500,1000);
        System.out.println("::::Persist User::::");
        em.persist(user);
        System.out.println("::::Persist User DONE::::");
        System.out.println("::::Persist Helado::::");
        em.persist(helado);
        System.out.println("::::Persist helado DONE::::");
    }
}
