package trabalho.model.dao;

import trabalho.model.pojo.Disciplina;
import trabalho.util.JPAUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class DisciplinaDAO implements DAOGenerico<Disciplina, Integer> {

	
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

    public List<Disciplina> buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Disciplina c where c.nome like :nome", Disciplina.class);
        query.setParameter("nome", nome);
        return query.getResultList();
        
    }

	@Override
    public Disciplina buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Disciplina.class, id);
    }

}
