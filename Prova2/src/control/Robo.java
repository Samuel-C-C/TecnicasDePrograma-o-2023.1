package control;

/**
 * Representam os Robos que são usados pelo Jogador
 * 
 * @author Samuel
 * 
 * @see Elemento
 */
public class Robo extends Elemento {
	
	/**
	 * Número de robos
	 */
	private static int numeroRobos = 0;
	
	/**
	 * O Tabuleiro a qual esse robo pertence
	 * 
	 * @see Tabuleiro
	 */
	private Tabuleiro tabuleiro;
	
	/**
	 * A quantidade de pontos do robo
	 * 
	 * <p>sempre começa em 0</p>
	 */
	private int pontos;
	
	/**
	 * O Nome do robo
	 */
	private String nome;
	
	/**
	 * O ID do robo
	 */
	private int id;

	/**
	 * Cria um Robo na posição (x, y) com nome dado pelo parametro
	 * 
	 * @param nome nome do robo
	 * @param x posição X
	 * @param y posição Y
	 * 
	 * @see Robo#nome
	 * @see Elemento#x
	 * @see Elemento#y
	 */
	public Robo(Tabuleiro tabuleiro, String nome, int x, int y) {
		super(x, y);
		
		pontos = 0;
		this.tabuleiro = tabuleiro;
		this.nome = nome;
		
		this.id = numeroRobos + 1;
		numeroRobos++;
	}
	
	/**
	 * Retorna a quantidade de pontos do Robo
	 * 
	 * @return a quantidade de pontos do Robo
	 * 
	 * @see Robo#pontos
	 */
	public int getPontos() {
		return pontos;
	}
	
	/**
	 * Retorna o nome do robo
	 * 
	 * @return o nome do robo
	 * 
	 * @see Robo#nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna o ID do robo
	 * 
	 * @return o ID do robo
	 * 
	 * @see Robo#id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Adiciona {@code quantidade} de pontos para o robo
	 * 
	 * @param quantidade quantidade de pontos a ser adicionada
	 * 
	 * @see Robo#pontos
	 */
	public void addPontos(int quantidade) {
		pontos += quantidade;
	}
	
	/**
	 * Colocar o Robo numa posição fora do tabuleiro
	 * 
	 * @see Tabuleiro
	 */
	public void colocarForaTabuleiro() {
		setPosicao(0, 0);
	}
	
	/**
	 * Faz o robo verificar a propria celula e 
	 * ganhar ou perder pontos se encontrar um {@code AlunoEBug}
	 * 
	 * @see Celula#visitada
	 * @see AlunoEBug#encontrado
	 * @see AlunoEBug#valorPontos
	 */
	public void verificarCelula() {
		tabuleiro.getCelula(getX(), getY()).visitar();
		AlunoEBug alunoOuBug = tabuleiro.getAlunoOuBug(getX(), getY());
		
		if (alunoOuBug != null) {
			addPontos(alunoOuBug.getValorPontos());
			alunoOuBug.encontrar();
		}
	}

	/**
	 * Diz se o Robo está dentro do Tabuleiro
	 * 
	 * @return {@code true} se a posição do robo está dentro do tabuleiro, caso contrário, {@code false}
	 */
	public boolean isPosicionado() {
		return 1 <= getX() && getX() <= tabuleiro.getNumeroDeColunas() && 1 <= getY() && getY() <= tabuleiro.getNumeroDeLinhas();
	}

}
