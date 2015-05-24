package trabalho.view;



import java.util.Scanner;
import java.io.IOException;

import trabalho.model.dao.AlunoDAO;
import trabalho.model.pojo.Aluno;


public class AlunoView {
	
	private static Scanner ler = new Scanner(System.in);
	private static Aluno newAluno;
	private AlunoDAO alunos;
	
	public AlunoView(AlunoDAO alunos)throws IOException{
		this.alunos = alunos;
		// O construtor de AlunoView instancia aluno DAO
		// e a lista de alunos � importada do arquivo.
	}
	
	
	

	public void cadastrar(){
		
		System.out.println("\n Cadastrar aluno");
		System.out.println("Nome: ");
		String nome = ler.nextLine();
		System.out.println("CPF: ");
		String cpf = ler.nextLine();
		newAluno = new Aluno(nome,cpf);
		this.alunos.salvar(newAluno);
	}
	
	
	//lista
	
	public void atualizarArquivo()throws IOException{
		for(Aluno aluno : this.alunos.listar()){
			alunos.exportar(aluno);

		}
	}
	
	//Arquiva os dados da lista
	public void listarAluno(){
		System.out.println("=== ALUNOS: ");
		for(Aluno aluno : this.alunos.listar()){
			System.out.println(aluno);
		}
	}
	//pesquisar
	
	public void pesquisarAluno(){
		System.out.println("\n=== PESQUISAR ALUNO");
		System.out.println("\n Digite o cpf:");
		String cpf = ler.nextLine();
		
		newAluno = new Aluno(cpf);
		
		System.out.println(this.alunos.buscar(newAluno));
		
		
	}
	
	public void removerAluno(){
		System.out.println("\nEntre com o CPF do aluno:");	
		String cpf = ler.nextLine();
		
		newAluno = new Aluno(cpf);
		
		if(this.alunos.buscar(newAluno)!= null){
			this.alunos.remover(newAluno);
			System.out.println("\n==== Aluno removido ====");
			return;
		}
		
		System.out.println("\n=== CPF nao cadastrado! ===\n");
		
	}
	
	public AlunoDAO getAlunos(){
		return alunos;
	}

}