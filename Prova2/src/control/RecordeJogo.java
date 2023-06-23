package control;

/**
 * A classe {@code Recorde} serve para guardar informações de uma partida que terminou
 */
public class RecordeJogo {
	
	/**
	 * Nome do Jogador
	 * 
	 * @see Jogador
	 */
	private String nomeJogador;

	/**
	 * A duração em rodadas da partida
	 */
	private int numeroRodadas;
	
	/**
	 * Número de celulas não visitadas ao fim da partida
	 */
	private int numeroCelulasVazias;
	
	/**
	 * Pontuacao final do Jogador
	 * 
	 * @see Jogador
	 */
	private int pontucao;
	
	/**
	 * Número de alunos resgatados ao fim da partida
	 * 
	 * @see Aluno
	 */
	private int numeroAlunosResgatados;
	
	/**
	 * Número de bugs encontrados ao fim da partida
	 * 
	 * @see Bug
	 */
	private int numeroBugsEncontrados;
	
	/**
	 * quantidade de pontos do Robo 1
	 * 
	 * @see Robo
	 */
	private int pontuacaoRobo1;
	
	/**
	 * quantidade de pontos do Robo 2
	 * 
	 * @see Robo
	 */
	private int pontuacaoRobo2;
	
	/**
	 * quantidade de pontos do Robo 3
	 * 
	 * @see Robo
	 */
	private int pontuacaoRobo3;
	
	/**
	 * Cria um Recorde de um jogo, dados os parametros ao final da partida
	 * 
	 * @param jogador o jogador
	 * @param numeroRodadas o número de rodadas
	 * @param tabuleiro o tabuleiro
	 * 
	 * @see Jogador
	 * @see Tabuleiro
	 */
	public RecordeJogo(Jogador jogador, int numeroRodadas, Tabuleiro tabuleiro) {
		nomeJogador = jogador.getNome();
		this.numeroRodadas = numeroRodadas;
		numeroCelulasVazias = tabuleiro.getNumberCelulasVazias();
		pontucao = jogador.getPontuacao();
		numeroAlunosResgatados = tabuleiro.getNumeroAlunosResgatados();
		numeroBugsEncontrados = tabuleiro.getNumeroBugsEncontrados();
		pontuacaoRobo1 = tabuleiro.getRobo(1).getPontos();
		pontuacaoRobo2 = tabuleiro.getRobo(2).getPontos();
		pontuacaoRobo3 = tabuleiro.getRobo(3).getPontos();
	}
	
	/**
	 * Cria um Recorde de um Jogo a partir de uma string de formação
	 * 
	 * @param stringDeFormacao string de formação usada para criar o Recorde
	 */
	public RecordeJogo(String stringDeFormacao) throws IllegalArgumentException {
		
		String[] pedados = stringDeFormacao.split(";");
		
		if (pedados.length >= 9) {
			nomeJogador = pedados[0];
			
			try {
				numeroRodadas = Integer.parseInt(pedados[1]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("número de rodadas não pode ser convertido para inteiro");
			}
			
			try {
				numeroCelulasVazias = Integer.parseInt(pedados[2]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("número de celulas vazias não pode ser convertido para inteiro");
			}
			
			try {
				pontucao = Integer.parseInt(pedados[3]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("pontuação não pode ser convertido para inteiro");
			}
			
			try {
				numeroAlunosResgatados = Integer.parseInt(pedados[4]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("número de alunos resgatados não pode ser convertido para inteiro");
			}
			
			try {
				numeroBugsEncontrados = Integer.parseInt(pedados[5]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("número de bugs encontrados não pode ser convertido para inteiro");
			}
			
			try {
				pontuacaoRobo1 = Integer.parseInt(pedados[6]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("pontuacao do robo 1 não pode ser convertido para inteiro");
			}
			
			try {
				pontuacaoRobo2 = Integer.parseInt(pedados[7]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("pontuacao do robo 2 não pode ser convertido para inteiro");
			}
			
			try {
				pontuacaoRobo3 = Integer.parseInt(pedados[8]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("pontuacao do robo 3 não pode ser convertido para inteiro");
			}
			
		} else {
			throw new IllegalArgumentException("sem partes suficientes");
		}
		
	}
	
	/**
	 * Usado para mostrar uma tabela em {@code JanelaRecordes}
	 * 
	 * @return um array de Objetos que representa uma linha de uma tabela
	 */
	public Object[] getDados() {
		Object[] linha = new Object[9];
		
		linha[0] = nomeJogador;
		linha[1] = numeroRodadas;
		linha[2] = numeroCelulasVazias;
		linha[3] = pontucao;
		linha[4] = numeroAlunosResgatados;
		linha[5] = numeroBugsEncontrados;
		linha[6] = pontuacaoRobo1;
		linha[7] = pontuacaoRobo2;
		linha[8] = pontuacaoRobo3;
		
		return linha;
	}
	
	public String getStringDeFormacao() {
		String stringDeFormacao = "";
		stringDeFormacao += nomeJogador + ";";
		stringDeFormacao += numeroRodadas + ";";
		stringDeFormacao += numeroCelulasVazias + ";";
		stringDeFormacao += pontucao + ";";
		stringDeFormacao += numeroAlunosResgatados + ";";
		stringDeFormacao += numeroBugsEncontrados + ";";
		stringDeFormacao += pontuacaoRobo1 + ";";
		stringDeFormacao += pontuacaoRobo2 + ";";
		stringDeFormacao += pontuacaoRobo3 + ";";
		return stringDeFormacao;
	}

}
