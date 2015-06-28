package model.pojo;

import javax.persistence.*;

@Entity
@Table(name= "Nota")
public class Nota {
	@Id
	@GeneratedValue
	private int idNota;
	@Column
	private int idTurma;
	@Column
	private int idAtividade;
	@Column
	private double nota;
	public int getIdNota() {
		return idNota;
	}
	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

}
