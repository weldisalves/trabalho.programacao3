package trabalho.model.pojo;

public class Disciplina {
		
		private String nome;
		private String ementa;
		private int cargaHoraria;
		
		public Disciplina(String nome){
			this.nome=nome;
		}
		
		public Disciplina(String nome, String ementa, int cargaHoraria){
			this.nome = nome;
			this.ementa = ementa;
			this.cargaHoraria =cargaHoraria;
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
			Disciplina other = (Disciplina) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Disciplina [Nome : " + nome + ", Ementa : " + ementa
					+ ", Carga Horária : " + cargaHoraria + "]";
		}
		
	}