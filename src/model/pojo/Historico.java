package model.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Historico")
public class Historico {
	
	@Id
	@GeneratedValue
	private int idHistorico;
	@Column
	private int idTurma;
	@Column
	private int idDisciplina;
	public int getIdHistorico() {
		return idHistorico;
	}
	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	@Column
	private int idAluno;
	@Column
	private int faltas;
	@Column
	private int idNota;
	@Column
	private double nota;
	@Column 
	private String status;
	
	public Historico(){}
	public Historico(int idAluno, int idTurma){
		this.idAluno=idAluno;
		this.idTurma=idTurma;
	}
	
	public int getId() {
		return idHistorico;
	}
	
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setNumeroDeFaltas(int faltas) {
		this.faltas = faltas;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		return "ID Aluno: "+this.idAluno+"\tID Turma: "+this.idTurma+"\t Numero de Faltas: "+this.faltas+"\t Nota: "+this.nota+"\t Status: "+this.status;
	}
	
	

}
