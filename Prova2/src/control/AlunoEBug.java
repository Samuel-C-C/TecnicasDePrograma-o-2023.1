package control;

/**
 * Representa os objetos de Aluno e Bug
 * 
 * @author Samuel
 */
public abstract class AlunoEBug extends Elemento {
	
	/**
	 * Valor em pontos que um Robo ganha ao encontrar esse {@code AlunoEBug}
	 */
	private int valorPontos;
	
	/**
	 * Diz se já foi encontrado por um Robo
	 * 
	 * @see Robo
	 */
	private boolean encontrado;
	
	/**
	 * Cria um AlunoEBug na posição (x, y) com valor de pontos {@code valorPontos}
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * @param valorPontos numero de pontos que vale esse {@code AlunoEBug}
	 * 
	 * @see Elemento#x
	 * @see Elemento#y
	 * @see AlunoEBug#valorPontos
	 */
	public AlunoEBug(int x, int y, int valorPontos) {
		super(x, y);
		this.valorPontos = valorPontos;
	}
	
	/**
	 * Retorna o valor de pontos do aluno ou bug
	 * 
	 * @return o valor de pontos do aluno ou bug
	 * 
	 * @see AlunoEBug#valorPontos
	 */
	public int getValorPontos() {
		return valorPontos;
	}
	
	/**
	 * Diz se foi encontrado
	 * 
	 * @return {@code true} se o Aluno ou Bug já foi encontrado, caso contrário, {@code false}
	 * 
	 * @see AlunoEBug#encontrado
	 */
	public boolean isEncontrado() {
		return encontrado;
	}
	
	/**
	 * Define {@code encontrado} como {@code true}
	 * 
	 * @see AlunoEBug#encontrado
	 */
	public void encontrar() {
		encontrado = true;
	}
	
	/**
	 * Não faz nada, pois Alunos ou Bugs não podem se mover
	 */
	public final void setPosicao(int x, int y) {
		;
	}
	
	/**
	 * Diz se é um Aluno
	 * 
	 * @return {@code true} se for um Aluno, caso contrário, {@code false}
	 */
	public abstract boolean isAluno();
	
	/**
	 * Diz se é um Bug
	 * 
	 * @return {@code true} se for um Bug, caso contrário, {@code false}
	 */
	public abstract boolean isBug();
	
}
