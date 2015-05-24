package trabalho.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import trabalho.model.pojo.Turma;

public class TurmaDAO implements DAOGenerico<Turma> {

		
		private List<Turma> listaTurma;
		private FileWriter arq;
		private static Turma newTurma;
		private BufferedReader lerArq;
		
		public TurmaDAO() throws IOException {
			this.listaTurma = new ArrayList<Turma>();
			importar();
			this.arq = new FileWriter("Turmas.txt",false);
		}

		
		@Override
		public void salvar(Turma objeto) {
			listaTurma.add(objeto);
			
		}

		@Override
		public void remover(Turma objeto) {
			listaTurma.remove(objeto);
			
		}

		@Override
		public List<Turma> listar() {
			
			return this.listaTurma;
		}

		@Override
		public Turma buscar(Turma objeto) {
			int indice = listaTurma.indexOf(objeto);
			
			if(indice >=0 && indice < listaTurma.size()){
				return listaTurma.get(indice);
				}
			return null;
		}
		
		public void exportar(Turma turmas){
			try {
				this.arq = new FileWriter("Turmas.txt",true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf("%s%n%s%n%s%n%s%n%s%n",turmas.getAno(), turmas.getPeriodo(),turmas.getLocal(),turmas.getHorario(),turmas.getNumeroDeVagas());
			gravarArq.close();
			}
		
		private void importar() throws IOException{
			FileReader arq = new FileReader("Turmas.txt"); 
			this.lerArq = new BufferedReader(arq); 
			String ano,periodo,local, horario, numeroDeVagas;
			for(ano = lerArq.readLine(),periodo = lerArq.readLine(),local = lerArq.readLine(),horario = lerArq.readLine(),numeroDeVagas = lerArq.readLine();ano!= null;ano = lerArq.readLine(),periodo = lerArq.readLine(),local = lerArq.readLine(),horario = lerArq.readLine(),numeroDeVagas = lerArq.readLine()){		            
				    int periodoInt;  
				    int vagasInt;
				    periodoInt= Integer.parseInt(periodo); 
				    vagasInt= Integer.parseInt(numeroDeVagas);
				    
				    //no arquivo emminha opinião eu acho melhor salvar o cpf do professor 
				    //e na hora de carregar do arquivo... ele verificar se o professor está cadastrado 
				    //para não ter o risco de ter 2 professores iguais e salva o endereço desse professor na turma
				    // criei um construtor no pojo para ajudar nesta tarefa
				    
				    newTurma = new Turma(ano,periodoInt,local,horario,vagasInt);
			    	listaTurma.add(newTurma);
			    	}			  			    
			    arq.close();
			}

}