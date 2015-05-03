package trabalho.model.dao;

import java.util.ArrayList;
import java.util.List;

import trabalho.model.pojo.Aluno;

public class AlunoDAO implements DAOGenerico<Aluno> {
	
	private List<Aluno> listaAluno;
	
	public AlunoDAO() {
		this.listaAluno = new ArrayList<Aluno>();
	}

	@Override
	public void salvar(Aluno objeto) {
		listaAluno.add(objeto);
		
	}

	@Override
	public void remover(Aluno objeto) {
		listaAluno.remove(objeto);
		
	}

	@Override
	public List<Aluno> listar() {
		
		return this.listaAluno;
	}

	@Override
	public Aluno buscar(Aluno objeto) {
		
		return listaAluno.get(listaAluno.indexOf(objeto));
	}


}
