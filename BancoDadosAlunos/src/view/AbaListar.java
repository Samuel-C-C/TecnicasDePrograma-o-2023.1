package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AbaListar extends JPanel {

	private static final long serialVersionUID = -6562981918907042581L;
	
	private JTable tabelaAlunos;
	
	public AbaListar() {
		
		String[] nomeColunas = {"Nome", "CPF", "Matricula", "Vertente"};
		Object[][] dados = {
				{"Samuel", "000.000.000-00", "539682", "Computação"}
		};
		
		this.tabelaAlunos = new JTable(dados, nomeColunas);
		JScrollPane caixaTabela = new JScrollPane(tabelaAlunos);
		
		this.setBackground(Color.green);
		
		this.add(caixaTabela, BorderLayout.CENTER);
// 		this.setVisible(false);
		
	}

}
