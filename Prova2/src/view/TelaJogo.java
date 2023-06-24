package view;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	 * Serve para acessar métodos, dados da classe {@code JogoProva2} e retornar valores
	 * 
	 * @see JogoProva2
	 */
	private JogoProva2 controleJogo;
	
	/**
	 * Diz se a tela está em modo de jogo ou não
	 * 
	 * <p> estar em modo de jogo significa ter o tabuleiro, botões e outras coisas relacionadas
	 * com o jogo a mostra </p>
	 */
	private boolean modoJogo;
	
	/**
	 * O painel de cima que tem o botão de iniciar jogo, caixa de texto com o nome do jogador
	 * e o botão que abre a tela de relatorio
	 * 
	 * @see PainelPrincipal
	 * @see TelaRelatorio
	 */
	private PainelPrincipal painelPrincipal;
	
	/**
	 * O painel com as informações relevantes para o jogo e botões para controlar os robos
	 * 
	 * @see PainelControleRobos
	 */
	private PainelControleRobos painelControleRobos;
	
	/**
	 * O painel com o tabuleiro
	 * 
	 * @see PainelGrade
	 */
	private PainelGrade painelGrade;
	
	/**
	 * Cria a tela para jogar o jogo
	 */
	public TelaJogo(JogoProva2 controleJogo) {
		this.setSize(800, 137);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Jogo Prova 2 - " + JogoProva2.getVersao());
		this.setIconImage(
				Imagens.ROBO_1.getImagem().
				getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)
				);
		
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
	 * Muda a tela para o modo de jogo
	 * 
	 * @see TelaJogo#modoJogo
	 */
	public void mudarParaModoJogo() {
		if (!modoJogo) {
			modoJogo = true;
			
			painelPrincipal.setBotaoJogarEnable(false);
			painelPrincipal.setCaixaNomeJogadorEnabled(false);
			painelGrade.update();
			painelControleRobos.updateInformacoes();
			
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
	 * Chamado quando todos os alunos foram encontrados
	 * 
	 * <p>serve para evitar que o jogador faça qualquer outra coisa além de terminar a partida
	 * além de avisar que todos os alunos já foram encontrados</p>
	 */
	public void finalizarPartida() {
		JOptionPane.showMessageDialog(this, "Todos os alunos encontrados!");
		painelControleRobos.desabilitarControles();
	}
	
	/**
	 * Volta a tela para o modo como era assim que é criada
	 * 
	 * @see TelaJogo#modoJogo
	 */
	public void sairModoJogo() {
		if (modoJogo) {
			modoJogo = false;
			
			painelPrincipal.setBotaoJogarEnable(true);
			painelPrincipal.setCaixaNomeJogadorEnabled(true);
			painelPrincipal.apagarCaixaNomeJogador();
			
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
	 * Abre uma tela com uma tabela dos recordes de partidas anteriores
	 */
	public void abrirTelaRelatorio() {
		new TelaRelatorio(this);
	}

}
