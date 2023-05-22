package tabuleiro;

public class Celula {
	
	/*
	 * Representa uma casa do tabuleiro
	 */
	
	private Coordenada posicao;
	private Plano plano;
	
	// usado quando desenhar o tabuleiro no terminal (privada pq só pode ser alterada pelo método visitar)
	private boolean visitada;
	
	public Coordenada getPosicao() {
		return posicao;
	}
	
	public Plano getPlano() {
		return plano;
	}
	
	// get visitada
	public boolean isVisitada() {
		return visitada;
	}
	
	// construtores
	public Celula(Coordenada posicao, Plano plano) {
		this.posicao = posicao;
		this.plano = plano;
		this.visitada = false;
	}
	
	public Celula(int x, int y, Plano plano) {
		this.posicao = new Coordenada(x, y);
		this.plano = plano;
		this.visitada = false;
	}
	
	// método usado para marcar a celula como visitada
	public void visitar() {
		this.visitada = true;
	}
	
	// verificar se a posição dada é a posição da célula
	public boolean verificarPosicao(Coordenada posicao) {
		return this.posicao.verificarCoordenada(posicao);
	}
	
	public boolean verificarPosicao(int x, int y) {
		return this.posicao.verificarCoordenada(x, y);
	}

}
