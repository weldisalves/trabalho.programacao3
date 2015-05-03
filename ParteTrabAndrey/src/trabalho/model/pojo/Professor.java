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


	// ainda temos que ver como sobreescrever este m�todo
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        return Objects.equals(this.cpf, other.cpf);
    }



	
	@Override
	public String toString(){
		return "Nome: "+this.nome + "\t Cpf: " +this.cpf + "\t Departamento: " +this.departamento ;
	}


	
}
