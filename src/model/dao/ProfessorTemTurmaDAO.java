package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JPAUtil;
import model.pojo.Aluno;
import model.pojo.ProfessorTemTurma;

public class ProfessorTemTurmaDAO implements DAOGenerico<ProfessorTemTurma,Integer>{

	@Override
	public void salvar(ProfessorTemTurma objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
		
	}

	@Override
	public void remover(ProfessorTemTurma objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
        
        objeto = em.find(ProfessorTemTurma.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<ProfessorTemTurma> listar() {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from ProfessorTemTurma c", ProfessorTemTurma.class);
        return query.getResultList();
	}

	@Override
	public ProfessorTemTurma buscarPorId(Integer id) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(ProfessorTemTurma.class, id);
	}

}
