package model.pojo;

import javax.persistence.*;

@Entity
@Table(name="DisciplinaTemProfessor")
public class DisciplinaTemProfessor {
	@Id
	@GeneratedValue
	private int idDisciplinaTemProfessor;
	@Column
	private int idDisciplina;
	@Column
	private int idProfessor;
	
	public DisciplinaTemProfessor(){}
	public DisciplinaTemProfessor (int idDisciplina, int idProfessor) {
		this.idDisciplina=idDisciplina;
		this.idProfessor=idProfessor;		
	}
	
	public int getId() {
		return idDisciplinaTemProfessor;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdDisciplina(int idDisciplina){ this.idDisciplina=idDisciplina;}
	public void setIdProfessor(int idProfessor){ this.idProfessor = idProfessor; }

}
