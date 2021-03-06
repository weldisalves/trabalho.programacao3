package view;

import java.util.Scanner;

import org.hibernate.QueryParameterException;

import model.dao.DisciplinaDAO;
import model.dao.DisciplinaTemProfessorDAO;
import model.dao.HistoricoDAO;
import model.pojo.Disciplina;
import model.pojo.DisciplinaTemProfessor;
import model.pojo.Historico;

public class DisciplinaView {
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Disciplina objeto;
		private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		private HistoricoDAO historicoDAO = new HistoricoDAO();
		private DisciplinaTemProfessorDAO disciplinaTemProfessorDAO = new DisciplinaTemProfessorDAO();
		
        //Cadastrar
		public void cadastrar(){
			System.out.println("\n Cadastrar disciplina");
			System.out.println("Nome: ");
			String nome = ler.nextLine();
			System.out.println("Ementa: ");
			String ementa = ler.nextLine();		
			System.out.println("Carga horaria: ");
			int cargahoraria = sc.nextInt();
			objeto = new Disciplina(nome,ementa,cargahoraria);
			this.disciplinaDAO.salvar(objeto);
					
		}
				
		//listar
		
		public void listarDisciplina(){
			System.out.println("=== DISCILINAS: ");
			for(Disciplina disciplina : this.disciplinaDAO.listar()){
				System.out.println(disciplina);
			}
		}
		//pesquisar
		
		public void pesquisarDisciplina(){
			System.out.println("\n=== PESQUISAR Disciplina");
			System.out.println("\n Digite o nome:");
			String nome = ler.nextLine();
			objeto = new Disciplina(nome);
			
			Disciplina disciplina = this.disciplinaDAO.buscarPorNome(nome);
				System.out.println(disciplina);
		}
		
		public void removerDisciplina(){
			System.out.println("\n=== REMOVER DISCIPLINA");
			System.out.println("\nEntre com o nome:");	
			String nome = ler.nextLine();
			
			objeto = this.disciplinaDAO.buscarPorNome(nome);		
			if(objeto!= null){
				
				this.disciplinaDAO.remover(objeto);
				System.out.println("\n===Disciplina removido ====");
				return;
			}
			
			System.out.println("\n=== Nome nao cadastrado! ===\n");
			
		}
		
		public void buscarPorId(){
			System.out.println("\n=== BUSCAR POR ID");
			System.out.println("\n Entre com o ID da Disciplina: ");
			int id = ler.nextInt();
			
			System.out.println(disciplinaDAO.buscarPorId(id));
			
		}

		public void consultarSituacaoDoAlunoEmDisciplina() throws IllegalArgumentException{
			try{
			System.out.println("\n=== Consultar situação do aluno em Disciplina");
			System.out.println("Digite o ID do Aluno: ");
			int idAluno = ler.nextInt();
			System.out.println("Digite o ID da disciplina: ");
			int idDisciplina = ler.nextInt();
			
			Historico historico = historicoDAO.consultarSituacaoDoAlunoEmDisciplina(idAluno,idDisciplina);
			System.out.println(historico);
			}catch(IllegalArgumentException e){
				System.out.println("Disciplina ou aluno inválido!!!");
			}
			
		}

		public void consultarNumeroDeTurmasOfertadasPorUmaDisciplina() {
			System.out.println("\n=== Consultar numero de turmas ofertadas por uma disciplina");
			System.out.println("Digite o ID da Disciplina: ");
			int idDisciplina = ler.nextInt();
			
			int quantidade = disciplinaDAO.consultarNumeroDeTurmasOfertadasPorUmaDisciplina(idDisciplina);
			
			System.out.println(quantidade);
			
		}

		public void consultarNumeroDeDisciplinasLecionadasPorUmProfessor() {
			System.out.println("\n== Consultar numero de disciplinas lecionadas por um professor");
			System.out.println("Digite o ID do Professor: ");
			int idProfessor = ler.nextInt();
			
			int quantidade = disciplinaTemProfessorDAO.consultarNumeroDeDisciplinaslecionadasPorUmProfessor(idProfessor);
			System.out.println(quantidade);
		}
	}