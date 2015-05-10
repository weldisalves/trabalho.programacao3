package trabalho.model.pojo;

public class Turma {

	private String ano;
	private int periodo;
	private String local;
	private String horario;
	private int numeroDeVagas;
	
	public Turma(String ano){
		this.ano=ano;
	}
	
	public Turma(String ano, int periodo, String local, String horario, int numeroDeVagas){
		this.ano = ano;
		this.periodo = periodo;
		this.local = local;
		this.horario = horario;
		this.numeroDeVagas = numeroDeVagas;
		
	}	
	
	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumeroDeVagas() {
		return this.numeroDeVagas;
	}

	public void setNumeroDeVagas(int numeroDeVagas) {
		this.numeroDeVagas = numeroDeVagas;
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
				+ numeroDeVagas + "]";
	}
	
}