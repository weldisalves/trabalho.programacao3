package model.pojo;

import java.util.List;

import javax.persistence.*;

import org.jboss.cache.annotations.Compat;

@Entity
@Table(name="Turma")
public class Turma {
	
	@Id
	@GeneratedValue
	private int idTurma;
	@Column
	private String ano;
	@Column
	private int periodo;
	@Column
	private String local;
	@Column
	private String horario;
	@Column
	private int numeroDeVagas;
	
	@ManyToMany
    @JoinTable(name="Historico", joinColumns={@JoinColumn(name="idTurma")},
    inverseJoinColumns={@JoinColumn(name="idAluno")})
    private List<Aluno> listaAlunos;
	@Column
	private int idDisciplina;
	@Column
	private int idProfessor;
	 
	
	public Turma(){}
	public Turma(String ano) {
		this.ano=ano;
	}
	public Turma(String ano, int periodo, String local, String horario, int numerodevagas){
		this(ano);
		this.periodo=periodo;
		this.local=local;
		this.horario=horario;
		this.numeroDeVagas=numerodevagas;
		this.idDisciplina=0;
		this.idProfessor=0;
		this.idTurma=0;
	}
	

	public String getAno() {return this.ano;	}

	public void setAno(String ano) {this.ano = ano;	}

	public int getPeriodo() {return this.periodo;	}

	public void setPeriodo(int periodo) {this.periodo = periodo;	}

	public String getLocal() {return this.local;	}

	public void setLocal(String local) {this.local = local;	}

	public String getHorario() {return this.horario;	}

	public void setHorario(String horario) {this.horario = horario; }

	public int getNumeroDeVagas() {return this.numeroDeVagas; }

	public void setNumeroDeVagas(int numeroDeVagas) {this.numeroDeVagas = numeroDeVagas; }
	
	public int getId(){return this.idTurma;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.idTurma + "\t Ano : " + this.ano + "\t Periodo : " + this.periodo + "\t Local : "
				+ this.local + "\t Horario : " + this.horario + "\t Numero de vagas : "
				+ this.numeroDeVagas;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor=idProfessor;		
	}

}