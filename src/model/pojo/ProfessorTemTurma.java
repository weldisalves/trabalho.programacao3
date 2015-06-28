package model.pojo;

import javax.persistence.*;

@Entity
@Table(name="ProfessorTemTurma")
public class ProfessorTemTurma {
	@Id
	@GeneratedValue
	private int idProfessorTemTurma;
	@Column
	private int idProfessor;
	@Column
	private int idTurma;
	public ProfessorTemTurma(int idProfessor, int idTurma) {
		this.idProfessor=idProfessor;
		this.idTurma=idTurma;
	}
	public int getId() {
		return idProfessorTemTurma;
	}
	public void setIdProfessorTemTurma(int idProfessorTemTurma) {
		this.idProfessorTemTurma = idProfessorTemTurma;
	}
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	

}
