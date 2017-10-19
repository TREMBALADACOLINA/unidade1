package pooprimeiraunidade;

import java.util.ArrayList;
import java.util.List;

public class Gerente{
	
	private static List<Aluno> alunos = new ArrayList();
	private static List<Professor> professores = new ArrayList();
	private static List<Disciplina> disciplinas = new ArrayList();
	private static List<Turma> turmas = new ArrayList();
	
	public Gerente(){

	}
	
	public void cadastrarAluno(Aluno a){
		this.alunos.add(a);
	}
	
	public void cadastrarProfessor(Professor p){
		this.professores.add(p);
	}
	
	public void cadastrarDisciplina(Disciplina d){
		this.disciplinas.add(d);
	}
	
	public void cadastrarTurma(Turma t){
		this.turmas.add(t);
	}
	
	public Aluno buscaAluno(String mat) throws Exception{
		for(Aluno a: this.alunos){
			if(a.getMatricula().equals(mat)){
				return a;
			}
		}
		throw new Exception("Matricula inexistente!");
	}
	
	public Professor buscaProfessor(String mat) throws Exception{
		for(Professor p: this.professores){
			if(p.getMatricula().equals(mat)){
				return p;
			}
		}
		throw new Exception("Matricula Inexistente");
	}
	
	public Disciplina buscaDisciplina(String cod) throws Exception{
		for(Disciplina p: this.disciplinas){
			if(p.getCodigo().equals(cod)){
				return p;
			}
		}
		throw new Exception("Código Inexistente!");
	}
	
	
	
	public void excluirAluno(String mat){
		for(Aluno a: this.alunos){
			if(a.getMatricula().equals(mat)){
				this.alunos.remove(a);
			}
		}
	}
	
	
	
	public void editarAluno(String mat, Aluno aluno){
		for(Aluno a: this.alunos){
			if(a.getMatricula().equals(mat)){
				this.alunos.remove(a);
				this.alunos.add(aluno);
			}
		}
	}
	
	
}
