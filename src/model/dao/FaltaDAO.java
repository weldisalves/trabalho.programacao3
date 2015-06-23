package model.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JPAUtil;
import model.pojo.Aluno;
import model.pojo.Falta;

public class FaltaDAO implements DAOGenerico<Falta, Integer>{

	@Override
    public void salvar(Falta objeto) {
		
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
    }

	@Override
    public void remover(Falta objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();       
          
        objeto = em.find(Falta.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

	@Override
    public List<Falta> listar() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Falta c", Falta.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }
	@Override
	public Falta buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void adicionarFaltasAAluno(int idTurma, int idAluno, int falta){
		Falta objeto;
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
		em.getTransaction().begin();

        Query query = em.createQuery("select c from Falta c where c.idAluno like :idAluno", Falta.class);
        query.setParameter("idAluno", idAluno);
         
		
		
		int id = query.getFirstResult();
		
        objeto = em.find(Falta.class, id);
        objeto.setNumeroDeFaltas(falta);
        em.getTransaction().commit();
        em.close();
		
	}

	
}
