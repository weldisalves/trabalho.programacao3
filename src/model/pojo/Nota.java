package model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Nota")
public class Nota {
	@Id
	@GeneratedValue
	private int idNota;
	@Column
	private int idTurma;
	@Column
	private int idAluno;
	@Column
	private int idAtividade;
	@Column
	private double notaObtida;
	
	public void setNotaObtida(double nota){ this.notaObtida=nota; }

}
