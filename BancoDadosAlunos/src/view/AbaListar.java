package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Aluno;

public class AbaListar extends JPanel {

	private static final long serialVersionUID = -6562981918907042581L;
	
	private DefaultTableModel tabelaAlunos;
	
	private Janela janelaPrincipal;
	
	public AbaListar(Janela janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
		
		String[] nomeColunas = {"Nome", "CPF", "Matricula", "Vertente"};
		
//		Object[][] dados = {
//				{"Samuel", "000.000.000-00", "539682", "Computação"}
//		};
		
		this.tabelaAlunos = new DefaultTableModel(0,4);
		this.tabelaAlunos.setDataVector(null, nomeColunas);
		
		JTable tabelaAlunos = new JTable(this.tabelaAlunos);
		JScrollPane caixaTabela = new JScrollPane(tabelaAlunos);
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.green);
		
		this.add(caixaTabela, BorderLayout.CENTER);
// 		this.setVisible(false);
		
	}
	
	public void updateDados() {
		int numeroLinhas = janelaPrincipal.colecaoAlunos.size();
		
		String[] nomeColunas = {"Nome", "CPF", "Matricula", "Vertente"};
		Object[][] dados = new Object[numeroLinhas][4];
		
		for (int i = 0; i < numeroLinhas; i++) {
			Aluno aluno = janelaPrincipal.colecaoAlunos.getAluno(i);
			
			dados[i][0] = aluno.getNome();
			dados[i][1] = aluno.getCPF();
			dados[i][2] = aluno.getMatricula();
			dados[i][3] = aluno.getVertente();
		}
		
		this.tabelaAlunos.setDataVector(dados, nomeColunas);
		this.tabelaAlunos.fireTableRowsUpdated(0, numeroLinhas);	
	}

}
