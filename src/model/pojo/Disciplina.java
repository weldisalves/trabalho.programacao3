package model.pojo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Disciplina")
public class Disciplina {
		
	@Id
	@GeneratedValue
	private int idDisciplina;
	@Column
	private String nome;
	@Column
	private String ementa;
	@Column
	private int cargaHoraria;
	@Column
	private int numeroDeTurmasOfertadas;
	
	public int getNumeroDeTurmasOfertadas() {
		return numeroDeTurmasOfertadas;
	}
	public void setNumeroDeTurmasOfertadas(int numeroDeTurmasOfertadas) {
		this.numeroDeTurmasOfertadas = numeroDeTurmasOfertadas;
	}
	@ManyToMany
    @JoinTable(name="DisciplinaTemProfessor", joinColumns={@JoinColumn(name="idDisciplina")}, 
    inverseJoinColumns={@JoinColumn(name="idProfessor")})
    private List<Professor> listaProfessores;
	
	public Disciplina(){}
	public Disciplina(String nome){
		this.nome=nome;
	}
	public Disciplina(String nome, String ementa, int cargaHoraria){
		this.nome=nome;
		this.ementa=ementa;
		this.cargaHoraria=cargaHoraria;
	}
			
	public String getNome() {
		return nome;
	}
		public void setNome(String nome) {
		this.nome = nome;
	}
		public String getEmenta() {
		return ementa;
	}
		public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
		public int getCargaHoraria() {
		return cargaHoraria;
	}
		public void setCargaHoraria(int cargahoraria) {
		this.cargaHoraria = cargahoraria;
	}
		public void setListaProfessores(Professor newProfessor){
			this.listaProfessores.add(newProfessor);
		}
		
		public int getId(){ return this.idDisciplina; }
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "ID: "+ this.idDisciplina + "\t Nome : " + nome + ", Ementa : " + ementa
				+ ", Carga Hor�ria : " + cargaHoraria ;
	}
	public void setAdicionarDisciplinaOfertada(int i) {
		this.numeroDeTurmasOfertadas+=i;
		
	}
	
}