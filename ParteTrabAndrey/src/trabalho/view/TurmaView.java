package trabalho.view;

import java.util.Scanner;

import trabalho.model.dao.TurmaDAO;
import trabalho.model.pojo.Turma;

public class TurmaView {
	
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Turma newTurma;
		private TurmaDAO turmas;
		
		public TurmaView(){
			this.turmas = new TurmaDAO();
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
			
			newTurma = new Turma(ano,periodo,local,horario,numerodevagas);
			
			this.turmas.salvar(newTurma);
					
		}
		
		
		//lista
		
		public void listarTurma(){
			for(Turma turma : this.turmas.listar()){
				System.out.println(turma);
			}
		}
		//pesquisar
		
		public void pesquisarTurma(){
			System.out.println("\n PESQUISAR TURMA");
			System.out.println("\n Digite o ano:");
			String ano = ler.nextLine();
			
			newTurma = new Turma(ano);
			
			System.out.println(this.turmas.buscar(newTurma));
			
			
		}
		

}
