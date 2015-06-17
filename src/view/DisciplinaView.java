package view;

import java.util.Scanner;

import model.dao.DisciplinaDAO;
import model.pojo.Disciplina;

public class DisciplinaView {
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Disciplina objeto;
		private DisciplinaDAO disciplinas = new DisciplinaDAO();
		
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
			this.disciplinas.salvar(objeto);
					
		}
				
		//listar
		
		public void listarDisciplina(){
			System.out.println("=== DISCILINAS: ");
			for(Disciplina disciplina : this.disciplinas.listar()){
				System.out.println(disciplina);
			}
		}
		//pesquisar
		
		public void pesquisarDisciplina(){
			System.out.println("\n=== PESQUISAR Disciplina");
			System.out.println("\n Digite o nome:");
			String nome = ler.nextLine();
			objeto = new Disciplina(nome);
			
			for(Disciplina disciplina : this.disciplinas.buscarPorNome(nome)){
				System.out.println(disciplina);
			}	
		}
		
		public void removerDisciplina(){
			System.out.println("\n=== REMOVER DISCIPLINA");
			System.out.println("\nEntre com o nome:");	
			String nome = ler.nextLine();
							
			if(this.disciplinas.buscarPorNome(nome)!= null){
				objeto = new Disciplina(nome);
				objeto = this.disciplinas.buscarPorNome(nome).get(this.disciplinas.buscarPorNome(nome).indexOf(objeto));
				this.disciplinas.remover(objeto);
				System.out.println("\n===Disciplina removido ====");
				return;
			}
			
			System.out.println("\n=== Nome nao cadastrado! ===\n");
			
		}
		
		public void buscarPorId(){
			System.out.println("\n=== BUSCAR POR ID");
			System.out.println("\n Entre com o ID da Disciplina: ");
			int id = ler.nextInt();
			
			System.out.println(disciplinas.buscarPorId(id));
			
		}
	}