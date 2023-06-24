package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * A tela que vai mostrar todos os recordes de partidas anteriores
 * 
 * @author Samuel
 */
public class TelaRelatorio extends JFrame {

	private static final long serialVersionUID = -8472193129676241177L;
	
	/**
	 * Um {@code DefaultTableModel} dedicado a tabela dos recordes
	 * 
	 * @see DefaultTableModel
	 */
	private DefaultTableModel tabelaRecordes;
	
	/**
	 * Cria a tela de relatório com uma tabela e todos os recordes
	 * 
	 * @param tela a tela principal do jogo
	 */
	public TelaRelatorio(TelaJogo tela) {
		setSize(new Dimension(1000, 400));
		setResizable(false);
		setLocationRelativeTo(tela);
		this.setIconImage(
				Imagens.ROBO_2.getImagem().
				getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)
				);
		
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
