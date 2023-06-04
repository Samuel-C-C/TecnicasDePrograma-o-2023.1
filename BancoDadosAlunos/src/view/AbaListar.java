package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;

public class AbaListar extends JPanel {

	private static final long serialVersionUID = -6562981918907042581L;
	
	private JTable tabelaAlunos;
	
	public AbaListar() {
		
		this.tabelaAlunos = new JTable();
		
		this.setBackground(Color.green);
		
		this.add(tabelaAlunos, BorderLayout.CENTER);
// 		this.setVisible(false);
		
	}

}
