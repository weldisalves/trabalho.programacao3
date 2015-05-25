package trabalho.model.pojo;

import java.util.ArrayList;

public class Turma {

	private String ano;
	private int periodo;
	private String local;
	private String horario;
	private int numeroDeVagas;
	private Professor professor;
	private Disciplina disciplina;
	private ArrayList<Aluno> alunos;
	
	public Turma(String ano){
		this.ano=ano;
	}
	
	public Turma(String ano, int periodo, String local, String horario, int numeroDeVagas){
		this.ano = ano;
		this.periodo = periodo;
		this.local = local;
		this.horario = horario;
		this.numeroDeVagas = numeroDeVagas;
		
		
	}	
	/*
	 * construtor para criar a turma com todos os campos devidamente preenchidos 
	 * e com a lista de alunos vazia
	 */
	public Turma(String ano, int periodo, String local, String horario, int numeroDeVagas,Professor professor, Disciplina disciplina){
		this(ano,periodo,local,horario,numeroDeVagas);
		this.professor = professor;
		this.disciplina = disciplina;
		this.alunos = new ArrayList<Aluno>();
		
	}
	
	public Turma(String ano, int periodo, String disciplina) {
		// TODO Auto-generated constructor stub
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumeroDeVagas() {
		return this.numeroDeVagas;
	}

	public void setNumeroDeVagas(int numeroDeVagas) {
		this.numeroDeVagas = numeroDeVagas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (ano == null) {
			if (other.ano != null || other.periodo != 0 || other.disciplina!=null)
				return false;
		} else if (!ano.equals(other.ano)||periodo != other.periodo||!disciplina.equals(other.disciplina))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Turma [ano : " + ano + ", periodo : " + periodo + ", local : "
				+ local + ", horario : " + horario + ", numerodevagas : "
				+ numeroDeVagas + "]";
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}