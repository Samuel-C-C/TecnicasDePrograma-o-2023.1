package control;

/**
 * Representa uma casa do tabuleiro
 * 
 * @author Samuel
 */
public final class Celula extends Elemento {
	
	/**
	 * diz se a Celula já foi visitada por algum Robo
	 * 
	 * @see Robo
	 */
	private boolean visitada;

	/**
	 * Cria uma nova Celula com posição (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * 
	 * @see Elemento#x
	 * @see Elemento#y
	 */
	public Celula(int x, int y) {
		super(x, y);
		
		visitada = false;
	}
	
	/**
	 * Diz se a celula já foi visitada
	 * 
	 * @return {@code true} se a celula já foi visitada, se não, {@code false}
	 * 
	 * @see Celula#visitada
	 */
	public boolean isVisitada() {
		return visitada;
	}
	
	/**
	 * Define {@code visitada} como {@code true}
	 * 
	 * @see Celula#visitada
	 */
	public void visitar() {
		visitada = true;
	}
	
	/**
	 * Não faz nada, já que celulas não podem se mover
	 */
	public void setPosicao(int x, int y) {
		;
	}

}
