package model.pojo;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Professor")
public class Professor {
	
	@Id
	@GeneratedValue
	private int idProfessor;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String departamento; 
	
	@ManyToMany(mappedBy="listaProfessores")
    private List<Disciplina> listaDisciplinas;
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    //@JoinColumn(name="idProfessor")
    //private List<Turma> listaTurmas;
	
	public Professor(){}
	public Professor(String cpf){
		this.cpf=cpf;
	}
	
	public Professor(String nome, String cpf, String departamento){
		this(cpf);
		this.nome = nome;
		this.departamento = departamento;
	}	
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return "ID: "+this.idProfessor+ "\t Nome: "+this.nome + "\t Cpf: " +this.cpf + "\t Departamento: " +this.departamento ;
	}
	public int getId() { return this.idProfessor;}
	
}