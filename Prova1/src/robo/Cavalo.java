package robo;

import exceptions.OutOfPlaneException;
import tabuleiro.*;

public final class Cavalo extends Robo {

	public Cavalo(Celula celula) throws Exception {
		super(celula, "Cavalo", 2, 'N');
	}

	public Cavalo(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Cavalo(int x, int y, Plano plano) throws Exception {
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
