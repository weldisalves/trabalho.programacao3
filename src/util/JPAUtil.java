package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {

    private static JPAUtil instance;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoProgramacao3");

    private JPAUtil() {

    }

    public static JPAUtil getInstance() {
        if (instance == null) {
            instance = new JPAUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public EntityTransaction getTransaction(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return tx;
    }

}