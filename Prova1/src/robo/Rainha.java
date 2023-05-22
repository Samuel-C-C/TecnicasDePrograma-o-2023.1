package robo;

import exceptions.OutOfPlaneException;
import tabuleiro.*;

public final class Rainha extends Robo {

	public Rainha(Celula celula) throws Exception {
		super(celula, "Rainha", 4, 'Q');
	}

	public Rainha(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Rainha(int x, int y, Plano plano) throws Exception {
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
