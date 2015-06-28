package view;

import java.io.IOException;
import java.util.Scanner;

import model.dao.AlunoDAO;
import model.dao.LancarNotaDAO;
import model.dao.NotaDAO;
import model.dao.TurmaDAO;
import model.pojo.Historico;
import model.pojo.LancarNota;
import model.pojo.Nota;
import model.pojo.Turma;

public class TurmaView {
	
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Turma objeto;
		private TurmaDAO turmaDAO = new TurmaDAO();
		private Nota nota;
		private NotaDAO notaDAO = new NotaDAO();
		private LancarNotaDAO lancarNotaDAO= new LancarNotaDAO();
		
		public TurmaView() throws IOException{
			this.turmaDAO = new TurmaDAO();
		}
		

		public void cadastrar(){
			
			System.out.println("\n Cadastrar turma");
			System.out.println("\n ano: ");
			String ano = ler.nextLine();
			System.out.println("\n periodo: ");

			int periodo = sc.nextInt();
			System.out.println("\n local: ");
			String local = ler.nextLine();
			System.out.println("\n horario: ");
			String horario = ler.nextLine();
			System.out.println("\n numero de vagas: ");
			int numerodevagas = sc.nextInt();
			
			objeto = new Turma(ano,periodo,local,horario,numerodevagas);
			this.turmaDAO.salvar(objeto);		
					
		}
		
		//lista
		
		public void listarTurma(){
			for(Turma turma : this.turmaDAO.listar()){
				System.out.println(turma);
			}
		}
		//pesquisar
		
		public void pesquisarTurma(){
			System.out.println("\n PESQUISAR TURMA");
			System.out.println("\n Digite o ano:");
			String ano = ler.nextLine();
			
			for(Turma turma: this.turmaDAO.buscarPorAno(ano)){
				System.out.println(turma);
			}			
		}
		
		public void removerTurma(){
			System.out.println("\nTURMA QUE DESEJA REMOVER");
			System.out.println("\n Digite o ID da Turma: ");
			int id = ler.nextInt();
							
			if(this.turmaDAO.buscarPorId(id)!= null){
				this.turmaDAO.remover(this.turmaDAO.buscarPorId(id));
				System.out.println("\n==== Aluno removido ====");
				return;
			}
			
			System.out.println("\n=== CPF nao cadastrado! ===\n");
			
			
		}
		public void buscarPorId(){
			System.out.println("\n=== BUSCAR POR ID");
			System.out.println("\n Entre com o ID da Turma: ");
			int id = ler.nextInt();
			
			System.out.println(turmaDAO.buscarPorId(id));
			
		}
		
		public void consultarTurma(){
			System.out.println("\n PESQUISAR TURMA");
			System.out.println("\n Digite a disciplina: ");
			String disciplina = ler.next();
			System.out.println("\n Digite o ano: ");
			String ano = ler.next();
			System.out.println("\n Digite  o periodo: ");
			int periodo = ler.nextInt();
			
			for(Historico historico: this.turmaDAO.consultarTurma(ano,periodo,disciplina)){
				System.out.println(historico);
			}			
		}
		
		public void adicionarFaltasAAluno(){
			System.out.println("\n=== FALTAS");
			System.out.println("\n Digite o ID da turma: ");
			int idTurma = ler.nextInt();
			
			System.out.println("\n Digite o ID do aluno: ");
			int idAluno = ler.nextInt();
			
			System.out.println("\n Digite a quantidade de faltas a serem adicionadas: ");
			int faltas = ler.nextInt();
			
			//faltaDAO.adicionarFaltasAAluno(idTurma,idAluno,faltas);
		}


		public void cadastrarAtividadeEmTurma() {
			System.out.println("\n=== Cadastrar atividade em turma");
			System.out.println("Digite o ID da Turma: ");
			int idTurma = ler.nextInt();
			System.out.println("Digite o ID da Atividade: ");
			int idAtividade = ler.nextInt();
			nota = new Nota(idTurma,idAtividade);
			notaDAO.salvar(nota);
		}


		public void lancarNotas() {
			System.out.println("\n=== Lancar Notas");
			System.out.println("Digite o ID da Turma: ");
			int idTurma = ler.nextInt();
			System.out.println("Digite o ID da Atividade: ");
			int idAtividade = ler.nextInt();
			System.out.println("Digite o ID do Aluno: ");
			int idAluno = ler.nextInt();
			LancarNota lancarNotas = new LancarNota(idTurma,idAluno,idAtividade);
			lancarNotaDAO.salvar(lancarNotas);
						
		}
}
		