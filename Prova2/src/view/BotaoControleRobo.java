package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 * Cor quando o botão é selecionado
	 * 
	 * @see Color
	 */
	public static Color corSelecionado = new Color(0x10f010);
	
	/**
	 * Cor normal do botão
	 * 
	 * @see Color
	 */
	public static Color corNormal = new Color(0xe0e0e0);
	
	/**
	 * Cor quando o botão é bloqueado
	 * 
	 * @see Color
	 */
	public static Color corBloqueado = new Color(0xf01010);
	
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
		
		setText("ROBO " + numeroBotao);
		habilitar();
		addActionListener(new AcaoSelecionarRobo());
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
	 * Faz o botão ficar normal
	 * 
	 * <p>a forma normal do botão</p>
	 */
	public void habilitar() {
		setBackground(corNormal);
		setEnabled(true);
		selecionado = false;
	}
	
	/**
	 * Faz o botão ficar bloqueado
	 * 
	 * <p>dessa forma, o botão não pode ser pressionado</p>
	 */
	public void bloquear() {
		setBackground(corBloqueado);
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
		setBackground(corSelecionado);
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
