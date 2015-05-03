package trabalho.view;

public class MenuPrincipal {
	
	public static void main(String[] args){
		AlunoView alunoView = new AlunoView();
		
		alunoView.cadastrar();
		alunoView.cadastrar();
		alunoView.listarAluno();
		alunoView.pesquisarAluno();
	}

}
