package trabalho.model.pojo;

public class Professor {

	private String nome;
	private String cpf;
	private String departamento;
	
	public Professor(String cpf){
		this.cpf=cpf;
	}
	
	public Professor(String nome, String cpf, String departamento){
		this.nome = nome;
		this.cpf = cpf;
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
		return "Nome: "+this.nome + "\t Cpf: " +this.cpf + "\t Departamento: " +this.departamento ;
	}


	
}