package view;

import java.awt.Color;
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

public class PainelPrincipal extends JPanel {

	private static final long serialVersionUID = -4285292850052784954L;
	
	private TelaJogo telaJogo;
	private JTextField caixaNomeJogador;
	
	public PainelPrincipal(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
		
		this.setPreferredSize(new Dimension(800, 100));
		this.setLayout(new GridLayout(1, 4, 10, 0));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		this.setBackground(new Color(0x0F6374));
		
		this.add(new JLabel("Nome do Jogador:"));
		this.caixaNomeJogador = new JTextField();
//		this.caixaNomeJogador.setPreferredSize(new Dimension(200, 50));
		this.add(caixaNomeJogador);
		
		JButton botaoJogar = new JButton("Jogar");
		botaoJogar.addActionListener(new AcaoJogar());
		this.add(botaoJogar);
		
		JButton botaoRelatorio = new JButton("Relatório do Jogo");
		botaoRelatorio.addActionListener(new AcaoRelatorio());
		this.add(botaoRelatorio);	
	}
	
	public class AcaoJogar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!caixaNomeJogador.getText().isBlank()) {
				caixaNomeJogador.setEnabled(false);
				telaJogo.mudarParaModoJogo();
			} else {
				JOptionPane.showMessageDialog(telaJogo, "Nome do Jogador não pode ser vazio!");
			}
		}
	}
	
	public class AcaoRelatorio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}

}
