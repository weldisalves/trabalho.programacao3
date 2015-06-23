package view;

import java.util.Scanner;

import model.dao.GerenciadorDAO;
import model.pojo.DisciplinaTemProfessor;
import view.TurmaView;

public class GerenciadorView {
	
	Scanner ler = new Scanner(System.in);
	GerenciadorDAO gerenciadorDAO = new GerenciadorDAO();
	AlunoView alunoView = new AlunoView();
	
	public void adicionarProfessorADisciplina(){
		System.out.println("\n=== Cadastrar professor em disciplina ");
		System.out.println("\n Digite o ID do professor: ");
		int idProfessor = ler.nextInt();
		
		System.out.println("\n Digite o ID da Disciplina: ");
		int idDisciplina = ler.nextInt();
		
		gerenciadorDAO.adicionarProfessorADisciplina(idProfessor, idDisciplina);
		
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
}
