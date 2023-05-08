package questao18;

public class Moeda extends Entidade {

	public Moeda(Vetor2D posicao) {
		super(posicao, '$');
	}

	public Moeda(int x, int y) {
		this(new Vetor2D(x, y));
	}

}
