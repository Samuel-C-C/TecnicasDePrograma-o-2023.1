package pessoas;

import java.util.ArrayList;

import main.Biblioteca;
import publicacoes.Publicacao;

public abstract class Cliente extends Pessoa {
	
	private int matricula;
	private ArrayList<Publicacao> publicacoesPegasEmprestadas;
	private int maximoNumeroPublicacoesPegasEmprestadas;
	private double tP;
	private int numeroDiasEmprestimo;
	private int numeroPublicacoes;
	
	public int getMatricula() {
		return matricula;
	}
	
	public ArrayList<Publicacao> getPublicacoesPegasEmprestadas() {
		return publicacoesPegasEmprestadas;
	}
	
	public int getMaximoNumeroPublicacoesPegasEmprestadas() {
		return maximoNumeroPublicacoesPegasEmprestadas;
	}
	
	public double getTP() {
		return tP;
	}
	
	public int getNumeroDiasEmprestimo() {
		return numeroDiasEmprestimo;
	}
	
	public int getNumeroPublicacoes() {
		return numeroPublicacoes;
	}

	public Cliente(String nome, int matricula, int maximo, int dias) {
		super(nome);
		this.matricula = matricula;
		
		this.publicacoesPegasEmprestadas = new ArrayList<Publicacao>();
		this.maximoNumeroPublicacoesPegasEmprestadas = maximo;
		this.numeroDiasEmprestimo = dias;
		this.tP = 0;
		this.numeroPublicacoes = 0;
	}
	
	public void doarPublicacao(Biblioteca biblioteca, Publicacao publicacao) {
		biblioteca.doarPublicacao(publicacao);
		this.numeroPublicacoes++;
	}
	
	private void somarTp(double quantidade) {
		this.tP += quantidade;
	}
	
	// retorna true se não poder pegar livros emprestados por conta do TP
	public final boolean verificarTp() {
		return this.getTP() - this.getNumeroPublicacoes() * 50 >= 50;
	}
	
	public void pegarPublicacaoEmprestada(Publicacao publicacao, double custoTp) {
		this.getPublicacoesPegasEmprestadas().add(publicacao);
		this.somarTp(custoTp);
	}
	
	public abstract void pegarPublicacaoEmprestada(Publicacao publicacao);

}
