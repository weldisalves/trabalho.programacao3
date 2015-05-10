package trabalho.view;

import java.io.IOException;
import java.util.Scanner;

import trabalho.model.dao.DisciplinaDAO;
import trabalho.model.pojo.Disciplina;

public class DisciplinaView {
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Disciplina newDisciplina;
		private DisciplinaDAO disciplinas;
		
		
		public DisciplinaView() throws IOException{
			this.disciplinas = new DisciplinaDAO();
		}
		
		//Função que atualiza o arquivo com os dados da lista
		public void atualizarArquivo()throws IOException{
			for(Disciplina disciplinas : this.disciplinas.listar()){
				this.disciplinas.exportar(disciplinas);
				}
		}
		
        //Cadastrar
		public void cadastrar(){
			System.out.println("\n Cadastrar disciplina");
			System.out.println("\n nome: ");
			String nome = ler.nextLine();
			System.out.println("\n ementa: ");
			String ementa = ler.nextLine();		
			System.out.println("\n Carga horaria: ");
			int cargahoraria = sc.nextInt();
			newDisciplina = new Disciplina(nome,ementa,cargahoraria);
			this.disciplinas.salvar(newDisciplina);
					
		}
				
		//listar
		
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
		
		//Remover
		public void removerDisciplina(){
			System.out.println("\nDISCILPINA QUE DESEJA REMOVER");
			System.out.println("\n Digite o nome:");
			String nome = ler.nextLine();
			newDisciplina = new Disciplina(nome);
			if(this.disciplinas.buscar(newDisciplina)!= null){
				this.disciplinas.remover(newDisciplina);
				System.out.println("Apagado com seguranca");
				return;
			}
			
			System.out.println("\n Não existe!!");
				
		}

	}
