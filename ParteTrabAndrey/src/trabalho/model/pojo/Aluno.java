package trabalho.model.pojo;

public class Aluno {
	
	private String nome;
	private String cpf;
	
	public Aluno(String cpf){
		this.cpf=cpf;
	}
	
	public Aluno(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
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

	// ainda temos que ver como sobreescrever este método
	
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
	public String toString(){
		return "Nome: "+this.nome + "\t Cpf: " + this.cpf;
	}
	
}