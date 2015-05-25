package trabalho.view;

import java.io.IOException;
import java.util.Scanner;

import trabalho.model.dao.AlunoDAO;
import trabalho.model.dao.DisciplinaDAO;
import trabalho.model.dao.ProfessorDAO;
import trabalho.model.dao.TurmaDAO;
import trabalho.model.pojo.Aluno;
import trabalho.model.pojo.Disciplina;
import trabalho.model.pojo.Turma;

public class MenuPrincipal {
	private static Scanner entrada;
	private static Scanner local;
	public static void Menu() throws IOException{
		          
		        System.out.println("\n=== MENU PRINCIPAL ===");
		        System.out.println("0. Sair/salvar no arquivo");
		        System.out.println("1. Aluno");
		        System.out.println("2. Professor");
		        System.out.println("3. Disciplina");
		        System.out.println("4. Turma");
		        System.out.println("5. Atividade");
		        System.out.println("6. Salvar atualizações");
		        System.out.println("\nDigite o numero correspondente a opcao:");
			}
		    
		public static void CadastroAluno(){
	        System.out.println("=== OPÇÕES:");
	        System.out.println("1-Cadastrar aluno");
	        System.out.println("2-Listar alunos");
	        System.out.println("3-Pesquisar aluno");
	        System.out.println("4-remover aluno");
	        System.out.println("5-cadastrar em uma turma");
	        System.out.println("0- Voltar ao menu principal");
	        System.out.println("\nDigite o numero correspondente a opcao:");
		}
		
		public static void CadastroProfessor(){
	    	 System.out.println("=== OPÇÕES:");
		        System.out.println("1-Cadastrar Professor");
		        System.out.println("2-Listar Professor");
		        System.out.println("3-Pesquisar Professor");
		        System.out.println("4-remover Professor");
		        System.out.println("0- Voltar ao menu principal");
		        System.out.println("\nDigite o numero correspondente a opcao:");
		}
		
		public static void CadastroDisciplina(){
	    	 System.out.println("=== OPÇÕES:");
		        System.out.println("1-Cadastrar Disciplina");
		        System.out.println("2-Listar Disciplinas");
		        System.out.println("3-Pesquisar disciplina");
		        System.out.println("4-remover disciplina");
		        System.out.println("0- Voltar ao menu principal");
		        System.out.println("\nDigite o numero correspondente a opcao:");
		}
		
		public static void CadastroTurma(){
	    	 	System.out.println("=== OPÇÕES:");
		        System.out.println("1-Cadastrar turma");
		        System.out.println("2-Listar turma");
		        System.out.println("3-Pesquisar turma");
		        System.out.println("4-remover turma");
		        System.out.println("0- Voltar ao menu principal");
		        System.out.println("\nDigite o numero correspondente a opcao:");
		 }
		
		public static void CadastrarAtividade(){
		    	System.out.println("=== OPÇÕES:");
		        System.out.println("1-Cadastrar Atividade");
		        System.out.println("2-Listar Atividade");
		        System.out.println("3-Pesquisar Atividade");
		        System.out.println("4-remover Atividade");
		        System.out.println("0- Voltar ao menu principal");
		        System.out.println("\nDigite o numero correspondente a opcao:");
		}
		
		public static void cadastrarAlunoEmUmaTurma(AlunoDAO alunos, TurmaDAO turmas,DisciplinaDAO disciplinas){
			System.out.println("\n Cadastrar Aluno em uma turma\n");
			System.out.println("\n Digite o cpf do aluno: ");
			local = new Scanner(System.in);
			String cpf = local.nextLine();
			Aluno newAluno = new Aluno(cpf);
			
			if(alunos.listar().contains(newAluno)) newAluno = alunos.buscar(newAluno);
			
			else{ System.out.println("\n Aluno não existe");
			return;
			}
			
			System.out.println("\n Digite o ano da turma: ");
			String ano = local.nextLine();
			
			System.out.println("\n Digite o periodo: ");
			int periodo = local.nextInt();
			
			System.out.println("\n Digite o nome da disciplina: ");
			String disciplina = local.nextLine();
			
			Disciplina newDisciplina = new Disciplina(disciplina);
			
			Turma newTurma = new Turma(ano,periodo,disciplina);
			
			if(turmas.listar().contains(newTurma) && disciplinas.listar().contains(newDisciplina)){
				
				int index = turmas.listar().indexOf(newTurma);
				
				turmas.listar().get(index).getAlunos().add(newAluno);
				index = alunos.listar().indexOf(newAluno);
				alunos.listar().get(index).getTurmas().add(newTurma);
			}
			
			
			
			
		}
						  
