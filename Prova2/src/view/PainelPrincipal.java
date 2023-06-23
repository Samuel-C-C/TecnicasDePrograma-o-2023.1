package view;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Representa o painel principal da tela, onde é pedido o nome do jogador,
 * onde pode se acesar o relatorio das partidas passadas e começar uma partida
 * 
 * @author Samuel
 * 
 * @see JPanel
 */
public class PainelPrincipal extends JPanel {

	private static final long serialVersionUID = -4285292850052784954L;
	
	/**
	 * Referencia a {@code TelaJogo} a qual esse painel pertence
	 * 
	 * @see TelaJogo
	 */
	private TelaJogo telaJogo;
	
	/**
	 * a caixa de texto onde é digitado o nome do jogador
	 * 
	 * @see JTextField
	 */
	private JTextField caixaNomeJogador;
	
	/**
	 * O botão que inicia a partida
	 * 
	 * @see JButton
	 */
	private JButton botaoJogar;
	
	/**
	 * Cria o painel usando uma {@code TelaJogo}
	 * 
	 * @param telaJogo a tela a qual esse painel pertence
	 * 
	 * @see TelaJogo
	 */
	public PainelPrincipal(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
		
		this.setPreferredSize(new Dimension(800, 100));
		this.setLayout(new GridLayout(1, 4, 10, 0));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		this.setBackground(new Color(0x0F6374));
		
		this.add(new JLabel("Nome do Jogador:"));
		caixaNomeJogador = new JTextField();
		caixaNomeJogador.setHorizontalAlignment(JTextField.CENTER);
		
//		this.caixaNomeJogador.setPreferredSize(new Dimension(200, 50));
		this.add(caixaNomeJogador);
		
		botaoJogar = new JButton("Jogar");
		botaoJogar.setBackground(new Color(0xf1f1f1));
		botaoJogar.addActionListener(new AcaoJogar());
		this.add(botaoJogar);
		
		JButton botaoRelatorio = new JButton("Relatório do Jogo");
		botaoRelatorio.setBackground(new Color(0xf1f1f1));
		botaoRelatorio.addActionListener(new AcaoRelatorio());
		this.add(botaoRelatorio);	
	}

	/**
	 * Ativa e desativa o botão de jogar
	 * 
	 * @param ativado ativa o botão se for {@code true}, e
	 * desativa o botão se for {@code false}
	 * 
	 * @see PainelPrincipal#botaoJogar
	 */
	public void setBotaoJogarEnable(boolean ativado) {
		botaoJogar.setEnabled(ativado);
	}
	
	/**
	 * Ativa e desativa a caixa de texto do nome do jogador
	 * 
	 * @param ligado ativa a caixa se for {@code true}, desativa se for {@code false}
	 */
	public void setCaixaNomeJogadorEnabled(boolean ligado) {
		caixaNomeJogador.setEnabled(ligado);
	}
	
	/**
	 * @return {@code true} se {@link PainelPrincipal#caixaNomeJogador} estiver vazia
	 */
	private boolean verificarCaixaNomeJogador() {
		return caixaNomeJogador.getText().isBlank();
	}
	
	/**
	 * @return o nome escrito em {@link PainelPrincipal#caixaNomeJogador}
	 */
	public String getNomeJogador() {
		return caixaNomeJogador.getText();
	}
	
	/**
	 * Classe do tipo ação que tem seu método executado pelo botão jogar
	 * e começa a partida se a {@link PainelPrincipal#caixaNomeJogador} não estiver vazia
	 * 
	 * @see ActionListener
	 */
	private class AcaoJogar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (verificarCaixaNomeJogador()) {
				JOptionPane.showMessageDialog(telaJogo, "Nome do Jogador não pode ser vazio!");
			} else {
				telaJogo.getControleJogo().comecarNovaPartida();
			}
		}
	}
	
	/**
	 * Classe do tipo ação que tem seu método executado pelo botão relatório
	 * e abre a tela {@link TelaRelatorio} para mostrar os recordes das partidas
	 * 
	 * @see ActionListener
	 */
	private class AcaoRelatorio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telaJogo.abrirTelaRelatorio();
		}
	}

}
