package questao14;

public class Pessoa {
	
	private int idade;
	private int diaNascimento;
	private int mesNascimento;
	private int anoNascimento;
	
	private String nome;
	
	public int informaIdade() {
		return idade;
	}
	
	public int getDiaNascimento() {
		return diaNascimento;
	}
	
	public int getMesNascimento() {
		return mesNascimento;
	}
	
	public int getAnoNascimento() {
		return anoNascimento;
	}
	
	public String informaNome() {
		return nome;
	}
	
	public void ajustaDataDeNascimento(int dia, int mes, int ano) {
		this.diaNascimento = dia;
		this.mesNascimento = mes;
		this.anoNascimento = ano;
	}
	
	public Pessoa(String nome, int dia, int mes, int ano) {
		this.nome = nome;
		this.diaNascimento = dia;
		this.mesNascimento = mes;
		this.anoNascimento = ano;
	}
	
	public void calcularIdade(int diaAtual, int mesAtual, int anoAtual) {
		
		int idade = anoAtual - this.anoNascimento;
		
		if (mesAtual < this.mesNascimento) {
			idade--;
		} else if (diaAtual < this.diaNascimento) {
			idade--;
		}
		
		this.idade = idade;
		
	}

}
