package control;

public class Aluno {
	
	private String nome;
	private String CPF;
	private String matricula;
	private String vertente;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getVertente() {
		return vertente;
	}

	public void setVertente(String vertente) {
		this.vertente = vertente;
	}

	public Aluno(String nome, String CPF, String matricula, String vertente) {
		this.nome = nome;
		this.CPF = CPF;
		this.matricula = matricula;
		this.vertente = vertente;
	}

}
