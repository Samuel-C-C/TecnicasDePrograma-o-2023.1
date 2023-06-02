package view;

import java.awt.Color;

import javax.swing.JButton;

public class BotaoControleAbas extends JButton {

	private static final long serialVersionUID = -2724633377108066213L;
	
	public BotaoControleAbas(String texto) {
		
		this.setText(texto);
		this.setBackground(new Color(120, 200, 20));
		
	}

}
