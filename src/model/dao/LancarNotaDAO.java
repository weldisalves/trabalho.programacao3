package model.dao;

import java.util.List;

import javax.persistence.*;

import util.JPAUtil;
import model.pojo.*;

public class LancarNotaDAO implements DAOGenerico<LancarNota,Integer>{

	@Override
	public void salvar(LancarNota objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
		
		
	}

	@Override
	public void remover(LancarNota objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
        
        objeto = em.find(LancarNota.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<LancarNota> listar() {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from LancarNotas c", LancarNota.class);
        return query.getResultList();
	}

	@Override
	public LancarNota buscarPorId(Integer id) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(LancarNota.class, id);
	}

}
