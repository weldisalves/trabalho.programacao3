package trabalho.view;

import java.util.Scanner;
import java.io.IOException;

import trabalho.model.dao.AtividadeDAO;
import trabalho.model.pojo.Atividade;

public class AtividadeView {
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Atividade newAtividade;
		private AtividadeDAO atividades;
		
		public AtividadeView() throws IOException{
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
			System.out.println("\n Valor: ");
			Double valor = sc.nextDouble();
			newAtividade = new Atividade(nome,tipo,data,valor);
			this.atividades.salvar(newAtividade);
					
		}
		
		//Função que atualiza o arquivo com os dados da lista
		public void atualizarArquivo()throws IOException{
			for(Atividade atividades : this.atividades.listar()){
				this.atividades.exportar(atividades);
				}
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
		
		//remover
		public void removerAtividade(){
			System.out.println("\nATIVIDADE QUE DESEJA REMOVER");
			System.out.println("\n Digite o nome:");
			String nome = ler.nextLine();
			newAtividade = new Atividade(nome);
			this.atividades.buscar(newAtividade);
			this.atividades.remover(newAtividade);
			System.out.println("Apagado com seguranca");
			
			
		}
		
}