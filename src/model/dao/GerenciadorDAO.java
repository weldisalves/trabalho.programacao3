package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.pojo.Disciplina;
import model.pojo.DisciplinaTemProfessor;
import model.pojo.Professor;
import util.JPAUtil;


public class GerenciadorDAO {
	
	Professor newProfessor;
	ProfessorDAO professorDAO = new ProfessorDAO();
	
	Disciplina newDisciplina;
	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	
	DisciplinaTemProfessor objeto;
	
	public void adicionarProfessorADisciplina(int idProfessor,int idDisciplina){

    	newProfessor = professorDAO.buscarPorId(idProfessor);
        newDisciplina = disciplinaDAO.buscarPorId(idDisciplina);
        
        if(newProfessor != null || newDisciplina != null){
        	objeto = new DisciplinaTemProfessor(idDisciplina,idProfessor);
        	
        	EntityManager em = JPAUtil.getInstance().getEntityManager();
            EntityTransaction tx = JPAUtil.getInstance().getTransaction(em);
            em.persist(objeto);
            tx.commit();
            em.close();
        }

	}
}



