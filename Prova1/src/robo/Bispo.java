package robo;

import exceptions.OutOfPlaneException;
import tabuleiro.*;

public final class Bispo extends Robo {

	public Bispo(Celula celula) throws Exception {
		super(celula, "Bispo", 2, 'B');
	}

	public Bispo(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Bispo(int x, int y, Plano plano) throws Exception {
		this(new Coordenada(x, y), plano);
	}

	public void avancar(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(-numeroCasas, -numeroCasas);
		
		this.mover(novaPosicao);
	}

	public void retroceder(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(numeroCasas, numeroCasas);
		
		this.mover(novaPosicao);
	}

}
