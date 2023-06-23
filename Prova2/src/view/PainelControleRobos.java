package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Image;
import java.util.ArrayList;

//import javax.swing.Icon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Aluno;
import control.Bug;
import control.Jogador;
import control.Robo;
import control.Tabuleiro;

/**
 * O Painel que mostra informações relevantes do jogo, além de servir junto do {@link PainelGrade}
 * para jogar o jogo
 * 
 * @author Samuel
 * 
 * @see JPanel
 */
public class PainelControleRobos extends JPanel {

	private static final long serialVersionUID = 2882332004367745507L;
	
	/**
	 * Referencia a {@code TelaJogo} a qual esse painel pertence
	 * 
	 * @see TelaJogo
	 */
	private TelaJogo telaJogo;
	
	/**
	 * O {@code JLabel} com a pontuação total do jogador
	 * 
	 * @see JLabel
	 * @see Jogador
	 */
	private JLabel labelPontuacao;
	
	/**
	 * O {@code JLabel} com a quantidade de alunos resgatados
	 * 
	 * @see JLabel
	 * @see Aluno
	 */
	private JLabel labelAlunos;
	
	/**
	 * O {@code JLabel} com a quantidade de bugs encontrados
	 * 
	 * @see JLabel
	 * @see Bug
	 */
	private JLabel labelBugs;
	
	/**
	 * {@code ArrayList} de {@code JLabel} com a quantidade de pontos de cada {@code Robo}
	 * 
	 * @see ArrayList
	 * @see JLabel
	 * @see Robo
	 */
	private ArrayList<JLabel> labelsPontuacaoRobos;
	
	/**
	 * {@code ArrayList} de {@code BotaoControleRobo} que controlam cada {@code Robo}
	 * 
	 * @see ArrayList
	 * @see BotaoControleRobo
	 * @see Robo
	 */
	private ArrayList<BotaoControleRobo> botoesRobos;
	
	/**
	 * {@code JButton} que reseta a posição de cada {@code Robo} no {@code Tabuleiro}
	 * 
	 * @see JButton
	 * @see Robo
	 * @see Tabuleiro
	 */
	private JButton botaoResetar;
	
	/**
	 * {@code JButton} que verifica se cada {@code Robo} colodao no {@code Tabuleiro}
	 * encontrou algum {@code Aluno} ou {@code Bug} e começa a proxima rodada
	 * 
	 * @see JButton
	 * @see Robo
	 * @see Tabuleiro
	 * @see Aluno
	 * @see Bug
	 */
	private JButton botaoProsseguir;
	
	/**
	 * {@code JButton} que termina a partida
	 * 
	 * @see JButton
	 */
	private JButton botaoSair;
	
	/**
	 * Cria o painel usando uma {@code TelaJogo}
	 * 
	 * @param telaJogo a tela a qual esse painel pertence
	 * 
	 * @see TelaJogo
	 */
	public PainelControleRobos(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
		
		this.setPreferredSize(new Dimension(280, 500));
		this.setLayout(new GridLayout(7,1));
		
		JPanel painelPontuacao = new JPanel();
		painelPontuacao.setLayout(new BorderLayout());
		labelPontuacao = new JLabel("PONTUAÇÃO: 0");
		labelPontuacao.setHorizontalAlignment(JLabel.CENTER);
		painelPontuacao.add(labelPontuacao, BorderLayout.CENTER);
		painelPontuacao.add(labelPontuacao);
		this.add(painelPontuacao);
		
		JPanel painelAlunosBugs = new JPanel();
		painelAlunosBugs.setLayout(new GridLayout(1, 2));
		labelAlunos = new JLabel("ALUNOS: 0");
		labelAlunos.setHorizontalAlignment(JLabel.CENTER);
		painelAlunosBugs.add(labelAlunos);
		labelBugs = new JLabel("BUGS: 0");
		labelBugs.setHorizontalAlignment(JLabel.CENTER);
		painelAlunosBugs.add(labelBugs);
		this.add(painelAlunosBugs);
		
		JPanel painelPontuacaoRobos = new JPanel();
		painelPontuacaoRobos.setLayout(new GridLayout(1, 3));
		labelsPontuacaoRobos = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			JLabel labelPontuacaoRobo = new JLabel("ROBO " + (i + 1) + ": 0");
			labelPontuacaoRobo.setHorizontalAlignment(JLabel.CENTER);
			
			labelsPontuacaoRobos.add(labelPontuacaoRobo);
			painelPontuacaoRobos.add(labelPontuacaoRobo);
		}
		this.add(painelPontuacaoRobos);
		
