package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AbaCadastrar extends JPanel {

	private static final long serialVersionUID = 9165687672314097449L;
	
	private TextField caixaNome;
	private TextField caixaCPF;
	private TextField caixaMatricula;
	private TextField caixaVertente;
	
	public AbaCadastrar() {
		
		this.caixaNome = new TextField();
		this.caixaCPF = new TextField();
		this.caixaMatricula = new TextField();
		this.caixaVertente = new TextField();
		
		JButton botaoSalvar = new JButton("Cadastrar");
		botaoSalvar.addActionListener(new ActionCadastrar());
		
		Panel painelEsquerda = new Panel();
		painelEsquerda.setLayout(new GridLayout(5,1));
		
		painelEsquerda.add(new Label("Nome:"));
		painelEsquerda.add(new Label("CPF:"));
		painelEsquerda.add(new Label("Matrícula:"));
		painelEsquerda.add(new Label("Vertente:"));
		
		Panel painelDireita = new Panel();
		painelDireita.setLayout(new GridLayout(5,1));
		
		painelDireita.add(caixaNome);
		painelDireita.add(caixaCPF);
		painelDireita.add(caixaMatricula);
		painelDireita.add(caixaVertente);
		painelDireita.add(botaoSalvar);
		
		this.setBackground(Color.yellow);
		this.setLayout(new GridLayout(1, 2));
		
		this.add(painelEsquerda);
		this.add(painelDireita);
// 		this.setVisible(false);
		
	}
	
	private class ActionCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
