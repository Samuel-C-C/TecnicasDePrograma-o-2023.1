package robo;

import exceptions.OutOfPlaneException;
import tabuleiro.*;

public final class Rei extends Robo {

	public Rei(Celula celula) throws Exception {
		super(celula, "Rei", 4, 'K');
	}

	public Rei(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Rei(int x, int y, Plano plano) throws Exception {
		this(new Coordenada(x, y), plano);
	}

	public void avancar(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(numeroCasas, -numeroCasas);
		
		this.mover(novaPosicao);
	}

	public void retroceder(int numeroCasas) throws OutOfPlaneException {
		Coordenada novaPosicao = this.celula.getPosicao().somar(-numeroCasas, numeroCasas);
		
		this.mover(novaPosicao);
	}

}
