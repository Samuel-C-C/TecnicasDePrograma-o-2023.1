package control;

import java.util.ArrayList;

public class ColecaoAlunos {
	
	private ArrayList<Aluno> alunos;
	
	public int size() {
		return this.alunos.size();
	}
	
	public Aluno getAluno(int index) {
		return this.alunos.get(index);
	}
	
	public void setAluno(int index, Aluno aluno) {
		this.alunos.set(index, aluno);
	}
	
	/**
	 * acha o index do aluno com determinada matricula
	 * @param matricula matricula do aluno
	 * @return index do aluno, -1 se não for encontrado
	 */
	public int findAlunoMatricula(String matricula) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public boolean removeAluno(Aluno aluno) {
		return this.alunos.remove(aluno);
	}
	
	public ColecaoAlunos() {
		this.alunos = new ArrayList<>();
	}

}
