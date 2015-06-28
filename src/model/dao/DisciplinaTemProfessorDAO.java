package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JPAUtil;
import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.DisciplinaTemProfessor;

public class DisciplinaTemProfessorDAO implements DAOGenerico<DisciplinaTemProfessor,Integer>{

	@Override
	public void salvar(DisciplinaTemProfessor objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
		
	}

	@Override
	public void remover(DisciplinaTemProfessor objeto) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
        
        objeto = em.find(DisciplinaTemProfessor.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
		
	}

	@Override
	public List<DisciplinaTemProfessor> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisciplinaTemProfessor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int consultarNumeroDeDisciplinaslecionadasPorUmProfessor(int idProfessor) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from DisciplinaTemProfessor c where c.idProfessor like :idProfessor", DisciplinaTemProfessor.class);
        query.setParameter("idProfessor", idProfessor);
        List<DisciplinaTemProfessor> lista = query.getResultList();
        
        return lista.size();
   
	}

	

}
