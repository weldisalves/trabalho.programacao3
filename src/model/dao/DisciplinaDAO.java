package model.dao;


import model.pojo.*;
import util.JPAUtil;

import java.util.List;

import javax.persistence.*;


public class DisciplinaDAO implements DAOGenerico<Disciplina, Integer> {
	
	Turma turma;
	TurmaDAO turmaDAO = new TurmaDAO();
	
	@Override
    public void salvar(Disciplina objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
    }

	@Override
    public void remover(Disciplina objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();       
          
        objeto = em.find(Disciplina.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

	@Override
    public List<Disciplina> listar() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Disciplina c", Disciplina.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    public Disciplina buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Disciplina c where c.nome like :nome", Disciplina.class);
        query.setParameter("nome", nome);
        return (Disciplina) query.getSingleResult();
    }

	@Override
    public Disciplina buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Disciplina.class, id);
    }

	public void alterarNumeroDeTurmasOfertadas(int idDisciplina, int i) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
		em.getTransaction().begin();
        Disciplina objeto = em.find(Disciplina.class, idDisciplina);
        objeto.setAdicionarDisciplinaOfertada(i);
        em.getTransaction().commit();
        em.close();
		
	}

	public int consultarNumeroDeTurmasOfertadasPorUmaDisciplina(int idDisciplina) {
		return buscarPorId(idDisciplina).getNumeroDeTurmasOfertadas();
	}

	

	
}