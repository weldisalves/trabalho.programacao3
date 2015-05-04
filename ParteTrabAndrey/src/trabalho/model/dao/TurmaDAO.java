package trabalho.model.dao;

import java.util.ArrayList;
import java.util.List;

import trabalho.model.pojo.Turma;

public class TurmaDAO implements DAOGenerico<Turma> {

		
		private List<Turma> listaTurma;
		
		public TurmaDAO() {
			this.listaTurma = new ArrayList<Turma>();
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
			
			return listaTurma.get(listaTurma.indexOf(objeto));
		}

}
