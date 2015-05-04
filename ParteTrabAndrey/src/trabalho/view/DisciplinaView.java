package trabalho.view;
import java.util.Scanner;
import trabalho.model.dao.DisciplinaDAO;
import trabalho.model.pojo.Disciplina;

public class DisciplinaView {

		private static Scanner ler = new Scanner(System.in);
		 
		private static Disciplina newDisciplina;
		private DisciplinaDAO disciplinas;
		
		public DisciplinaView(){
			this.disciplinas = new DisciplinaDAO();
		}
		

		public void cadastrar(){
			
			System.out.println("\n Cadastrar disciplina");
			
			System.out.println("\n nome: ");
			String nome = ler.nextLine();
			System.out.println("\n ementa: ");
			String ementa = ler.nextLine();		
			System.out.println("\n carga horaria: ");
			int cargahoraria = ler.nextInt(); 
			
			newDisciplina = new Disciplina(nome,ementa,cargahoraria);
			
			this.disciplinas.salvar(newDisciplina);
					
		}
		
		
		//lista
		
		public void listarDisciplina(){
			for(Disciplina disciplina : this.disciplinas.listar()){
				System.out.println(disciplina);
			}
		}
		//pesquisar
		
		public void pesquisarDisciplina(){
			System.out.println("\n PESQUISAR Disciplina");
			System.out.println("\n Digite o nome:");
			String nome = ler.nextLine();
			
			newDisciplina = new Disciplina(nome);
			
			System.out.println(this.disciplinas.buscar(newDisciplina));
			
			
		}
		

	}

