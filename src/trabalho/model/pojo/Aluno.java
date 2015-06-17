package trabalho.model.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Alunos")
public class Aluno {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@ManyToMany(mappedBy = "Aluno")
	private List<Turma> turmas;
	
	public Aluno(){}
	public Aluno(String cpf){
		this.cpf = cpf;
	}
	public Aluno(String nome, String cpf) {
		this(cpf);
		this.nome = nome;
	}
	
	public String getNome() {return this.nome;	}
	public void setNome(String nome) {this.nome = nome;	}
	public String getCpf() {return this.cpf;	}
	public void setCpf(String cpf){	this.cpf = cpf;	}
	public int getId(){return this.id;}

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
		Aluno other = (Aluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	@Override
	public String toString(){return "ID: "+this.id+"\t Nome: "+this.nome + "\t Cpf: " + this.cpf;	}

}