		JPanel painelBotoesRobos = new JPanel();
		painelBotoesRobos.setLayout(new GridLayout(1, 3));
		botoesRobos = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			BotaoControleRobo botao = new BotaoControleRobo(this, i+1);
			botoesRobos.add(botao);
			painelBotoesRobos.add(botao);
		}
		this.add(painelBotoesRobos);
		
		JPanel painelBotaoResetar = new JPanel();
		painelBotaoResetar.setLayout(new BorderLayout());
		botaoResetar = new JButton("Resetar");
		botaoResetar.addActionListener(new AcaoResetar());
		botaoResetar.setBackground(new Color(0xb6b6b6));
		painelBotaoResetar.add(botaoResetar);
		this.add(painelBotaoResetar);
		
		JPanel painelBotaoProsseguir = new JPanel();
		painelBotaoProsseguir.setLayout(new BorderLayout());
		botaoProsseguir = new JButton("Prosseguir");
		botaoProsseguir.addActionListener(new AcaoProsseguir());
		botaoProsseguir.setBackground(new Color(0xb6b6b6));
		painelBotaoProsseguir.add(botaoProsseguir);
		this.add(painelBotaoProsseguir);
		
		JPanel painelBotaoSairJogo = new JPanel();
		painelBotaoSairJogo.setLayout(new BorderLayout());
		botaoSair = new JButton("Terminar Jogo");
		botaoSair.addActionListener(new AcaoSair());
		botaoSair.setBackground(new Color(0xb6b6b6));
		painelBotaoSairJogo.add(botaoSair);
		this.add(painelBotaoSairJogo);
	}
	
	/**
	 * Retorna a tela do Jogo para que botões dentro do painel possam
	 * acessar seus métodos
	 * 
	 * @return a {@code TelaJogo} a qual esse painel pertence
	 * 
	 * @see TelaJogo
	 */
	public TelaJogo getTelaJogo() {
		return telaJogo;
	}
	
	/**
	 * Retorna se qualquer botao foi selecionado
	 * 
	 * @return se qualquer botao foi selecionado
	 * 
	 * @see BotaoControleRobo#selecionado
	 */
	public boolean isBotaoSelecionado() {
		for (BotaoControleRobo botao : botoesRobos) {
			if (botao.isSelecionado()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Retorna o robo com o nome "Robo X" onde X é o número do botão selecionado
	 * 
	 * @return um Robo relacionado com o botão selecionado, {@code null} se não houver robo
	 * relacionado com o botão
	 * 
	 * @see BotaoCelulaGrade
	 */
	public Robo getRoboSelecionado() {
		for (BotaoControleRobo botao : botoesRobos) {
			if (botao.isSelecionado()) {
				return botao.getRoboRelacionado();
			}
		}
		
		return null;
	}
	
	/**
	 * Rehabilita os botões de controle de Robo depois de selecionar uma posição para eles na grade
	 * 
	 * @see PainelGrade
	 */
	public void habilitarBotoes() {
		for (BotaoControleRobo botao : botoesRobos) {
			if (!botao.getRoboRelacionado().isPosicionado()) {
				botao.habilitar();
			} else {
				botao.bloquear();
			}
		}
	}
	
	/**
	 * Retorna os botões de controle de Robo
	 * 
	 * @return {@code ArrayList} de {@code BotaoControleRobo} do painel
	 * 
	 * @see ArrayList
	 * @see BotaoControleRobo
	 */
	public ArrayList<BotaoControleRobo> getBotoesRobos() {
		return botoesRobos;
	}
	
	/**
	 * Define a pontuação mostrada em {@link PainelControleRobos#labelPontuacao}
	 * 
	 * @param pontuacao pontuacao a ser escrita
	 * 
	 * @see PainelControleRobos#labelPontuacao
	 */
	private void setPontuacao(int pontuacao) {
		this.labelPontuacao.setText("PONTUAÇÃO: " + pontuacao);
	}
	
	/**
	 * Define o número de alunos mostrado em {@link PainelControleRobos#labelAlunos}
	 * 
	 * @param numeroAlunos número de alunos a ser escrito
	 * 
	 * @see PainelControleRobos#labelAlunos
	 */
	private void setNumeroAlunos(int numeroAlunos) {
		this.labelAlunos.setText("ALUNOS: " + numeroAlunos);
	}
	
	/**
	 * Define o número de bugs mostrado em {@link PainelControleRobos#labelBugs}
	 * 
	 * @param numeroBugs número de bugs a ser escrito
	 * 
	 * @see PainelControleRobos#labelBugs
	 */
	private void setNumeroBugs(int numeroBugs) {
		this.labelBugs.setText("BUGS: " + numeroBugs);
	}
	
	/**
	 * Define a pontuação de um robo em {@link PainelControleRobos#labelsPontuacaoRobos}
	 * 
	 * @param numeroRobo número do robo
	 * @param pontuacao pontuação a ser escrita
	 * 
	 * @see PainelControleRobos#labelsPontuacaoRobos
	 */
	private void setRoboPontuacao(int numeroRobo, int pontuacao) {
		this.labelsPontuacaoRobos.get(numeroRobo - 1).setText("ROBO " + numeroRobo + ": " + pontuacao); 
	}
	
	public void updateInformacoes() {
		int pontuacao = telaJogo.getControleJogo().getJogador().getPontuacao();
		int numeroAlunos = telaJogo.getControleJogo().getTabuleiro().getNumeroAlunosResgatados();
		int numeroBugs = telaJogo.getControleJogo().getTabuleiro().getNumeroBugsEncontrados();
		
		ArrayList<Integer> pontuacaoRobos = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			pontuacaoRobos.add(telaJogo.getControleJogo().getTabuleiro().getRobo(i).getPontos());
		}
		
		setPontuacao(pontuacao);
		setNumeroAlunos(numeroAlunos);
		setNumeroBugs(numeroBugs);
		
		for (int i = 1; i <= 3; i++) {
			setRoboPontuacao(i, pontuacaoRobos.get(i - 1));
		}
	}
	
	/**
	 * Classe do tipo ação que tem seu método executado pelo botao resetar
	 * 
	 * <p>vai tirar os robôs da grade e resetar os botões dos robos</p>
	 * 
	 * @see ActionListener
	 */
	private class AcaoResetar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telaJogo.getControleJogo().resetarBotoesRobos();
		}
	}
	
	/**
	 * Classe do tipo ação que tem seu método executado pelo botao prosseguir
	 * 
	 * <p>vai verificar se alunos ou bugs foram encontrados e começar uma nova rodada</p>
	 * 
	 * @see ActionListener
	 */
	private class AcaoProsseguir implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int numeroRobosPocisionados = telaJogo.getControleJogo().getTabuleiro().verificarNumeroRobosPosicionados();
			int numeroCelulasVazias = telaJogo.getControleJogo().getTabuleiro().getNumberCelulasVazias();
			
			if (numeroRobosPocisionados == 3 || numeroRobosPocisionados == numeroCelulasVazias) {
				telaJogo.getControleJogo().verificarRodada();
			} else {
				JOptionPane.showMessageDialog(telaJogo, "não pode prosseguir, pois há robos não colodados");
			}
		}
	}
	
	/**
	 * Classe do tipo ação que tem seu método executado pelo botao sair
	 * 
	 * <p>vai terminar a partida e chamar a tela relatório</p>
	 * 
	 * @see ActionListener
	 */
	private class AcaoSair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telaJogo.getControleJogo().terminarPartida();
		}
	}
	
}
