package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PainelGrade extends JPanel {

	private static final long serialVersionUID = -999830848952280768L;
	
	private TelaJogo telaJogo;
	
	public PainelGrade(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
		
		this.setPreferredSize(new Dimension(500, 500));
		this.setBackground(new Color(0x00FFFF));
		
	}

}
