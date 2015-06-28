package model.pojo;

import javax.persistence.*;

@Entity
@Table(name="DisciplinaTemTurma")
public class DisciplinaTemTurma {
	@Id
	@GeneratedValue
	private int idDisciplinaTemTurma;
	@Column
	private int idDisciplina;
	@Column
	private int idTurma;
	
	public DisciplinaTemTurma(int idDisciplina, int idTurma) {
		this.idDisciplina=idDisciplina;
		this.idTurma=idTurma;
	}
	public int getId() {
		return idDisciplinaTemTurma;
	}
	public void setIdDisciplinaTemTurma(int idDisciplinaTemTurma) {
		this.idDisciplinaTemTurma = idDisciplinaTemTurma;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
}
