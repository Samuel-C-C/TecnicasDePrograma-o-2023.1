package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.ColecaoAlunos;

public class Janela extends JFrame {

	private static final long serialVersionUID = -419158925384719190L;
	
	protected ColecaoAlunos colecaoAlunos;
	protected PainelAbas painelAbas;

	public Janela(ColecaoAlunos colecaoAlunos) {
		this.colecaoAlunos = colecaoAlunos;
		
		this.setSize(800, 600);
		this.setTitle("Banco Dados Alunos");
		ImageIcon icone = new ImageIcon("/BancoDadosAlunos/imagems/icon.png");
		this.setIconImage(icone.getImage());
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(0xC9DAF8));
		
		this.painelAbas =  new PainelAbas(this);
		PainelControleAbas painelControleAbas = new PainelControleAbas(painelAbas);
		
		this.setLayout(new BorderLayout(0, 10));
		this.add(painelControleAbas, BorderLayout.NORTH);
		this.add(painelAbas, BorderLayout.CENTER);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void updateUI() {
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
	
}
