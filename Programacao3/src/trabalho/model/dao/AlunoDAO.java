package trabalho.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import trabalho.model.pojo.Aluno;

public class AlunoDAO implements DAOGenerico<Aluno> {
	
	private List<Aluno> listaAluno;
	private FileWriter arq;
	private static Aluno newAluno;
	private BufferedReader lerArq;
	
	
	public AlunoDAO() throws IOException {
		this.listaAluno = new ArrayList<Aluno>();
		importar();
		this.arq = new FileWriter("Alunos.txt",false);
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
	
	public void exportar(Aluno objeto)throws IOException{
		this.arq = new FileWriter("Alunos.txt",true);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf("%s%n%s%n",objeto.getNome(), objeto.getCpf());
		gravarArq.close();
		
	}
	
	public void importar() throws IOException{
		FileReader arq = new FileReader("Alunos.txt"); 
		this.lerArq = new BufferedReader(arq); 
		String nome, cpf;
		    for(nome = lerArq.readLine(),cpf = lerArq.readLine();nome!= null;nome = lerArq.readLine(),cpf = lerArq.readLine() ){
		     newAluno = new Aluno(nome,cpf);
		     listaAluno.add(newAluno);
		  }
		    arq.close(); 
     }


}
