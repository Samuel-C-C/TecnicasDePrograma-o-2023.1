package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
//import javax.swing.JPanel;

import control.JogoProva2;

/**
 * A tela principal do jogo
 * 
 * @author Samuel
 * 
 * @see JFrame
 */
public class TelaJogo extends JFrame {

	private static final long serialVersionUID = 8398625067733596004L;
	
	/**
	 * serve para acessar métodos, dados da classe {@code JogoProva2} e retornar valores
	 * 
	 * @see JogoProva2
	 */
	private JogoProva2 controleJogo;
	
	/**
	 * diz se a tela está em modo de jogo ou não
	 * 
	 * <p> estar em modo de jogo significa ter o tabuleiro, botões e outras coisas relacionadas
	 * com o jogo a mostra </p>
	 */
	private boolean modoJogo;
	
	/**
	 * o painel de cima que tem o botão de iniciar jogo, caixa de texto com o nome do jogador
	 * e o botão que abre a tela de relatorio
	 * 
	 * @see PainelPrincipal
	 * @see TelaRelatorio
	 */
	private PainelPrincipal painelPrincipal;
	
	/**
	 * o painel com as informações relevantes para o jogo e botões para controlar os robos
	 * 
	 * @see PainelControleRobos
	 */
	private PainelControleRobos painelControleRobos;
	
	/**
	 * o painel com o tabuleiro
	 * 
	 * @see PainelGrade
	 */
	private PainelGrade painelGrade;
	
	/**
	 * cria a tela para jogar o jogo
	 */
	public TelaJogo(JogoProva2 controleJogo) {
		this.setSize(800, 137);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.controleJogo = controleJogo;
		modoJogo = false;
		painelPrincipal = new PainelPrincipal(this);
		painelControleRobos = new PainelControleRobos(this);
		painelGrade = new PainelGrade(this);
		
		this.setLayout(new BorderLayout());
		this.add(painelPrincipal, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	/**
	 * Retorna o objeto controleJogo para que paineis dentro do {@code TelaJogo} possam
	 * usar seus métodos
	 * 
	 * @return {@code JogoProva2} relacionado com essa tela
	 * 
	 * @see JogoProva2
	 */
	public JogoProva2 getControleJogo() {
		return controleJogo;
	}
	
	/**
	 * Retorna o {@code PainelGrade} dentro dessa tela
	 * 
	 * @return {@code PainelGrade} dentro dessa tela
	 * 
	 * @see PainelGrade
	 */
	public PainelGrade getPainelGrade() {
		return painelGrade;
	}
	
	/**
	 * Retorna o {@code PainelControleRobos} dentro dessa tela
	 * 
	 * @return {@code PainelControleRobos} dentro dessa tela
	 * 
	 * @see PainelControleRobos
	 */
	public PainelControleRobos getPainelControleRobos() {
		return painelControleRobos;
	}
	
	/**
	 * Retorna o {@code PainelPrincipal} dentro dessa tela
	 * 
	 * @return {@code PainelPrincipal} dentro dessa tela
	 * 
	 * @see PainelPrincipal
	 */
	public PainelPrincipal getPainelPrincipal() {
		return painelPrincipal;
	}
	
	/**
	 * muda a tela para o modo de jogo
	 * 
	 * @see TelaJogo#modoJogo
	 */
	public void mudarParaModoJogo() {
		if (!modoJogo) {
			modoJogo = true;
			
			painelPrincipal.setBotaoJogarEnable(false);
			
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout());
			this.add(painelPrincipal, BorderLayout.NORTH);
			this.add(painelControleRobos, BorderLayout.EAST);
			this.add(painelGrade, BorderLayout.WEST);
			
			updateUI();
		}
	}
	
	/**
	 * volta a tela para o modo como era assim que é criada
	 * 
	 * @see TelaJogo#modoJogo
	 */
	public void sairModoJogo() {
		if (modoJogo) {
			modoJogo = false;
			
			painelPrincipal.setBotaoJogarEnable(true);
			
			this.setSize(800, 137);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout());
			this.add(painelPrincipal, BorderLayout.CENTER);
			
			updateUI();
		}
	}
	
	/**
	 * Atualiza a UI da tela
	 */
	private void updateUI() {
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
	
	/**
	 * abre uma tela com uma tabela dos recordes de partidas anteriores
	 */
	public void abrirTelaRelatorio() {
		new TelaRelatorio(this);
	}

}
