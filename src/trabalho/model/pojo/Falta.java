package trabalho.model.pojo;

public class Falta {
	private Turma turma;
	private Aluno aluno;
	private int numeroDeFaltas;
	
	public Turma getTurma() {return turma;	}
	public Aluno getAluno() {return aluno;	}
	public int getNumeroDeFaltas() {return numeroDeFaltas;	}
	public void setNumeroDeFaltas(int numeroDeFaltas) {	this.numeroDeFaltas = numeroDeFaltas;
	}
}
