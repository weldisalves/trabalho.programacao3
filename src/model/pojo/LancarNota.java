package model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "LancarNota")
public class LancarNota {

	@Id
	@GeneratedValue
	private int idLancarNotas;
	@Column
	private int idNota;
	@Column
	private int idAluno;
	@Column
	private int idTurma;
	@Column
	private int idAtividade;
	@Column
	private double nota;
	
	public LancarNota(){}
	
	public LancarNota(int idTurma, int idAluno, int idAtividade) {
		this.idAluno=idAluno;
		this.idAtividade=idAtividade;
		this.idTurma=idTurma;
	}

	public int getId() {
		return idLancarNotas;
	}

	public void setIdLancarNotas(int idLancarNotas) {
		this.idLancarNotas = idLancarNotas;
	}

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
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
