package trabalho.model.pojo;

import javax.persistence.*;

@Entity
public class Atividade {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String nome;
	@Column
	private String tipo;
	@Column
	private String data;
	@Column
	private Double valor;
	
	public Atividade(){}
	public Atividade(String nome){ this.nome=nome; }
	public Atividade(String nome, String tipo, String data, double valor){
		this(nome);
		this.tipo=tipo;
		this.data=data;
		this.valor=valor;
	}

	public String getNome() {return this.nome;	}

	public void setNome(String nome) {this.nome = nome;	}

	public String getTipo() {return this.tipo;	}

	public void setTipo(String tipo) {this.tipo = tipo;	}

	public String getData() {return this.data;	}

	public void setData(String data) {this.data = data;	}

	public Double getValor() {return this.valor;	}

	public void setValor(Double valor) {this.valor = valor;	}
	
	public int getId(){ return this.id; }

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
		return "ID: " + this.id + "\t Nome : " + nome + "\t Tipo : " + tipo + "\t Data : " + data
				+ "\t valor : " + valor ;
	}

}