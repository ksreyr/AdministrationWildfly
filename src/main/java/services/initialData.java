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
        User user = new User("paula","Prueba",new ArrayList<Helado>());
        User user1 = new User("daniel","Prueba",new ArrayList<Helado>());
        User user2 = new User("jeffrey","Prueba",new ArrayList<Helado>());

        Helado helado = new Helado("casero",1500,1000,"Bodega");
        Helado helado1 = new Helado("chococono",2000,2000,"Bodega");
        Helado helado2 = new Helado("Polet",5000,3000,"Bodega");

        System.out.println("::::Persist User::::");
        em.persist(user);
        System.out.println("::::Persist User DONE::::"+user.getName());
        System.out.println("::::Persist User::::");
        em.persist(user1);
        System.out.println("::::Persist User DONE::::"+user1.getName());
        System.out.println("::::Persist User::::");
        em.persist(user2);
        System.out.println("::::Persist User DONE::::"+user2.getName());
        System.out.println("::::Persist Helado::::");
        em.persist(helado);
        System.out.println("::::Persist helado DONE::::"+helado.getName());
        System.out.println("::::Persist Helado::::");
        em.persist(helado1);
        System.out.println("::::Persist helado DONE::::"+helado1.getName());
        System.out.println("::::Persist Helado::::");
        em.persist(helado2);
        System.out.println("::::Persist helado DONE::::"+helado2.getName());
    }
}
