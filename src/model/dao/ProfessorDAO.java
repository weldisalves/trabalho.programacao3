package model.dao;

import model.pojo.Aluno;
import model.pojo.Professor;
import util.JPAUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class ProfessorDAO implements DAOGenerico<Professor, Integer> {

	
	@Override
    public void salvar(Professor objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
    }

	@Override
    public void remover(Professor objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
        
        objeto = em.find(Professor.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

	@Override
    public List<Professor> listar() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Professor c", Professor.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    public List<Professor> buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Professor c where c.nome like :nome", Professor.class);
        query.setParameter("nome", nome);
        return query.getResultList();
        
    }

    public Professor buscarPorCpf(String cpf) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Professor c where c.cpf like :cpf", Professor.class);
        query.setParameter("cpf", cpf);
        return (Professor) query.getSingleResult();
    }

	@Override
    public Professor buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Professor.class, id);
    }

}
