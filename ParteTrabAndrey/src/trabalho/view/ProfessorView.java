package trabalho.view;

import java.util.Scanner;

import trabalho.model.dao.ProfessorDAO;
import trabalho.model.pojo.Professor;

public class ProfessorView {

	private static Scanner ler = new Scanner(System.in);
	private static Professor newProfessor;
	private ProfessorDAO professores;
	
	public ProfessorView(){
		this.professores = new ProfessorDAO();
	}
	

	public void cadastrar(){
		
		System.out.println("\n Cadastrar professor");
		
		System.out.println("\n nome: ");
		String nome = ler.nextLine();
		System.out.println("\n CPF: ");
		String cpf = ler.nextLine();
		System.out.println("\n Departamento: ");
		String departamento = ler.nextLine();
		
		newProfessor = new Professor(nome,cpf,departamento);
		
		this.professores.salvar(newProfessor);
				
	}
	
	
	//lista
	
	public void listarProfessor(){
		for(Professor professor : this.professores.listar()){
			System.out.println(professor);
		}
	}
	//pesquisar
	
	public void pesquisarProfessor(){
		System.out.println("\n PESQUISAR PROFESSOR");
		System.out.println("\n Digite o cpf:");
		String cpf = ler.nextLine();
		
		newProfessor = new Professor(cpf);
		
		System.out.println(this.professores.buscar(newProfessor));
		
		
	}
	



}
