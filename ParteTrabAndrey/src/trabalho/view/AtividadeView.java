package trabalho.view;

import java.util.Scanner;

import trabalho.model.dao.AtividadeDAO;
import trabalho.model.pojo.Atividade;

public class AtividadeView {
		
		private static Scanner ler = new Scanner(System.in);
		private static Atividade newAtividade;
		private AtividadeDAO atividades;
		
		public AtividadeView(){
			this.atividades = new AtividadeDAO();
		}
		
		public void cadastrar(){
			
			System.out.println("\n Cadastrar atividade");
			
			System.out.println("\n nome: ");
			String nome = ler.nextLine();
			System.out.println("\n tipo: ");
			String tipo = ler.nextLine();		
			System.out.println("\n data: ");
			String data = ler.nextLine();
			System.out.println("\n valor: ");
			int valor = ler.nextInt();
			newAtividade = new Atividade(nome,tipo,data,valor);
			
			this.atividades.salvar(newAtividade);
					
		}
		
		
		//lista
		
		public void listarAtividade(){
			for(Atividade atividade : this.atividades.listar()){
				System.out.println(atividade);
			}
		}
		//pesquisar
		
		public void pesquisarAtividade(){
			System.out.println("\n PESQUISAR ATIVIDADE");
			System.out.println("\n Digite o nome:");
			String nome = ler.nextLine();
			
			newAtividade = new Atividade(nome);
			
			System.out.println(this.atividades.buscar(newAtividade));
			
			
		}
		
}
