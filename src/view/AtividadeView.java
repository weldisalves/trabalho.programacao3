package view;

import java.util.Scanner;

import model.dao.AtividadeDAO;
import model.pojo.Atividade;

public class AtividadeView {
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Atividade objeto;
		private AtividadeDAO atividades = new AtividadeDAO();
		
		public void cadastrar(){
			System.out.println("\n Cadastrar atividade");
			System.out.println("\n nome: ");
			String nome = ler.nextLine();
			System.out.println("\n tipo: ");
			String tipo = ler.nextLine();		
			System.out.println("\n data: ");
			String data = ler.nextLine();
			System.out.println("\n Valor: ");
			Double valor = sc.nextDouble();
			objeto = new Atividade(nome,tipo,data,valor);
			this.atividades.salvar(objeto);
					
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
			
			for(Atividade atividade : this.atividades.buscarPorNome(nome)){
				System.out.println(atividade);
			}	
		}
		
		//remover
		public void removerAtividade(){
			System.out.println("\nATIVIDADE QUE DESEJA REMOVER");
			System.out.println("\n Digite o nome:");
			String nome = ler.nextLine();
			
			if(this.atividades.buscarPorNome(nome)!= null){
				objeto = new Atividade(nome);
				objeto = this.atividades.buscarPorNome(nome).get(this.atividades.buscarPorNome(nome).indexOf(objeto));
				this.atividades.remover(objeto);
				System.out.println("Apagado com seguranca");
				return;
			}
			
			System.out.println("\n Nao existe");
			
			
		}
		
		public void buscarPorId(){
			System.out.println("\n=== BUSCAR POR ID");
			System.out.println("\n Entre com o ID da atividade: ");
			int id = ler.nextInt();
			
			System.out.println(atividades.buscarPorId(id));
			
		}
		
}