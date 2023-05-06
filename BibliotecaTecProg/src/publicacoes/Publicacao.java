package publicacoes;

import java.util.ArrayList;

import pessoas.Pessoa;

public abstract class Publicacao {
	
	private String titulo;
	private int anoPublicacao;
	private ArrayList<Pessoa> autores;
	private int quantidadeDisponivel;
	
	private double descontoAluno;
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public ArrayList<Pessoa> getAutores() {
		return autores;
	}
	
	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}
	
	public double getDescontoAluno() {
		return descontoAluno;
	}

	public Publicacao(String titulo, int anoPublicacao, Pessoa autor, int quantidadeDisponivel, double desconto) {
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		
		this.autores = new ArrayList<Pessoa>();
		this.autores.add(autor);
		
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.descontoAluno = desconto;
	}
	
	public Publicacao(String titulo, int anoPublicacao, ArrayList<Pessoa> autores, int quantidadeDisponivel, double desconto) {
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		
		this.autores = new ArrayList<Pessoa>();
		this.autores.addAll(autores);
		
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.descontoAluno = desconto;
	}
	
	public void emprestar() {
		this.quantidadeDisponivel--;
	}
	
	public String toString() {
		String string =  this.titulo + " ano: " + this.anoPublicacao + "autores: ";
		for (int i = 0; i < this.autores.size(); i++) {
			Pessoa autor = this.autores.get(i);
			if (i > 0)
				string += ", ";
			string += autor.getNome();
		}
		return string;
	}

}
