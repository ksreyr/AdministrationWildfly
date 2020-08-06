package services;

import model.Helado;
import model.Punto;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Singleton
@Startup
public class initialData {

    @PersistenceContext
    EntityManager em;
    private String password = "pruebe";
    Logger logger = LoggerFactory.getLogger(initialData.class);


    @PostConstruct
    void init() {


        User user = new User("paula", DigestUtils.sha256Hex(password), new ArrayList<Helado>());
        logger.info("created " + user.getName());

        User user1 = new User("daniel", DigestUtils.sha256Hex(password), new ArrayList<Helado>());
        logger.info("created " + user1.getName());

        User user2 = new User("jeffrey", DigestUtils.sha256Hex(password), new ArrayList<Helado>());
        logger.info("created " + user2.getName());

        Helado helado = new Helado("Casero", 1500, 100, "Bodega");
        logger.info("created " + helado.getName());

        Helado helado1 = new Helado("Chococono", 2000, 200, "Bodega");
        logger.info("created " + helado1.getName());

        Helado helado2 = new Helado("Polet", 5000, 300, "Bodega");
        logger.info("created " + helado2.getName());

        Punto punto = new Punto("Psicina P");
        logger.info("created " + helado2.getName());

        em.persist(user);
        logger.info("persisted" + user.getName(), user.getName());
        em.persist(user1);
        logger.info("persisted", user1.getName());
        em.persist(user2);
        logger.info("persisted", user2.getName());
        em.persist(helado);
        logger.info("persisted", helado.getName());
        em.persist(helado1);
        logger.info("persisted", helado1.getName());
        em.persist(helado2);
        logger.info("persisted", helado2.getName());
        em.persist(punto);
        logger.info("persisted", punto.getName());
    }
}
