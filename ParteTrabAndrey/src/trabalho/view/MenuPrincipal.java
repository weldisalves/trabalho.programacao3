package trabalho.view;

public class MenuPrincipal {
	
	public static void main(String[] args){
		AlunoView alunoView = new AlunoView();
		ProfessorView professorView = new ProfessorView();
		DisciplinaView disciplinaView = new DisciplinaView();
		TurmaView turmaView = new TurmaView();
		AtividadeView atividadeView = new AtividadeView();
		alunoView.cadastrar();
		alunoView.listarAluno();
		alunoView.pesquisarAluno();
		professorView.cadastrar();
		professorView.listarProfessor();
		professorView.pesquisarProfessor();	
		disciplinaView.cadastrar();
		disciplinaView.listarDisciplina();
		disciplinaView.pesquisarDisciplina();
		turmaView.cadastrar();
		turmaView.listarTurma();
		turmaView.pesquisarTurma();
		atividadeView.cadastrar();
		atividadeView.listarAtividade();
		//algum bug no pesquisarAtividade
		//atividadeView.pesquisarAtividade();
		}

}
