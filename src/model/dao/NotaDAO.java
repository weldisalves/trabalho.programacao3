package model.dao;

import java.util.List;

import javax.persistence.*;

import util.JPAUtil;
import model.pojo.*;

public class NotaDAO implements DAOGenerico<Nota,Integer>{

	@Override
	public void salvar(Nota objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
		
	}

	@Override
	public void remover(Nota objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
        
        objeto = em.find(Nota.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<Nota> listar() {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Nota c", Nota.class);
        return query.getResultList();
	}

	@Override
	public Nota buscarPorId(Integer id) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Nota.class, id);
	}

}
