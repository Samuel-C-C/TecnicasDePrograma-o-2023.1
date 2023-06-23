package control;

/**
 * Representa as coisas que podem estar no {@code Tabuleiro}
 * 
 * @author Samuel
 */
public abstract class Elemento {
	
	/**
	 * a posicao X no tabuleiro
	 * 
	 * <p> x = 1 significa a primeira coluna </p>
	 */
	private int x;
	
	/**
	 * a posição Y no tabuleiro
	 * 
	 * <p> y = 1 significa a primeira linha </p>
	 */
	private int y;
	
	/**
	 * Cria um novo Elemento com posição (x, y)
	 * 
	 * @param x posicao X
	 * @param y posicao Y
	 * 
	 * @see Elemento#x
	 * @see Elemento#y
	 */
	public Elemento(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return a posição X do elemento
	 * 
	 * @see Elemento#x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return a posição Y do elemento
	 * 
	 * @see Elemento#y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * verifica se a posição do elemento é igual a posição especificada pelos parametros
	 * 
	 * @param x posição X a verificar
	 * @param y posição Y a verificar
	 * @return {@code true} se os valores (x, y) forem iguais a posição do elemento, 
	 * caso contrário, retorna {@code false}
	 * 
	 * @see Elemento#x
	 * @see Elemento#y
	 */
	public boolean verificarPosicao(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	/**
	 * verifica se a posição do elemento é igual a outro elemento
	 * 
	 * @param outroElemento o elemento a verificar a posição
	 * 
	 * @return {@code true} se ambos os elementos tiverem a mesma posição,
	 * caso contrário, {@code false}
	 */
	public boolean verificarPosicaoElemento(Elemento outroElemento) {
		return verificarPosicao(outroElemento.getX(), outroElemento.getY());
	}
	
	/**
	 * Define uma nova posição para o Elemento
	 * 
	 * @param x nova coluna no tabuleiro
	 * @param y nova linha no tabuleiro
	 * 
	 * @see Elemento#x
	 * @see Elemento#y
	 */
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
