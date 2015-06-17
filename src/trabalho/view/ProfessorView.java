package trabalho.view;

import java.util.Scanner;

import trabalho.model.dao.ProfessorDAO;
import trabalho.model.pojo.Professor;


public class ProfessorView {
	
	private static Scanner ler = new Scanner(System.in);
	private static Professor objeto;
	private ProfessorDAO professors = new ProfessorDAO();
	
	public void cadastrar(){
		
		System.out.println("\n Cadastrar professor");
		System.out.println("Nome: ");
		String nome = ler.nextLine();
		System.out.println("CPF: ");
		String cpf = ler.nextLine();
		System.out.println("Departamento: ");
		String departamento = ler.nextLine();
		objeto = new Professor(nome,cpf,departamento);
		this.professors.salvar(objeto);
	}
		
	//Arquiva os dados da lista
	public void listarProfessor(){
		System.out.println("=== PROFESSORES: ");
		for(Professor professor : professors.listar()){
			System.out.println(professor);
		}
	}
	//pesquisar
	
	public void pesquisarProfessor(){
		System.out.println("\n=== PESQUISAR PROFESSOR");
		System.out.println("\n Digite o cpf:");
		String cpf = ler.nextLine();
		
		for(Professor professor : professors.buscarPorCpf(cpf)){
			System.out.println(professor);
		}
	}
	
	public void removerProfessor(){
		System.out.println("\n=== REMOVER PROFESSOR");
		System.out.println("\nEntre com o CPF do professor:");	
		String cpf = ler.nextLine();
						
		if(this.professors.buscarPorCpf(cpf)!= null){
			objeto = new Professor(cpf);
			objeto = this.professors.buscarPorCpf(cpf).get(this.professors.buscarPorCpf(cpf).indexOf(objeto));
			this.professors.remover(objeto);
			System.out.println("\n==== professor removido ====");
			return;
		}
		
		System.out.println("\n=== CPF nao cadastrado! ===\n");
		
	}
	
	public void buscarPorId(){
		System.out.println("\n=== BUSCAR POR ID");
		System.out.println("\n Entre com o ID do professor: ");
		int id = ler.nextInt();
		
		System.out.println(professors.buscarPorId(id));
		
	}
	
	public void buscarPorNome(){
			System.out.println("=== BUSCA POR NOME: ");
			System.out.println("\n Digite um nome: ");
			String nome = ler.nextLine();
			for(Professor professor : professors.buscarPorNome(nome)){
				System.out.println(professor);
			}
		}
	
	

}
