package control;

/**
 * Representam os Alunos no tabuleiro
 * 
 * @author Samuel
 */
public final class Aluno extends AlunoEBug {

	/**
	 * Cria um Aluno na posição (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * 
	 * @see Elemento#x
	 * @see Elemento#y
	 */
	public Aluno(int x, int y) {
		super(x, y, 10);
	}

	/**
	 * @return {@code true}
	 */
	public boolean isAluno() {
		return true;
	}

	/**
	 * @return {@code false}
	 */
	public boolean isBug() {
		return false;
	}
	
}
