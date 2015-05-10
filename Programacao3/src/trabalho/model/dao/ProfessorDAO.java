package trabalho.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import trabalho.model.pojo.Professor;

public class ProfessorDAO implements DAOGenerico<Professor> {
		private List<Professor> listaProfessor;
		private FileWriter arq;
		private static Professor newProfessor;
		private BufferedReader lerArq;
		
		public ProfessorDAO() throws IOException {
			this.listaProfessor = new ArrayList<Professor>();
			importar();
			this.arq = new FileWriter("Professores.txt",false);
		}

		@Override
		public void salvar(Professor objeto) {
			listaProfessor.add(objeto);
		}

		@Override
		public void remover(Professor objeto) {
			listaProfessor.remove(objeto);
		}

		@Override
		public List<Professor> listar() {
			return this.listaProfessor;
		}

		@Override
		public Professor buscar(Professor objeto) {
			int indice = listaProfessor.indexOf(objeto);
			
			if(indice >=0 && indice < listaProfessor.size()){
			return listaProfessor.get(indice);
			}
			return null;
		}

		public void exportar(Professor objeto)throws IOException{
			this.arq = new FileWriter("Professores.txt",true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf("%s%n%s%n%s%n",objeto.getNome(), objeto.getCpf(),objeto.getDepartamento());
			gravarArq.close();
			}
		
		public void importar() throws IOException{
			FileReader arq = new FileReader("Professores.txt"); 
			this.lerArq = new BufferedReader(arq); 
			String nome,cpf,departamento;
			for(nome = lerArq.readLine(),cpf = lerArq.readLine(),departamento = lerArq.readLine();nome!= null;nome = lerArq.readLine(),cpf = lerArq.readLine(),departamento = lerArq.readLine()){		            
		            newProfessor = new Professor(nome,cpf,departamento);
			    	listaProfessor.add(newProfessor);
			    	}			  			    
			    arq.close(); 
			}
	}