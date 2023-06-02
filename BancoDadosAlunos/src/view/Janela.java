package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Janela extends JFrame {

	private static final long serialVersionUID = -419158925384719190L;

	public Janela() {
		
		this.setSize(800, 600);
		this.setTitle("teste");
		this.setLocationRelativeTo(null);
		
		PainelAbas painelAbas =  new PainelAbas(this);
		PainelControleAbas painelControleAbas = new PainelControleAbas(painelAbas);
		
		this.add(painelControleAbas, BorderLayout.NORTH);
		this.add(painelAbas, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void updateUI() {
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
	
}
