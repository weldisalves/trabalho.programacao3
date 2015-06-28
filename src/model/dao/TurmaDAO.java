package model.dao;

import model.pojo.*;
import util.JPAUtil;

import java.util.List;

import javax.persistence.*;


public class TurmaDAO implements DAOGenerico<Turma, Integer> {
	

	
	Turma turma;

	
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
	
	

	public void alterarDisciplina(int idTurma, int idDisciplina) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
		em.getTransaction().begin();
        Turma objeto = em.find(Turma.class, idTurma);
        objeto.setIdDisciplina(idDisciplina);
        em.getTransaction().commit();
        em.close();
		
	}

	
	public List<Turma> buscarPorDisciplina(int idDisciplina){
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Turma c where c.idDisciplina like :idDisciplina", Disciplina.class);
        query.setParameter("idDisciplina", idDisciplina);
        return query.getResultList();
	}

	public Turma buscarPorAnoPeriodoIdTurma(String ano, int periodo, int idDisciplina) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		Query query = em.createQuery("select c from Turma where ano ="+ ano +" and periodo = "+ periodo +
				"and idDisciplina= "+ idDisciplina, Disciplina.class);
		query.setParameter("ano", ano);
		query.setParameter("periodo", periodo);
		query.setParameter("idDisicplina",idDisciplina);
		return (Turma) query.getSingleResult();
	}

	public List<Historico> consultarTurma(String ano, int periodo, String nomeDisciplina) {
		Disciplina disciplina;
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		disciplina = disciplinaDAO.buscarPorNome(nomeDisciplina);
		turma = buscarPorAnoPeriodoIdTurma(ano,periodo,disciplina.getId()); 
		
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		Query query = em.createQuery("select c from Historico where ano ="+ turma.getId(), Disciplina.class);
		query.setParameter("idTurma",turma.getId());
		return query.getResultList();		
		
	}
	
	
	
}