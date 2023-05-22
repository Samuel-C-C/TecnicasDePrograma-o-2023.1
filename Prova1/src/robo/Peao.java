package robo;

import exceptions.OutOfPlaneException;
import tabuleiro.*;

public final class Peao extends Robo {

	public Peao(Celula celula) throws Exception {
		super(celula, "Peão", 1, 'P');
	}

	public Peao(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Peao(int x, int y, Plano plano) throws Exception {
		this(new Coordenada(x, y), plano);
	}

	public void avancar(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(numeroCasas, 0);
		
		this.mover(novaPosicao);
	}

	public void retroceder(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(-numeroCasas, 0);
		
		this.mover(novaPosicao);
	}

}
