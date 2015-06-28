package model.dao;

import javax.persistence.*;

import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.DisciplinaTemProfessor;
import model.pojo.Historico;
import model.pojo.Professor;
import model.pojo.Turma;
import util.JPAUtil;


public class GerenciadorDAO {
	
	Professor professor;
	ProfessorDAO professorDAO = new ProfessorDAO();
	
	Disciplina disciplina;
	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	
	Aluno aluno;
	AlunoDAO alunoDAO = new AlunoDAO();
	
	Turma turma;
	TurmaDAO turmaDAO = new TurmaDAO();
	
	DisciplinaTemProfessor disciplinaTemProfessor;
	DisciplinaTemProfessorDAO disciplinaTemProfessorDAO = new DisciplinaTemProfessorDAO();
	
	Historico historico;
	HistoricoDAO historicoDAO = new HistoricoDAO();

	
	public void cadastrarProfessorEmDisciplina(int idProfessor,int idDisciplina){

    	professor = professorDAO.buscarPorId(idProfessor);
        disciplina = disciplinaDAO.buscarPorId(idDisciplina);
        
        if(professor != null && disciplina != null){
        	disciplinaTemProfessor = new DisciplinaTemProfessor(idDisciplina,idProfessor);
        	disciplinaTemProfessorDAO.salvar(disciplinaTemProfessor);
        }
	}
	
	public void cadastrarAlunoEmTurma(int idAluno,int idTurma){

    	aluno = alunoDAO.buscarPorId(idAluno);
        turma = turmaDAO.buscarPorId(idTurma);
        
        if(aluno != null && turma != null){
        	historico = new Historico(idAluno,idTurma);
        	historico.setIdDisciplina(turma.getIdDisciplina());
        	historicoDAO.salvar(historico);
        	}
	}
	
	public void cadastrarDisciplinaEmTurma(int idDisciplina, int idTurma){
		disciplina = disciplinaDAO.buscarPorId(idDisciplina);
        turma = turmaDAO.buscarPorId(idTurma);
        
        if(disciplina != null && turma != null){
        	turmaDAO.alterarDisciplina(idTurma, idDisciplina);
        	disciplinaDAO.alterarNumeroDeTurmasOfertadas(idDisciplina,1);     	
        }
	}

	public void cadastrarProfessorEmTurma(int idProfessor, int idTurma) {
		professor = professorDAO.buscarPorId(idProfessor);
        turma = turmaDAO.buscarPorId(idTurma);
        
        if(professor != null && turma != null){
        	turmaDAO.alterarProfessor(idTurma, idProfessor);
        }
	}

}



