package model.dao;

import java.util.List;

import javax.persistence.*;

import model.pojo.Aluno;
import util.JPAUtil;



public class AlunoDAO implements DAOGenerico<Aluno, Integer> {
	
	@Override
    public void salvar(Aluno objeto) {
		
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
        em.persist(objeto);
        tx.commit();
        em.close();
    }

	@Override
    public void remover(Aluno objeto) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();       
          
        objeto = em.find(Aluno.class, objeto.getId());

        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        em.close();
    }

	@Override
    public List<Aluno> listar() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Aluno c", Aluno.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    public List<Aluno> buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Aluno c where c.nome like :nome", Aluno.class);
        query.setParameter("nome", nome);
        return query.getResultList();
        
    }

    public List<Aluno> buscarPorCpf(String cpf) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createQuery("select c from Aluno c where c.cpf like :cpf",
                Aluno.class);
        query.setParameter("cpf", cpf);
        return query.getResultList();
    }

	@Override
    public Aluno buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        return em.find(Aluno.class, id);
    }
	
	public void alterarNome(int id,String nome){
				
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
		em.getTransaction().begin();
        Aluno objeto = em.find(Aluno.class, id);
        objeto.setNome(nome);
        em.getTransaction().commit();
        em.close();  
  
	}
	
	public void alterarCpf(int id,String cpf){
		
		EntityManager em = JPAUtil.getInstance().getEntityManager();       
		em.getTransaction().begin();
        Aluno objeto = em.find(Aluno.class, id);
        objeto.setNome(cpf);
        em.getTransaction().commit();
        em.close();  
  
	}
	
	

}