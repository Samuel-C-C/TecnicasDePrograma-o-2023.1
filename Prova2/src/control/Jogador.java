package control;

/**
 * A Classe {@code Jogador} representa o jogador e tem um nome e pontuação.
 */
public class Jogador {
	
	/**
	 * Nome do jogador
	 */
	private String nome;
	
	/**
	 * Quantidade de pontos do jogador, deve ser igual a soma da pontuacao de todos os robos
	 */
	private int pontuacao;
	
	/**
	 * Cria um jogador com nome {@code nome} e pontuação 0
	 * 
	 * @param nome : nome do jogador
	 */
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o nome do Jogador
	 * 
	 * @see Jogador#nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna a pontuação do jogador
	 * 
	 * @see Jogador#pontuacao
	 */
	public int getPontuacao() {
		return pontuacao;
	}
	
	/**
	 * Define a pontuação do jogador
	 * 
	 * @param pontuacao : pontuacao a ser definida
	 * @see Jogador#pontuacao
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
