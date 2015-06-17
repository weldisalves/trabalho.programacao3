package model.dao;

import model.pojo.Turma;
import util.JPAUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class TurmaDAO implements DAOGenerico<Turma, Integer> {

	
	@Override
    public void salvar(Turma objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
    }

	@Override
    public void remover(Turma objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();       
          
        objeto = em.find(Turma.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

	@Override
    public List<Turma> listar() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Turma c", Turma.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    public List<Turma> buscarPorAno(String ano) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Turma c where c.ano like :ano", Turma.class);
        query.setParameter("ano", ano);
        return query.getResultList();
        
    }

	@Override
    public Turma buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Turma.class, id);
    }

}