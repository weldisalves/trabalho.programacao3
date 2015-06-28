package model.dao;

import javax.persistence.*;

import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.DisciplinaTemProfessor;
import model.pojo.DisciplinaTemTurma;
import model.pojo.Historico;
import model.pojo.Professor;
import model.pojo.ProfessorTemTurma;
import model.pojo.Turma;
import util.JPAUtil;


public class GerenciadorDAO {
	
	private Professor professor;
	private ProfessorDAO professorDAO = new ProfessorDAO();
	
	private Disciplina disciplina;
	private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	
	private Aluno aluno;
	private AlunoDAO alunoDAO = new AlunoDAO();
	
	private Turma turma;
	private TurmaDAO turmaDAO = new TurmaDAO();
	
	private DisciplinaTemProfessor disciplinaTemProfessor;
	private DisciplinaTemProfessorDAO disciplinaTemProfessorDAO = new DisciplinaTemProfessorDAO();
	
	private Historico historico;
	private HistoricoDAO historicoDAO = new HistoricoDAO();
	
	private ProfessorTemTurma professorTemTurma;
	private ProfessorTemTurmaDAO professorTemTurmaDAO = new ProfessorTemTurmaDAO();
	
	private DisciplinaTemTurma disciplinaTemTurma;
	private DisciplinaTemTurmaDAO disciplinaTemTurmaDAO = new DisciplinaTemTurmaDAO();

	
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
        	disciplinaTemTurma = new DisciplinaTemTurma(idDisciplina,idTurma);
        	disciplinaTemTurmaDAO.salvar(disciplinaTemTurma);
        	disciplinaDAO.alterarNumeroDeTurmasOfertadas(idDisciplina,1);     	
        }
	}

	public void cadastrarProfessorEmTurma(int idProfessor, int idTurma) {
		professor = professorDAO.buscarPorId(idProfessor);
        turma = turmaDAO.buscarPorId(idTurma);
        
        if(professor != null && turma != null){
        	professorTemTurma = new ProfessorTemTurma(idProfessor,idTurma);
        	professorTemTurmaDAO.salvar(professorTemTurma);
        }
	}

}



