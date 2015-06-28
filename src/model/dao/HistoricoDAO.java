
package model.dao;

import java.util.List;

import javax.persistence.*;

import util.JPAUtil;
import model.pojo.Historico;

public class HistoricoDAO implements DAOGenerico<Historico, Integer>{

	@Override
    public void salvar(Historico objeto) {
		
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
    }

	@Override
    public void remover(Historico objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();       
          
        objeto = em.find(Historico.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

	@Override
    public List<Historico> listar() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Historico c", Historico.class);
        List lista = query.getResultList();
        em.close();
        return lista;
	}

	@Override
    public Historico buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Historico.class, id);
    }
	
	public Historico consultarSituacaoDoAlunoEmDisciplina(int idAluno,
			int idDisciplina) {
	
		EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Historico c where c.idAluno="+idAluno+"and idDisciplina= "+idDisciplina, Historico.class);
        query.setParameter("idAluno", idAluno);
        query.setParameter("idDisciplina", idDisciplina);
        return (Historico) query.getSingleResult();
		
	}

}
