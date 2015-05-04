package trabalho.model.dao;

import java.util.ArrayList;

import java.util.List;

import trabalho.model.pojo.Atividade;

public class AtividadeDAO implements DAOGenerico<Atividade>{

		private List<Atividade> listaAtividade;
		
		public AtividadeDAO() {
			this.listaAtividade = new ArrayList<Atividade>();
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
			
			return listaAtividade.get(listaAtividade.indexOf(objeto));
		}


	}


