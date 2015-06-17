package trabalho.model.pojo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Turma")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
    @JoinTable(name = "alunos_da_turma", joinColumns = {
        @JoinColumn(name = "idTurma")}, inverseJoinColumns = {
        @JoinColumn(name = "idAluno")})
	private List<Aluno> alunos;
    
    @ManyToOne
	private Disciplina disciplina;
	
	@ManyToOne
	private Professor professor;
	
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
	
	public int getId(){return this.id;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		return result;
	}

	/*@Override
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
	}*/
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\t Ano : " + this.ano + "\t Periodo : " + this.periodo + "\t Local : "
				+ this.local + "\t Horario : " + this.horario + "\t Numero de vagas : "
				+ this.numeroDeVagas;
	}

}