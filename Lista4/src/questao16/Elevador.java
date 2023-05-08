package questao16;

public class Elevador {
	
	private int andarAtual;
	private int totalNumeroAndares;
	private int numeroPessoas;
	private int capacidadePessoas;
	
	public int getAndarAtual() {
		return andarAtual;
	}
	
	public int getTotalNumeroAndares() {
		return totalNumeroAndares;
	}
	
	public int getNumeroPessoas() {
		return numeroPessoas;
	}
	
	public int getCapacidadePessoas() {
		return capacidadePessoas;
	}
	
	public Elevador(int totalNumeroAndares, int capacidadePessoas) {
		this.totalNumeroAndares = totalNumeroAndares;
		this.capacidadePessoas = capacidadePessoas;
		
		this.andarAtual = 0;
		this.numeroPessoas = 0;
		
	}
	
	public void entra() {
		if (this.numeroPessoas < this.capacidadePessoas) {
			this.numeroPessoas++;
		}
		
	}
	
	public void sai() {
		if (this.numeroPessoas > 0) {
			this.numeroPessoas--;
		}
		
	}
	
	public void sobe() {
		if (this.andarAtual < this.totalNumeroAndares) {
			this.andarAtual++;
		}
		
	}
	
	public void desce() {
		if (this.andarAtual > 0) {
			this.andarAtual--;
		}
		
	}

}
