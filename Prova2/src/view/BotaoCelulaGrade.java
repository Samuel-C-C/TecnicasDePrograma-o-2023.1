package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import control.Celula;
import control.Robo;

/**
 * Representa os botões do {@link PainelGrade} que servem para selecionar uma Célula
 * 
 * @author Samuel
 * 
 * @see JButton
 * @see PainelGrade
 * @see Celula
 */
public class BotaoCelulaGrade extends JButton {

	private static final long serialVersionUID = -8118156302023364600L;
	
	/**
	 * Referencia a {@code TelaJogo} a qual esse botão pertence
	 * 
	 * @see TelaJogo
	 */
	private TelaJogo telaJogo;
	
	/**
	 * A coordenada X na grade desse botão
	 * 
	 * @see PainelGrade
	 */
	private int x;
	
	/**
	 * A coordenada Y na grade desse botão
	 * 
	 * @see PainelGrade
	 */
	private int y;
	
	/**
	 * Cria um novo botão com coordenadas (x, y)
	 * 
	 * @param telaJogo a {@code TelaJogo} a qual esse botão pertence
	 * @param x a posição X do botão na grade
	 * @param y a posição Y do botão na grade
	 */
	public BotaoCelulaGrade(TelaJogo telaJogo, int x, int y) {
		super();
		
		this.telaJogo = telaJogo;
		this.x = x;
		this.y = y;
		
		Font fonte = getFont();
		Font novaFonte = fonte.deriveFont(Font.PLAIN, 9);
		setFont(novaFonte);
		
		definirModoCelulaEscondida();
		addActionListener(new acaoApertarBotao());
		setEnabled(false);
	}
	
	/**
	 * Retorna a posição x da célula
	 * 
	 * @return a posição x da célula
	 * 
	 * @see BotaoCelulaGrade#x
	 */
	public int getCX() {
		return x;
	}
	
	/**
	 * Retorna a posição y da célula
	 * 
	 * @return a posição y da célula
	 * 
	 * @see BotaoCelulaGrade#y
	 */
	public int getCY() {
		return y;
	}
	
	/**
	 * Diz se a coordenada do botão é (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * @return {@code true} se a posição do botão for igual a {@code x} e {@code y},
	 * caso contrário, {@code false}
	 */
	public boolean verificarPosicao(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	/**
	 * Muda a imagem do botão
	 * 
	 * @param icone nova imagem
	 * 
	 * @see ImageIcon
	 */
	private void definirIcon(Imagens imagem) {
		ImageIcon icone = new ImageIcon(
				imagem.getImagem().
				getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)
				);
		
		setIcon(icone);
		setDisabledIcon(icone);
	}
	
	/**
	 * Muda a aparência do botão para apresentar que não há nada na celula
	 */
	public void definirModoCelulaVazia() {
		definirIcon(Imagens.CELULA_VAZIA);
	}
	
	/**
	 * Muda a aparência do botão para apresentar que não se sabe ainda oq tem na celula
	 */
	public void definirModoCelulaEscondida() {
		definirIcon(Imagens.CELULA_ESCONDIDA);
	}
	
	/**
	 * Muda a aparência do botão para apresentar que um aluno está na celula
	 */
	public void definirModoCelulaComAluno() {
		definirIcon(Imagens.CELULA_COM_ALUNO);
	}
	
	/**
	 * Muda a aparência do botão para apresentar que um bug está na celula
	 */
	public void definirModoCelulaComBug() {
		definirIcon(Imagens.CELULA_COM_BUG);
	}
	
	/**
	 * Muda a aparência do botão para apresentar que o robo 1 está na celula
	 */
	public void definirModoCelulaComRobo1() {
		definirIcon(Imagens.CELULA_COM_ROBO_1);
	}
	
	/**
	 * Muda a aparência do botão para apresentar que o robo 2 está na celula
	 */
	public void definirModoCelulaComRobo2() {
		definirIcon(Imagens.CELULA_COM_ROBO_2);
	}
	
	/**
	 * Muda a aparência do botão para apresentar que o robo 3 está na celula
	 */
	public void definirModoCelulaComRobo3() {
		definirIcon(Imagens.CELULA_COM_ROBO_3);
	}
	
	/**
	 * Classe do tipo ação que tem o método executado pelo botão
	 * 
	 * <p>coloca um Robo do Tabuleiro na posição da celula</p>
	 * 
	 * @see ActionListener
	 * @see Robo
	 */
	private class acaoApertarBotao implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (telaJogo.getPainelControleRobos().isBotaoSelecionado()) {
				telaJogo.getControleJogo().colocarRoboTabuleiro(x, y);
			} else {
				new SemRoboSelecionadoException(x, y).printStackTrace();
			}
		}
	}
	
	/**
	 * Exceção quando o botão da grade é apertado sem nenhun robo selecionado
	 * 
	 * @see Exception
	 */
	public class SemRoboSelecionadoException extends Exception {
		private static final long serialVersionUID = -1217117526837725293L;
		
		public SemRoboSelecionadoException(int x, int y) {
			super("Botão" + x + ", " + y + " da grade foi pressionado sem haver um robô selecionado");
		}
	}
	
}
