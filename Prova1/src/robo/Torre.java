package robo;

import exceptions.OutOfPlaneException;
import tabuleiro.*;

public final class Torre extends Robo {

	public Torre(Celula celula) throws Exception {
		super(celula, "Torre", 2, 'R');
	}

	public Torre(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Torre(int x, int y, Plano plano) throws Exception {
		this(new Coordenada(x, y), plano);
	}

	public void avancar(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(0, -numeroCasas);
		
		this.mover(novaPosicao);
	}

	public void retroceder(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(0, numeroCasas);
		
		this.mover(novaPosicao);
	}

}
