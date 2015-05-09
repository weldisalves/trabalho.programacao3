package trabalho.model.pojo;

public class Atividade {

	private String nome;
	private String tipo;
	private String data;
	private Double valor;
	
	public Atividade(){
		this.nome = null;
		this.tipo = null;
		this.data = null;
		this.valor = 0.0;
	}
	
	public Atividade(String nome){
		this();
		this.nome=nome;
	}
	
	public Atividade(String nome, String tipo, String data, Double valor){
		this.nome = nome;
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
	}	

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Atividade other = (Atividade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Atividade nome : " + nome + ", tipo : " + tipo + ", data : " + data
				+ ", valor : " + valor ;
	}
	
}