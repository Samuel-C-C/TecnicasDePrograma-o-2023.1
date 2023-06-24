package control;

import java.util.ArrayList;

import module.RecordeJogoDAO;
import view.PainelControleRobos;
import view.TelaJogo;

/**
 * classe que controla o jogo
 * 
 * @author Samuel
 */
public class JogoProva2 {
	
	/**
	 * Versão do jogo
	 */
	private static final String VERSAO = "1.0";
	
	/**
	 * A tela do jogo, serve de interface para o jogador
	 * 
	 * @see TelaJogo
	 */
	private TelaJogo telaJogo;
	
	/**
	 * O jogador do jogo
	 * 
	 * @see Jogador
	 */
	private Jogador jogador;
	
	/**
	 * O tabuleiro do jogo
	 * 
	 * @see Tabuleiro
	 */
	private Tabuleiro tabuleiro;

	/**
	 * Um {@code ArrayList} de todos os recordes de partidas passadas
	 * 
	 * @see ArrayList
	 * @see RecordeJogo
	 */
	private ArrayList<RecordeJogo> recordes;
	
	/**
	 * Conta o numero de Rodadas
	 */
	private int numeroRodadas;
	
	/**
	 * Começa o jogo, carrega os recordes de um arquivo de texto
	 */
	public JogoProva2() {
		this.telaJogo = new TelaJogo(this);
		
		RecordeJogoDAO acessoDados = new RecordeJogoDAO();
		recordes = acessoDados.carregar();
		numeroRodadas = -1;
	}
	
	/**
	 * Retorna a versão do jogo
	 * 
	 * @return a versão do jogo
	 * 
	 * @see JogoProva2#VERSAO
	 */
	public static String getVersao() {
		return VERSAO;
	}
	
	/**
	 * Retorna o jogador do jogo
	 * 
	 * @return {@code Jogador} do jogo
	 * 
	 * @see Jogador
	 */
	public Jogador getJogador() {
		return jogador;
	}

	/**
	 * Retorna o tabuleiro do jogo, para que classes externas possam acessar o Tabuleiro
	 * 
	 * @return {@code Tabuleiro} do jogo
	 * 
	 * @see Tabuleiro
	 */
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	/**
	 * Retorna o numero de Rodadas
	 * 
	 * @return o número de Rodadas
	 * 
	 * @see JogoProva2#numeroRodadas
	 */
	public int getNumeroRodadas() {
		return numeroRodadas;
	}
	
	/**
	 * Passa para a proxima Rodada
	 */
	public void passarProximaRodada() {
		numeroRodadas++;
		tabuleiro.reiniciarRobos();
	}
	
	/**
	 * Atualiza a pontuação do Jogador para ser a soma da pontuação dos 3 robos
	 * 
	 * @see Jogador#pontuacao
	 * @see Robo#pontos
	 */
	public void updateJogadorPontos() {
		int somaPontuacaoRobos = 0;
		
		for (Robo robo : tabuleiro.getRobos()) {
			somaPontuacaoRobos += robo.getPontos();
		}
		
		jogador.setPontuacao(somaPontuacaoRobos);
	}
	
	/**
	 * Coloca o robo selecionado no painel de controle de robos da tela do jogo, na posição (x, y)
	 * 
	 * @param x posição X
	 * @param y posiçãi Y
	 * 
	 * @see PainelControleRobos#getRoboSelecionado()
	 */
	public void colocarRoboTabuleiro(int x, int y) {
		Robo roboSelecionado = telaJogo.getPainelControleRobos().getRoboSelecionado();
		roboSelecionado.setPosicao(x, y);
		telaJogo.getPainelGrade().update();
		
		telaJogo.getPainelGrade().desabilitarBotoes();
		telaJogo.getPainelControleRobos().habilitarBotoes();
	}
	
	/**
	 * Tirar os robos do tabuleiro e resetar os botões de controle de robo
	 * 
	 * @see PainelControleRobos#botoesRobos
	 */
	public void resetarBotoesRobos() {
		getTabuleiro().reiniciarRobos();
		telaJogo.getPainelGrade().update();
		telaJogo.getPainelControleRobos().habilitarBotoes();
	}
	
	/**
	 * Vai prosseguir o jogo fazendo todo robo verificar a celula e mostrar os resultados
	 * 
	 * @see Robo#verificarCelula()
	 */
	public void verificarRodada() {
		tabuleiro.robosVerificarCelulas();
		updateJogadorPontos();
		passarProximaRodada();
		telaJogo.getPainelGrade().update();
		telaJogo.getPainelControleRobos().updateInformacoes();
		telaJogo.getPainelControleRobos().habilitarBotoes();
		
		if (tabuleiro.getNumeroAlunosResgatados() == tabuleiro.getNumeroAlunosTotal() || tabuleiro.getNumberCelulasVazias() == 0) {
			telaJogo.finalizarPartida();
		}
	}

	/**
	 * Começa uma nova partida dado o nome do jogador
	 * 
	 * @param nomeJogador nome do jogador
	 */
	public void comecarNovaPartida() {
		jogador = new Jogador(telaJogo.getPainelPrincipal().getNomeJogador());
		tabuleiro = new Tabuleiro();
		numeroRodadas = 0;

		telaJogo.mudarParaModoJogo();
	}
	
	/**
	 * Termina a partida e recebe o numero de rodadas para salvar o recorde da partida
	 * 
	 * @param numeroRodadas numero de rodadas
	 */
	public void terminarPartida() {
		salvar();
		
		telaJogo.sairModoJogo();
		
		jogador = null;
		tabuleiro = null;
		
		telaJogo.abrirTelaRelatorio();
	}
	
	/**
	 * Retorna uma matriz de objetos para a tabela de recordes
	 * 
	 * @return a matriz de dados dos recordes
	 * 
	 * @see JogoProva2#recordes
	 */
	public Object[][] getDadosRecordes() {
		int numeroLinhas = recordes.size();
		
		Object[][] dados = new Object[numeroLinhas][9];
		
		for (int i = 0; i < numeroLinhas; i++) {
			dados[i] = recordes.get(i).getDados();
		}
		
		return dados;
	}
	
	/**
	 * Aalva o recorde de uma partida no {@link JogoProva2#recordes}
	 * e salva os recordes num arquivo de texo
	 * 
	 * @param numeroRodadas numero de rodadas
	 */
	private void salvar() {
		recordes.add(new RecordeJogo(jogador, numeroRodadas, tabuleiro));
		
		RecordeJogoDAO acessoDados = new RecordeJogoDAO();
		acessoDados.salvar(recordes);
		
		numeroRodadas = -1;
	}

}
