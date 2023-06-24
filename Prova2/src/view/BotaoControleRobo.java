package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import control.Robo;

/**
 * Representa os botões usados para selecionar um robo
 * 
 * @author Samuel
 * 
 * @see Robo
 */
public class BotaoControleRobo extends JButton {

	private static final long serialVersionUID = 4184139410738668476L;
	
	/**
	 * Cor normal do botão
	 * 
	 * @see Color
	 */
	public static final Color COR_NORMAL = new Color(0xe0e0e0);
	
	/**
	 * Cor quando o botão é bloqueado
	 * 
	 * @see Color
	 */
	public static final Color COR_BLOQUEADO = new Color(0xe0c0c0);
	
	/**
	 * O painel a qual esse botão pertence
	 * 
	 * @see PainelControleRobos
	 */
	private PainelControleRobos painelControleRobos;
	
	/**
	 * Diz se o botão está selecionado
	 */
	private boolean selecionado;
	
	/**
	 * O número do botão
	 */
	private int numeroBotao;
	
	/**
	 * Imagem do botão
	 * 
	 * @see ImageIcon
	 */
	private ImageIcon icone;
	
	/**
	 * Cria o botão usando o painel e o número
	 * 
	 * @param painelControleRobos painel a qual esse botão pertence
	 * @param numero número do botão
	 * 
	 * @see PainelControleRobos
	 * @see BotaoControleRobo#numeroBotao
	 */
	public BotaoControleRobo(PainelControleRobos painelControleRobos, int numero) {
		super();
		
		this.painelControleRobos = painelControleRobos;
		numeroBotao = numero;
		
		if (numeroBotao == 1) {
			definirIcone(Imagens.ROBO_1);
		} else if (numeroBotao == 2) {
			definirIcone(Imagens.ROBO_2);
		} else if (numeroBotao == 3) {
			definirIcone(Imagens.ROBO_3);
		}
		
		habilitar();
		addActionListener(new AcaoSelecionarRobo());
	}
	
	/**
	 * Define o atributo icone baseado numa das Imagens do {@code Enum Imagens}
	 * 
	 * @param imagem a imagem a ser escolhida
	 * 
	 * @see BotaoControleRobo#icone
	 * @see Imagens
	 */
	private void definirIcone(Imagens imagem) {
		icone = new ImageIcon(
				imagem.getImagem().
				getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)
				);
	}
	
	/**
	 * Retorna o robo com o nome "Robo X" onde X é o número do botão
	 * 
	 * @return um Robo relacionado com o botão, {@code null} se não houver robo
	 * relacionado com o botão
	 * 
	 * @see Robo
	 */
	public Robo getRoboRelacionado() {
		return painelControleRobos.getTelaJogo().getControleJogo().getTabuleiro().getRobo(numeroBotao);
	}
	
	/**
	 * Retorna se o botão está selecionado
	 * 
	 * @return se o botão está selecionado
	 * 
	 * @see BotaoControleRobo#selecionado
	 */
	public boolean isSelecionado() {
		return selecionado;
	}
	
	/**
	 * Retorna o número do botão
	 * 
	 * @return o número do botão
	 * 
	 * @see BotaoControleRobo#numeroBotao
	 */
	public int getNumeroBotao() {
		return numeroBotao;
	}
	
	/**
	 * Faz o botão ficar habilitado
	 * 
	 * <p>a forma normal do botão</p>
	 */
	public void habilitar() {
		setIcon(icone);
		setDisabledIcon(null);
		
		setBackground(COR_NORMAL);
		setEnabled(true);
		selecionado = false;
	}
	
	/**
	 * Faz o botão ficar bloqueado
	 * 
	 * <p>dessa forma, o botão não pode ser pressionado</p>
	 */
	public void bloquear() {
		
		if (getRoboRelacionado().isPosicionado()) {
			setIcon(null);
			setDisabledIcon(null);
		} else {
			setIcon(icone);
			setDisabledIcon(icone);
		}
		
		setBackground(COR_BLOQUEADO);
		setEnabled(false);
		selecionado = false;
	}
	
	/**
	 * Faz o botão ficar selecionado
	 * 
	 * <p>dessa forma, o botão não pode ser pressionado mas fica selecionado
	 * e todos os outros botões são bloqueados</p>
	 */
	public void selecionar() {
		setIcon(icone);
		setDisabledIcon(null);
		
		setBackground(COR_NORMAL);
		setEnabled(false);
		selecionado = true;
		
		for (BotaoControleRobo botao : painelControleRobos.getBotoesRobos()) {
			if (!botao.equals(BotaoControleRobo.this))
				botao.bloquear();
		}
	}
	
	/**
	 * Classe do tipo ação que tem seu método executado pelo botão
	 * 
	 * <p>vai selecionar um robo para ser colocado na grade</p>
	 * 
	 * @see ActionListener
	 */
	private class AcaoSelecionarRobo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selecionar();
			painelControleRobos.getTelaJogo().getPainelGrade().habilitarBotoes();
		}
	}
	
}
