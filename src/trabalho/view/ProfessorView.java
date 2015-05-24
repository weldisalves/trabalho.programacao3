package trabalho.view;

import java.io.IOException;
import java.util.Scanner;

import trabalho.model.dao.ProfessorDAO;
import trabalho.model.pojo.Professor;

public class ProfessorView {

	private static Scanner ler = new Scanner(System.in);
	private static Professor newProfessor;
	private ProfessorDAO professores;
	
	public ProfessorView() throws IOException{
		this.professores = new ProfessorDAO();
	}
	
	//Função que atualiza o arquivo com os dados da lista
	public void atualizarArquivo()throws IOException{
		for(Professor professores : this.professores.listar()){
			this.professores.exportar(professores);
			}
	}

	public void cadastrar(){
		System.out.println("\n Cadastrar professor\n nome:");
		String nome = ler.nextLine();
		System.out.println("CPF: ");
		String cpf = ler.nextLine();
		System.out.println("Departamento: ");
		String departamento = ler.nextLine();
		newProfessor = new Professor(nome,cpf,departamento);
		this.professores.salvar(newProfessor);	
	}
	
	//lista
	public void listarProfessor(){
		System.out.println("=== PROFESSORES: ");
		for(Professor professor : this.professores.listar()){
			System.out.println(professor);
		}
		System.out.println("\n");
	}
	
	//pesquisar
	public void pesquisarProfessor(){
		System.out.println("\n=== PESQUISAR PROFESSOR");
		System.out.println("\n Digite o cpf:");
		String cpf = ler.nextLine();
		
		newProfessor = new Professor(cpf);
		
		System.out.println(this.professores.buscar(newProfessor));
		
		
	}
	public void removerProfessor(){
		System.out.println("\nEntre com o CPF do aluno\nCPF:");	
		String cpf = ler.nextLine();
		newProfessor = new Professor(cpf);
		if(this.professores.buscar(newProfessor) != null){
			this.professores.remover(newProfessor);
			System.out.println("\n==== Professor removido ====");
			return;
		}
		
		System.out.println("\n=== CPF não cadastrado! ===\n");
	   }
	



}