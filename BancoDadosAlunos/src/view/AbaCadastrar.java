package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;

public class AbaCadastrar extends Panel {

	private static final long serialVersionUID = 9165687672314097449L;
	
	private TextField caixaNome;
	private TextField caixaCPF;
	private TextField caixaMatricula;
	private TextField caixaVertente;
	
	private JButton botaoSalvar;
	
	public AbaCadastrar() {
		
		this.caixaNome = new TextField();
		this.caixaCPF = new TextField();
		this.caixaMatricula = new TextField();
		this.caixaVertente = new TextField();
		
		this.botaoSalvar = new JButton("Salvar");
		
		this.setBackground(Color.yellow);
		
		this.setLayout(new GridLayout(1, 2));
		
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
		
		this.add(painelEsquerda);
		this.add(painelDireita);
		
 		this.setVisible(false);
		
	}

}
