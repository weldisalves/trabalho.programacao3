package trabalho.view;

public class MenuPrincipal {
	
	public static void main(String[] args){
		AlunoView alunoView = new AlunoView();
		ProfessorView professorView = new ProfessorView();
		alunoView.cadastrar();
		alunoView.listarAluno();
		//alunoView.pesquisarAluno();
		professorView.cadastrar();
		professorView.listarProfessor();
		//professorView.pesquisarProfessor();	
		}

}
