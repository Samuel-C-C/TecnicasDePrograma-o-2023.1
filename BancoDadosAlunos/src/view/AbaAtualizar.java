package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AbaAtualizar extends JPanel {

	private static final long serialVersionUID = -1383494888632096136L;
	
	private JTextField caixaMatricula;
	private JTextField caixaVertente;
	
	public AbaAtualizar() {
		
		this.caixaMatricula = new JTextField();
		this.caixaVertente = new JTextField();
		
		JButton botaoSalvar = new JButton("Atualizar");
		botaoSalvar.addActionListener(new  ActionAtualizar());
		
		JPanel painelEsquerda = new JPanel();
		painelEsquerda.setLayout(new GridLayout(3, 1));
		
		JLabel textoMatricula = new JLabel("Matrícula:");
		JLabel textoVertente = new JLabel("Vertente:");
		
		painelEsquerda.add(textoMatricula);
		painelEsquerda.add(textoVertente);
		
		JPanel painelDireita = new JPanel();
		painelDireita.setLayout(new GridLayout(3, 1));
		
		painelDireita.add(caixaMatricula);
		painelDireita.add(caixaVertente);
		painelDireita.add(botaoSalvar);

		this.setBackground(Color.red);
		this.setLayout(new GridLayout(1, 2));
		
		this.add(painelEsquerda);
		this.add(painelDireita);
// 		this.setVisible(false);
		
	}
	
	private class ActionAtualizar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
