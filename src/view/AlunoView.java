package view;

import java.util.Scanner;

import model.dao.AlunoDAO;
import model.pojo.Aluno;


public class AlunoView {
	
	private static Scanner ler = new Scanner(System.in);
	private static Aluno objeto;
	private AlunoDAO alunos = new AlunoDAO();
	
	public void cadastrar(){
		
		System.out.println("\n Cadastrar aluno");
		System.out.println("Nome: ");
		String nome = ler.nextLine();
		System.out.println("CPF: ");
		String cpf = ler.nextLine();
		objeto = new Aluno(nome,cpf);
		this.alunos.salvar(objeto);
	}
		
	
	public void listarAluno(){
		System.out.println("=== ALUNOS: ");
		for(Aluno aluno : alunos.listar()){
			System.out.println(aluno);
		}
	}
	
	public void pesquisarAluno(){
		System.out.println("\n=== PESQUISAR ALUNO");
		System.out.println("\n Digite o cpf:");
		String cpf = ler.nextLine();
		
		for(Aluno aluno : alunos.buscarPorCpf(cpf)){
			System.out.println(aluno);
		}
	}
	
	public void removerAluno(){
		System.out.println("\n=== REMOVER ALUNO");
		System.out.println("\nEntre com o CPF do aluno:");	
		String cpf = ler.nextLine();
						
		if(this.alunos.buscarPorCpf(cpf)!= null){
			objeto = new Aluno(cpf);
			objeto = this.alunos.buscarPorCpf(cpf).get(this.alunos.buscarPorCpf(cpf).indexOf(objeto));
			this.alunos.remover(objeto);
			System.out.println("\n==== Aluno removido ====");
			return;
		}
		
		System.out.println("\n=== CPF nao cadastrado! ===\n");
		
	}
	
	public void buscarPorId(){
		System.out.println("\n=== BUSCAR POR ID");
		System.out.println("\n Entre com o ID do aluno: ");
		int id = ler.nextInt();
		
		System.out.println(alunos.buscarPorId(id));
		
	}
	
	public void buscarPorNome(){
			System.out.println("=== BUSCA POR NOME: ");
			System.out.println("\n Digite um nome: ");
			String nome = ler.nextLine();
			for(Aluno aluno : alunos.buscarPorNome(nome)){
				System.out.println(aluno);
			}
		}
	
	

}