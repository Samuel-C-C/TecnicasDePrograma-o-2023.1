package control;

/**
 * Representam os Bugs no tabuleiro
 * 
 * @author Samuel
 */
public final class Bug extends AlunoEBug {

	/**
	 * Cria um bug na posição (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * 
	 * @see Elemento#x
	 * @see Elemento#y
	 */
	public Bug(int x, int y) {
		super(x, y, -15);
	}

	/**
	 * Retorna {@code false}
	 * 
	 * @return {@code false}
	 */
	public boolean isAluno() {
		return false;
	}

	/**
	 * Retorna {@code true}
	 * 
	 * @return {@code true}
	 */
	public boolean isBug() {
		return true;
	}
	
}
