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

	public Nota(int idTurma, int idAtividade) {
		this.idTurma = idTurma;
		this.idAtividade=idAtividade;
	}
	public int getId() {
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
	

}
