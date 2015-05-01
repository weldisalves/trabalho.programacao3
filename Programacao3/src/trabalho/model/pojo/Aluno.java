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
    public boolean equals(Object obj) {
		if(obj == null) return false;	
		if(this == obj ){ 
			return true;
			}
		
		return false;
       
    }
	
	@Override
	public String toString(){
		return "Nome: "+this.nome + "\t Cpf: " + this.cpf;
	}
	
}
