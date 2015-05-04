package trabalho.view;

public class MenuPrincipal {
	
	public static void main(String[] args){
		AlunoView alunoView = new AlunoView();
		ProfessorView professorView = new ProfessorView();
		DisciplinaView disciplinaView = new DisciplinaView();
		alunoView.cadastrar();
		alunoView.listarAluno();
		alunoView.pesquisarAluno();
		professorView.cadastrar();
		professorView.listarProfessor();
		professorView.pesquisarProfessor();	
		disciplinaView.cadastrar();
		disciplinaView.listarDisciplina();
		disciplinaView.pesquisarDisciplina();
		}

}
