package tabuleiro;

public class Coordenada {
	
	/*
	 * Representa um vetor inteiro de 2 dimensões
	 */
	
	public int x;
	public int y;
	
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// métodos somar
	public Coordenada somar(Coordenada coordenada) {
		return new Coordenada(this.x + coordenada.x, this.y + coordenada.y);
	}
	
	public Coordenada somar(int x, int y) {
		return new Coordenada(this.x + x, this.y + y);
	}
	
	// métodos verificar se duas coordenadas são iguais
	public boolean verificarCoordenada(Coordenada coordenada) {
		return coordenada.x == this.x && coordenada.y == this.y;
	}
	
	public boolean verificarCoordenada(int x, int y) {
		return x == this.x && y == this.y;
	}
	
}
