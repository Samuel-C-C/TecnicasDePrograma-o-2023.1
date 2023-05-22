package robo;

import exceptions.OutOfPlaneException;
import tabuleiro.*;

public final class Andador extends Robo {

	public Andador(Celula celula) throws Exception {
		super(celula, "Andador", -1, 'W');
	}

	public Andador(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Andador(int x, int y, Plano plano) throws Exception {
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
