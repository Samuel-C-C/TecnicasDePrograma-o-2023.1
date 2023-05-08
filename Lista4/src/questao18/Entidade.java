package questao18;

public class Entidade {
	
	private Vetor2D posicao;
	private char simbolo;
	
	private Plano plano;
	
	public Vetor2D getPosicao() {
		return posicao;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
	
	public Plano getPlano() {
		return plano;
	}
	
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	public Entidade(Vetor2D posicao, char simbolo) {
		this.posicao = posicao;
		this.simbolo = simbolo;
	}
	
	public Entidade(int x, int y, char simbolo) {
		this(new Vetor2D(x, y), simbolo);
	}
	
	public void mover(Vetor2D novaPosicao) {
		this.posicao = novaPosicao;
		
		if (plano != null)
			this.plano.atualizarPlano();
	}
	
	public void mover(int x, int y) {
		this.mover(new Vetor2D(x, y));
	}

}
