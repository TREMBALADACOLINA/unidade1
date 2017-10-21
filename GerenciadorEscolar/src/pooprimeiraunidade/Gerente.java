package pooprimeiraunidade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Gerente {

	private static List<Aluno> alunos = new ArrayList<>();
	private static List<Professor> professores = new ArrayList<>();
	private static List<Disciplina> disciplinas = new ArrayList<>();
	private static List<Turma> turmas = new ArrayList<>();

	public Gerente() {

	}

	public static List<Aluno> getAlunos() {
		return alunos;
	}

	public static void setAlunos(List<Aluno> alunos) {
		Gerente.alunos = alunos;
	}

	public static List<Professor> getProfessores() {
		return professores;
	}

	public static void setProfessores(List<Professor> professores) {
		Gerente.professores = professores;
	}

	public static List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public static void setDisciplinas(List<Disciplina> disciplinas) {
		Gerente.disciplinas = disciplinas;
	}

	public static List<Turma> getTurmas() {
		return turmas;
	}

	public static void setTurmas(List<Turma> turmas) {
		Gerente.turmas = turmas;
	}

	public void cadastrarAluno(Aluno a) {
		Gerente.alunos.add(a);
	}

	public void cadastrarProfessor(Professor p) {
		Gerente.professores.add(p);
	}

	public void cadastrarDisciplina(Disciplina d) {
		Gerente.disciplinas.add(d);
	}

	public void cadastrarTurma(Turma t) {
		Gerente.turmas.add(t);
	}

	public Aluno buscaAluno(String mat) throws Exception {
		for (Aluno a : Gerente.alunos) {
			if (a.getMatricula().equals(mat)) {
				return a;
			}
		}
		throw new Exception("Matricula inexistente!");
	}

	public Professor buscaProfessor(String mat) throws Exception {
		for (Professor p : Gerente.professores) {
			if (p.getMatricula().equals(mat)) {
				return p;
			}
		}
		throw new Exception("Matricula Inexistente");
	}

	public Disciplina buscaDisciplina(String cod) throws Exception {
		for (Disciplina p : Gerente.disciplinas) {
			if (p.getCodigo().equals(cod)) {
				return p;
			}
		}
		throw new Exception("Código Inexistente!");
	}

	public void excluirAluno(String mat) {
		for (Aluno a : Gerente.alunos) {
			if (a.getMatricula().equals(mat)) {
				Gerente.alunos.remove(a);
			}
		}
	}

	public void editarAluno(String mat, Aluno aluno) {
		for (Aluno a : Gerente.alunos) {
			if (a.getMatricula().equals(mat)) {
				Gerente.alunos.remove(a);
				Gerente.alunos.add(aluno);
			}
		}
	}

	public void exibirAlunos() {
		String str = "";
		for (Aluno a : Gerente.getAlunos()) {
			String append = "MAT: " + a.getMatricula() + " | NOME: " + a.getNome();
			if (str.trim().isEmpty()) {
				str = append;

			} else {
				str = str + "\n" + append;
			}

		}

		JOptionPane.showMessageDialog(null, str.trim().isEmpty() ? "Nenhum aluno foi cadastrado" : str,
				"ALUNOS CADASTRADOS", 1);

	}

	public void exibirTurma() {
		String str = "";
		for (Turma a : Gerente.getTurmas()) {
			String append = "COD: " + a.getCodigo() + " | DISC: " + a.getDisciplina().getNome() + " | PROF: "
					+ a.getProfessor().getNome();
			if (str.trim().isEmpty()) {
				str = append;

			} else {
				str = str + "\n" + append;
			}

		}

		JOptionPane.showMessageDialog(null, str.trim().isEmpty() ? "Nenhuma turma foi cadastrada" : str,
				"TURMAS CADASTRADAS", 1);

	}

	public void exibirDisciplinas() {
		String str = "";
		for (Disciplina a : Gerente.getDisciplinas()) {
			String append = "COD: "+a.getCodigo() + " | NOME: " + a.getNome() + " | ARÉA: " + a.getArea();
			if (str.trim().isEmpty()) {
				str = append;

			} else {
				str = str + "\n" + append;
			}

		}

		JOptionPane.showMessageDialog(null, str.trim().isEmpty() ? "Nenhuma disciplina foi cadastrada" : str,
				"DISCIPLINAS CADASTRADAS", 1);

	}

	public void exibirProfessores() {
		String str = "";
		for (Professor a : Gerente.getProfessores()) {
			String append = "MAT: "+a.getMatricula() + " | NOME: " + a.getNome();
			if (str.trim().isEmpty()) {
				str = append;
			} else {
				str = str + "\n" + append;
			}

		}

		JOptionPane.showMessageDialog(null, str.trim().isEmpty() ? "Nenhum professor foi cadastrado" : str,
				"PROFESSORES CADASTRADOS", 1);

	}

}
