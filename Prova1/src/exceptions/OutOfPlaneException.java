package exceptions;

import tabuleiro.Coordenada;
import tabuleiro.Plano;

public class OutOfPlaneException extends Exception {
	private static final long serialVersionUID = 75438943781L;
	
	public OutOfPlaneException(Coordenada posicao, Plano plano) {
		super("(" + posicao.x + ", " + posicao.y + ") is out of the borders of the plane" +
				" which has a size of (" + plano.getTamanhoX() + ", " + 
				plano.getTamanhoY() + ")");
	}

}
