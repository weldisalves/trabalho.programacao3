package trabalho.model.dao;

import java.util.ArrayList;
import java.util.List;

import trabalho.model.pojo.Professor;

public class ProfessorDAO implements DAOGenerico<Professor> {
	
		
		private List<Professor> listaProfessor;
		
		public ProfessorDAO() {
			this.listaProfessor = new ArrayList<Professor>();
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
			
			return listaProfessor.get(listaProfessor.indexOf(objeto));
		}


	}