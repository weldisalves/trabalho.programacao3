package model.pojo;

import javax.persistence.*;

@Entity
@Table(name="Falta")
public class Falta {
	@Id
	@GeneratedValue
	private int idFalta;
	@Column
	private int idTurma;
	@Column 
	private int idAluno;
	@Column
	private int numeroDeFaltas;

	
	public Falta(){}
	public Falta(int idTurma, int idAluno){
		this.idAluno = idAluno;
		this.idTurma = idTurma;
		this.numeroDeFaltas = 0;
	}
	
	public int getId(){ return this.idFalta; }
	public void setNumeroDeFaltas(int falta){
		this.numeroDeFaltas += falta;
	}

}
