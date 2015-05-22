package trabalho.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import trabalho.model.pojo.Disciplina;


public class DisciplinaDAO implements DAOGenerico<Disciplina>{

		private List<Disciplina> listaDisciplina;
		private FileWriter arq;
		private static Disciplina newDisciplina;
		private BufferedReader lerArq;
		
		
		public DisciplinaDAO() throws IOException {
			this.listaDisciplina = new ArrayList<Disciplina>();
			importar();
			this.arq = new FileWriter("Disciplinas.txt",false);
		}

		@Override
		public void salvar(Disciplina objeto) {
			listaDisciplina.add(objeto);
			
		}

		@Override
		public void remover(Disciplina objeto) {
			listaDisciplina.remove(objeto);
			
		}

		@Override
		public List<Disciplina> listar() {
			
			return this.listaDisciplina;
		}

		@Override
		public Disciplina buscar(Disciplina objeto) {
			int indice = listaDisciplina.indexOf(objeto);
			
			if(indice >= 0 && indice < listaDisciplina.size()){
			return listaDisciplina.get(indice);
			}
			
			return null;
		}
		
		
		public void exportar(Disciplina objeto){
			try {
				this.arq = new FileWriter("Disciplinas.txt",true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf("%s%n%s%n%s%n",objeto.getNome(), objeto.getEmenta(),objeto.getCargaHoraria());
			gravarArq.close();
			
			}
		
		private void importar() throws IOException{
			FileReader arq = new FileReader("Disciplinas.txt"); 
			this.lerArq = new BufferedReader(arq); 
			String nome,ementa,cargaHoraria;
			for(nome = lerArq.readLine(),ementa = lerArq.readLine(),cargaHoraria = lerArq.readLine();nome!= null;nome = lerArq.readLine(),ementa = lerArq.readLine(),cargaHoraria = lerArq.readLine()){		            
		            int valorInt;
		            valorInt= Integer.parseInt(cargaHoraria); 
		            newDisciplina = new Disciplina(nome,ementa,valorInt);
			    	listaDisciplina.add(newDisciplina);
			    	}			  			    
			    arq.close(); 
			}


	}

