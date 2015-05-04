package trabalho.model.pojo;

public class Turma {

	private String ano;
	private int periodo;
	private String local;
	private String horario;
	private int numerodevagas;
	
	public Turma(String ano){
		this.ano=ano;
	}
	
	public Turma(String ano, int periodo, String local, String horario, int numerodevagas){
		this.ano = ano;
		this.periodo = periodo;
		this.local = local;
		this.horario = horario;
		this.numerodevagas = numerodevagas;
		
	}	
	

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumerodevagas() {
		return numerodevagas;
	}

	public void setNumerodevagas(int numerodevagas) {
		this.numerodevagas = numerodevagas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
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
		Turma other = (Turma) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		return true;
	}



	
	@Override
	public String toString() {
		return "Turma [ano : " + ano + ", periodo : " + periodo + ", local : "
				+ local + ", horario : " + horario + ", numerodevagas : "
				+ numerodevagas + "]";
	}
	
}
