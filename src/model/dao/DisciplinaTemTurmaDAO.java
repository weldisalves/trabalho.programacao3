package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JPAUtil;
import model.pojo.Aluno;
import model.pojo.DisciplinaTemTurma;

public class DisciplinaTemTurmaDAO implements DAOGenerico<DisciplinaTemTurma,Integer>{

	@Override
	public void salvar(DisciplinaTemTurma objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
		
	}

	@Override
	public void remover(DisciplinaTemTurma objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
        
        objeto = em.find(DisciplinaTemTurma.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<DisciplinaTemTurma> listar() {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from DisciplinaTemTurma c", DisciplinaTemTurma.class);
        return query.getResultList();
	}

	@Override
	public DisciplinaTemTurma buscarPorId(Integer id) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(DisciplinaTemTurma.class, id);
	}

}
