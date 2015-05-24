package trabalho.view;

import java.io.IOException;
import java.util.Scanner;

import trabalho.model.dao.TurmaDAO;
import trabalho.model.pojo.Disciplina;
import trabalho.model.pojo.Professor;
import trabalho.model.pojo.Turma;

public class TurmaView {
	
		private static Scanner ler = new Scanner(System.in);
		private static Scanner sc = new Scanner(System.in); 
		private static Turma newTurma;
		private TurmaDAO turmas;
		
		public TurmaView() throws IOException{
			this.turmas = new TurmaDAO();
		}
		

		public void cadastrar(ProfessorView professores, DisciplinaView disciplinas){
			
			System.out.println("\n Cadastrar turma");
			System.out.println("\n ano: ");
			String ano = ler.nextLine();
			System.out.println("\n periodo: ");
			int periodo = sc.nextInt();
			System.out.println("\n local: ");
			String local = ler.nextLine();
			System.out.println("\n horario: ");
			String horario = ler.nextLine();
			System.out.println("\n numero de vagas: ");
			int numerodevagas = sc.nextInt();
			Professor newProfessor;
			Disciplina newDisciplina;
			
			if(!professores.getProfessores().listar().isEmpty() || 
					!disciplinas.getDisciplinas().listar().isEmpty()){
				
			do{
				System.out.println("\n CPF do professor: ");
				String cpfProfessor = ler.nextLine();
				newProfessor = new Professor(cpfProfessor);	
				
			}while(!professores.getProfessores().listar().contains(newProfessor));
				
				
				do{
					System.out.println("\n Nome da disciplina: ");
					String nomeDisciplina = ler.nextLine();
					newDisciplina = new Disciplina(nomeDisciplina);	
					
				}while(!disciplinas.getDisciplinas().listar().contains(newDisciplina));
				
				
				
				newProfessor = professores.getProfessores().buscar(newProfessor);
				newDisciplina = disciplinas.getDisciplinas().buscar(newDisciplina);
				
				newTurma = new Turma(ano,periodo,local,horario,numerodevagas,newProfessor,newDisciplina);
				
				professores.getProfessores().buscar(newProfessor).getTurmas().add(newTurma);
				professores.getProfessores().buscar(newProfessor).getDisciplinas().add(newDisciplina);
				disciplinas.getDisciplinas().buscar(newDisciplina).getTurmas().add(newTurma);
				disciplinas.getDisciplinas().buscar(newDisciplina).getProfessores().add(newProfessor);
				
				this.turmas.salvar(newTurma);
			
			}else{
				System.out.println("\n Não é possível cadastrar a turma!!!");
			}			
					
		}
		
		
		public void atualizarArquivo()throws IOException{
			for(Turma turmas : this.turmas.listar()){
				this.turmas.exportar(turmas);
				}
		}
		
		//lista
		
		public void listarTurma(){
			for(Turma turma : this.turmas.listar()){
				System.out.println(turma);
			}
		}
		//pesquisar
		
		public void pesquisarTurma(){
			System.out.println("\n PESQUISAR TURMA");
			System.out.println("\n Digite o ano:");
			String ano = ler.nextLine();
			
			newTurma = new Turma(ano);
			
			System.out.println(this.turmas.buscar(newTurma));
			
			
		}
		public void removerTurma(){
			System.out.println("\nTURMA QUE DESEJA REMOVER");
			System.out.println("\n Digite o ano:");
			String ano = ler.nextLine();
			
			newTurma = new Turma(ano);
			if(this.turmas.buscar(newTurma)!= null){
				this.turmas.remover(newTurma);
				System.out.println("Apagado com seguranca");
				return;
			}
			System.out.println("\n Nao existe!!");
			
			
		}
}
		
