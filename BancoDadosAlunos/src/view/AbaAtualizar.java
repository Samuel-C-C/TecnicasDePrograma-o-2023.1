package view;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AbaAtualizar extends JPanel {

	private static final long serialVersionUID = -1383494888632096136L;
	
	private TextField caixaMatricula;
	private TextField caixaVertente;
	
	public AbaAtualizar() {
		
		this.caixaMatricula = new TextField();
		this.caixaVertente = new TextField();
		
		JButton botaoSalvar = new JButton("Atualizar");
		botaoSalvar.addActionListener(new  ActionAtualizar());
		
		JPanel painelEsquerda = new JPanel();
		painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
		
		painelEsquerda.add(new JLabel("Matrícula:"));
		painelEsquerda.add(new JLabel("Vertente:"));
		
		JPanel painelDireita = new JPanel();
		painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
		
		painelDireita.add(caixaMatricula);
		painelDireita.add(caixaVertente);
		painelDireita.add(botaoSalvar);

		this.setBackground(Color.red);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
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
