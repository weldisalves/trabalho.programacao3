package trabalho.view;


import java.util.Scanner;

import trabalho.model.dao.AlunoDAO;
import trabalho.model.pojo.Aluno;


public class AlunoView {
	
	private static Scanner ler = new Scanner(System.in);
	private static Aluno newAluno;
	private AlunoDAO alunos;
	
	public AlunoView(){
		this.alunos = new AlunoDAO();
	}
	

	public void cadastrar(){
		
		System.out.println("\n Cadastrar aluno");
		
		System.out.println("\n nome: ");
		String nome = ler.nextLine();
		System.out.println("\n CPF: ");
		String cpf = ler.nextLine();		
		
		newAluno = new Aluno(nome,cpf);
		
		this.alunos.salvar(newAluno);
				
	}
	
	
	//lista
	
	public void listarAluno(){
		for(Aluno aluno : this.alunos.listar()){
			System.out.println(aluno);
		}
	}
	//pesquisar
	
	public void pesquisarAluno(){
		System.out.println("\n PESQUISAR ALUNO");
		System.out.println("\n Digite o cpf:");
		String cpf = ler.nextLine();
		
		newAluno = new Aluno(cpf);
		
		System.out.println(this.alunos.buscar(newAluno));
		
		
	}
	
	public void removerAluno(){
		System.out.println("\nALUNO QUE DESEJA REMOVER");
		System.out.println("\n Digite o cpf:");
		String cpf = ler.nextLine();
		
		newAluno = new Aluno(cpf);
		this.alunos.buscar(newAluno);
		this.alunos.remover(newAluno);
		System.out.println("Apagado com seguranca");
			
	}
	

}