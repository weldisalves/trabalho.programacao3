package trabalho.view;

import java.io.IOException;
import java.util.Scanner;

import trabalho.model.dao.TurmaDAO;
import trabalho.model.pojo.Turma;

public class TurmaView {
	
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Turma objeto;
		private TurmaDAO turmas = new TurmaDAO();
		
		public TurmaView() throws IOException{
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
			
			objeto = new Turma(ano,periodo,local,horario,numerodevagas);
			this.turmas.salvar(objeto);		
					
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
			
			for(Turma turma: this.turmas.buscarPorAno(ano)){
				System.out.println(turma);
			}			
		}
		
		public void removerTurma(){
			System.out.println("\nTURMA QUE DESEJA REMOVER");
			System.out.println("\n Digite o ID da Turma: ");
			int id = ler.nextInt();
							
			if(this.turmas.buscarPorId(id)!= null){
				this.turmas.remover(this.turmas.buscarPorId(id));
				System.out.println("\n==== Aluno removido ====");
				return;
			}
			
			System.out.println("\n=== CPF nao cadastrado! ===\n");
			
			
		}
		public void buscarPorId(){
			System.out.println("\n=== BUSCAR POR ID");
			System.out.println("\n Entre com o ID da Turma: ");
			int id = ler.nextInt();
			
			System.out.println(turmas.buscarPorId(id));
			
		}
}
		
