package view;

import java.util.Scanner;

import model.dao.GerenciadorDAO;

public class GerenciadorView {
	
	Scanner ler = new Scanner(System.in);
	GerenciadorDAO gerenciadorDAO = new GerenciadorDAO();
	AlunoView alunoView = new AlunoView();
	
	public void cadastrarProfessorEmDisciplina(){
		System.out.println("\n=== Cadastrar professor em disciplina ");
		System.out.println("\n Digite o ID do professor: ");
		int idProfessor = ler.nextInt();
		
		System.out.println("\n Digite o ID da Disciplina: ");
		int idDisciplina = ler.nextInt();
		
		gerenciadorDAO.cadastrarProfessorEmDisciplina(idProfessor, idDisciplina);
		
	}
	
	public void alterarAluno(){
		
		int opcao;
		do{
			System.out.println("\n=== Alterar Aluno");
			System.out.println("1-Nome");
			System.out.println("2-CPF");
			System.out.println("0-Sair");
			System.out.println("Digite a opcao: ");
			opcao = ler.nextInt();
			
			switch(opcao){
			case 1:
				alunoView.alterarNome();
				break;
			
			case 2:
				alunoView.alterarCpf();
				break;
			default : break;
			}
			
			
		}while(opcao!=0);
	}
	
	public void cadastrarAlunoEmTurma(){
		System.out.println("\n=== Cadastrar aluno em turma ");
		System.out.println("\n Digite o ID do Aluno: ");
		int idAluno = ler.nextInt();
		
		System.out.println("\n Digite o ID da Turma: ");
		int idTurma = ler.nextInt();
		
		gerenciadorDAO.cadastrarAlunoEmTurma(idAluno,idTurma);
		
	}
	
	public void cadastrarDisciplinaEmTurma(){
		System.out.println("\n=== Cadastrar disciplina em turma");
		System.out.println("\n Digite o ID da disciplina: ");
		int idDisciplina = ler.nextInt();
		
		System.out.println("\n Digite o ID da Turma: ");
		int idTurma = ler.nextInt();
		
		gerenciadorDAO.cadastrarDisciplinaEmTurma(idDisciplina,idTurma);
	}

	public void cadastrarProfessorEmTurma() {
		System.out.println("\n=== Cadastrar professor em turma");
		System.out.println("\n Digite o ID do Professor: ");
		int idProfessor = ler.nextInt();
		
		System.out.println("\n Digite o ID da Turma: ");
		int idTurma = ler.nextInt();
		
		gerenciadorDAO.cadastrarProfessorEmTurma(idProfessor,idTurma);
		
	}
	
}
