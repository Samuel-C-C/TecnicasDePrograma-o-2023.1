package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PainelControleRobos extends JPanel {

	private static final long serialVersionUID = 2882332004367745507L;
	
	private TelaJogo telaJogo;
	
	public PainelControleRobos(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
		
		this.setPreferredSize(new Dimension(300, 500));
		this.setBackground(new Color(0xFF00FF));
		
	}
	
}
