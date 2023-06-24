package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * a tela que vai mostrar todos os recordes de partidas anteriores
 * 
 * @author Samuel
 */
public class TelaRelatorio extends JFrame {

	private static final long serialVersionUID = -8472193129676241177L;
	
	/**
	 * um {@code DefaultTableModel} dedicado a tabela dos recordes
	 * 
	 * @see DefaultTableModel
	 */
	private DefaultTableModel tabelaRecordes;
	
	public TelaRelatorio(TelaJogo tela) {
		setSize(new Dimension(1000, 400));
		setResizable(false);
		setLocationRelativeTo(tela);
		
		String[] nomeColunas = {
				"Jogador", "Quantidade Rodadas", "Células vázias", 
				"Pontuação", "Alunos resgatados", "Bugs encontrados",
				"Robo 1", "Robo 2", "Robo 2"
				};
		
		Object[][] dados = tela.getControleJogo().getDadosRecordes();
		
		this.tabelaRecordes = new DefaultTableModel(dados.length, 9);
		tabelaRecordes.setDataVector(dados, nomeColunas);
		
		JTable tabelaRecordes = new JTable(this.tabelaRecordes);
		JScrollPane caixaTabela = new JScrollPane(tabelaRecordes);
		
		setLayout(new BorderLayout());
		add(caixaTabela, BorderLayout.CENTER);
		
		setVisible(true);
	}

}
