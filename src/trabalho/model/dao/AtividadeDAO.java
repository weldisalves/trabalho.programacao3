package trabalho.model.dao;

import trabalho.model.pojo.Atividade;
import trabalho.util.JPAUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class AtividadeDAO implements DAOGenerico<Atividade, Integer> {

	
	@Override
    public void salvar(Atividade objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
    }

	@Override
    public void remover(Atividade objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();       
          
        objeto = em.find(Atividade.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

	@Override
    public List<Atividade> listar() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Atividade c", Atividade.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    public List<Atividade> buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Atividade c where c.nome like :nome", Atividade.class);
        query.setParameter("nome", nome);
        return query.getResultList();
        
    }

	@Override
    public Atividade buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Atividade.class, id);
    }

}
