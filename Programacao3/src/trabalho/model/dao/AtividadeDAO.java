package trabalho.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



import trabalho.model.pojo.Atividade;


public class AtividadeDAO implements DAOGenerico<Atividade>{

		private List<Atividade> listaAtividade;
		private FileWriter arq;
		private static Atividade newAtividade;
		private BufferedReader lerArq;
		
		public AtividadeDAO() throws IOException {
			this.listaAtividade = new ArrayList<Atividade>();
			importar();
			this.arq = new FileWriter("Atividades.txt",false);
		}

		@Override
		public void salvar(Atividade objeto) {
			listaAtividade.add(objeto);
			
		}

		@Override
		public void remover(Atividade objeto) {
			listaAtividade.remove(objeto);
			
		}

		@Override
		public List<Atividade> listar() {
			
			return this.listaAtividade;
		}

		@Override
		public Atividade buscar(Atividade objeto) {
			int indice = listaAtividade.indexOf(objeto);
			if(indice >= 0 && indice <= listaAtividade.size())
				return listaAtividade.get(indice);
			return null; 		
		}
		
		// Função que exporta os dados contidos na lista para o Arquivo
		public void exportar(Atividade objeto)throws IOException{
			this.arq = new FileWriter("Atividades.txt",true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf("%s%n%s%n%s%n%s%n",objeto.getNome(), objeto.getTipo(),objeto.getData(),objeto.getValor());
			gravarArq.close();
			
			}
		
		// Função de importa os dados contidos no ar
		public void importar() throws IOException{
			FileReader arq = new FileReader("Atividades.txt"); 
			this.lerArq = new BufferedReader(arq); 
			String nome,tipo, data,valor;
			    for(nome = lerArq.readLine(),tipo = lerArq.readLine(),data = lerArq.readLine(),valor = lerArq.readLine();nome!= null;nome = lerArq.readLine(),tipo = lerArq.readLine(),data = lerArq.readLine(),valor = lerArq.readLine()){
		            Double valorfloat;  
		            valorfloat= Double.parseDouble(valor); 
			    	newAtividade = new Atividade(nome,tipo,data,valorfloat);
			    	listaAtividade.add(newAtividade);
			    	}
			    arq.close(); 
			}


	}
