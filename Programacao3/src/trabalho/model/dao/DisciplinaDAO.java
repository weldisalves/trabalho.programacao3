package trabalho.model.dao;

import java.util.ArrayList;
import java.util.List;
import trabalho.model.pojo.Disciplina;
public class DisciplinaDAO implements DAOGenerico<Disciplina>{

		private List<Disciplina> listaDisciplina;
		
		public DisciplinaDAO() {
			this.listaDisciplina = new ArrayList<Disciplina>();
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
			
			return listaDisciplina.get(listaDisciplina.indexOf(objeto));
		}


	}

