package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = 8398625067733596004L;
	
	private boolean modoJogo;
	private PainelPrincipal painelPrincipal;
	private PainelControleRobos painelControleRobos;
	private PainelGrade painelGrade;
	
	/**
	 * construtor
	 */
	public TelaJogo() {
		this.setSize(800, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.modoJogo = false;
		this.painelPrincipal = new PainelPrincipal(this);
		this.painelControleRobos = new PainelControleRobos(this);
		this.painelGrade = new PainelGrade(this);
		
		this.setLayout(new BorderLayout());
		this.add(painelPrincipal, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void mudarParaModoJogo() {
		if (!this.modoJogo) {
			this.modoJogo = true;
			
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout());
			this.add(painelPrincipal, BorderLayout.NORTH);
			this.add(painelControleRobos, BorderLayout.EAST);
			this.add(painelGrade, BorderLayout.WEST);
			
			this.updateUI();
		}
	}
	
	private void updateUI() {
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}

}