		public static void main(String[] args) throws IOException {	    
			
			ProfessorDAO professores = new ProfessorDAO();
			DisciplinaDAO disciplinas = new DisciplinaDAO();
			AlunoDAO alunos = new AlunoDAO();
			TurmaDAO turmas = new TurmaDAO();
			
			AlunoView alunoView = new AlunoView(alunos);
			ProfessorView professorView = new ProfessorView(professores);
			DisciplinaView disciplinaView = new DisciplinaView(disciplinas);
			TurmaView turmaView = new TurmaView();
			AtividadeView atividadeView = new AtividadeView();
			entrada = new Scanner(System.in);
			
			int opcao,opcao2;
		        
		        do{
		        	
		            Menu();		         
		            opcao = entrada.nextInt();		          		       		   		            		    	    
		            for(;opcao!=0&&opcao!=1&&opcao!=2&&opcao!=3&&opcao!=4&&opcao!=5&&opcao!=6;){
		            	System.out.println("\n==== Opção inválida ====\nDigite a opção novamente:");
		            	opcao = entrada.nextInt();
		            }
		          
		            switch(opcao){
		            case 0:
		            	alunoView.atualizarArquivo();
		            	atividadeView.atualizarArquivo();
		            	disciplinaView.atualizarArquivo();
		            	professorView.atualizarArquivo();
		                turmaView.atualizarArquivo();
		            	System.out.println("Salvando no Arquivo...");
		            	
					
		              break;
		            case 1:
		            	CadastroAluno();
		            	opcao2 = entrada.nextInt();
				        if(opcao2==1){
				        	int opcao3;
				        	alunoView.cadastrar();
				        	System.out.println("\n==== Aluno cadastrado ====\nDeseja cadastrar outo aluno?\n1- Sim\n0- Não");
				        	opcao3=entrada.nextInt();
				        		if(opcao3==0||opcao3==1){
				        			for(;opcao3==0||opcao3==1;){
				        		
				        				if(opcao3==1){
				        					alunoView.cadastrar();
				        					System.out.println("\n==== Aluno cadastrado ====\nDeseja cadastrar outo aluno?\n1- Sim\n0- Não");
				        					opcao3=entrada.nextInt();
				        				}
				        				else if(opcao3==0){
				        					Menu();
				        					break;
				        				}
				        				else{
				        					System.out.println("\n==== Opção inválida ====\n");	
				        					Menu();
				        				}
				        			}
				        		}
			        						        		
				        }
				        if(opcao2==2){
				        	alunoView.listarAluno();
				       }
				        if(opcao2==3){
				        	alunoView.pesquisarAluno();
				        }
				        if(opcao2==4){
				        	
				        	int opcao3;
				        	alunoView.removerAluno();
				        	System.out.println("Deseja remover outro aluno?\n1- Sim\n0- Não");
				        	opcao3=entrada.nextInt();
				        		if(opcao3==0||opcao3==1){
				        			for(;opcao3==0||opcao3==1;){
				        		
				        				if(opcao3==1){
				        					alunoView.removerAluno();
				        					System.out.println("\nDeseja remover outro aluno?\n1- Sim\n0- Não");
				        					opcao3=entrada.nextInt();
				        				}
				        				else if(opcao3==0){
				        					Menu();
				        					break;
				        				}
				        				else{
				        					System.out.println("\n==== Opção inválida ====\n");	
				        					Menu();
				        				}
				        			}
				        		}
			        							        		
				        	}
				        if(opcao2==5){
				        	cadastrarAlunoEmUmaTurma(alunos,turmas,disciplinas);
				        }
				        
				        if(opcao2==0){
				        	Menu();
				        }
		                break;
		            case 2:
		            	CadastroProfessor();
		            	opcao2 = entrada.nextInt();
				        if(opcao2==1){
				        	int opcao3;
				        	professorView.cadastrar();
				        	System.out.println("\n==== Professor cadastrado ====\nDeseja cadastrar outo professor?\n1- Sim\n0- Não");
				        	opcao3=entrada.nextInt();
				        		if(opcao3==0||opcao3==1){
				        			for(;opcao3==0||opcao3==1;){
				        		
				        				if(opcao3==1){
				        					professorView.cadastrar();
				        					System.out.println("\n==== Professor cadastrado ====\nDeseja cadastrar outo professor?\n1- Sim\n0- Não");
				        					opcao3=entrada.nextInt();
				        				}
				        				else if(opcao3==0){
				        					Menu();
				        					break;
				        				}
				        				else{
				        					System.out.println("\n==== Opção inválida ====\n");	
				        					Menu();
				        				}
				        			}
				        		}
			        			
				        }
				        if(opcao2==2){
				        	professorView.listarProfessor();
				        }
				        if(opcao2==3){
				        	professorView.pesquisarProfessor();
				        }
				        if(opcao2==4){				    	
				        	int opcao3;
				        	professorView.removerProfessor();
				        	System.out.println("Deseja remover outro professor?\n1- Sim\n0- Não");
				        	opcao3=entrada.nextInt();
				        		if(opcao3==0||opcao3==1){
				        			for(;opcao3==0||opcao3==1;){
				        		
				        				if(opcao3==1){
				        					professorView.removerProfessor();
				        					System.out.println("\nDeseja remover outro Professor?\n1- Sim\n0- Não");
				        					opcao3=entrada.nextInt();
				        				}
				        				else if(opcao3==0){
				        					Menu();
				        					break;
				        				}
				        				else{
				        					System.out.println("\n==== Opção inválida ====\n");	
				        					Menu();
				        				}
				        			}
				        		}
			        			
				        }
				        if(opcao2==0){
				        	Menu();
				        }
				        break;
		            case 3:
		            	CadastroDisciplina();
		            	opcao2 = entrada.nextInt();
				        if(opcao2==1){
				        	int opcao3;
				        	disciplinaView.cadastrar();
				        	System.out.println("\n==== Disciplina cadastrada ====\nDeseja cadastrar outra disciplina?\n1- Sim\n0- Não");
				        	opcao3=entrada.nextInt();
				        		if(opcao3==0||opcao3==1){
				        			for(;opcao3==0||opcao3==1;){
				        		
				        				if(opcao3==1){
				        					disciplinaView.cadastrar();
				        					System.out.println("\n==== Disciplina cadastrada ====\nDeseja cadastrar outra disciplina?\n1- Sim\n0- Não");
				        					opcao3=entrada.nextInt();
				        				}
				        				else if(opcao3==0){
				        					Menu();
				        					break;
				        				}
				        				else{
				        					System.out.println("\n==== Opção inválida ====\n");	
				        					Menu();
				        				}
				        			}
				        		}
				        }
				        if(opcao2==2){
				        	disciplinaView.listarDisciplina();
				        }
				        if(opcao2==3){
				        	disciplinaView.pesquisarDisciplina();
				        }
				        if(opcao2==4){
				        	int opcao3;
				        	disciplinaView.removerDisciplina();
				        	System.out.println("Deseja remover outra Disciplina?\n1- Sim\n0- Não");
				        	opcao3=entrada.nextInt();
				        		if(opcao3==0||opcao3==1){
				        			for(;opcao3==0||opcao3==1;){
				        		
				        				if(opcao3==1){
				        					disciplinaView.removerDisciplina();
				        					System.out.println("\nDeseja remover outra Discilina?\n1- Sim\n0- Não");
				        					opcao3=entrada.nextInt();
				        				}
				        				else if(opcao3==0){
				        					Menu();
				        					break;
				        				}
				        				else{
				        					System.out.println("\n==== Opção inválida ====\n");	
				        					Menu();
				        				}
				        			}
				        		}
				        }
				        if(opcao2==0){
				        	Menu();
				        }
				        break;
		            case 4:
		            	CadastroTurma();
		            	opcao2 = entrada.nextInt();
				        if(opcao2==1){				        
				        	turmaView.cadastrar(professorView,disciplinaView);				        	
				        }
				        if(opcao2==2){
				        	turmaView.listarTurma();
				        }
				        if(opcao2==3){
				        	turmaView.pesquisarTurma();
				        }
				        if(opcao2==4){
				        	turmaView.removerTurma();
				        }
				        if(opcao2==0){
				        	Menu();
				        }
				        break;
		            case 5:
		            	CadastrarAtividade();
		            	opcao2 = entrada.nextInt();
				        if(opcao2==1){
				        	atividadeView.cadastrar();				   
				        }
				        if(opcao2==2){
				        	atividadeView.listarAtividade();
				        }
				        if(opcao2==3){
				        	atividadeView.pesquisarAtividade();
				        }
				        if(opcao2==4){
				        	atividadeView.removerAtividade();
				        }
				        if(opcao2==0){
				        	Menu();
				        	
				        }
				        break;
		            case 6:
		            	alunoView.atualizarArquivo();
		            	atividadeView.atualizarArquivo();
		            	disciplinaView.atualizarArquivo();
		            	professorView.atualizarArquivo();
		                turmaView.atualizarArquivo();
		                System.out.println("=== Salvo com sucesso ===\n");
				        break;
		           
		            default:
		            	System.out.println("\n==== Opção inválida ====\n");
		            }
		        } while(opcao != 0);
		        
		    }
		
}
		
		


