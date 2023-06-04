package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AbaCadastrar extends JPanel {

	private static final long serialVersionUID = 9165687672314097449L;
	
	private JTextField caixaNome;
	private JTextField caixaCPF;
	private JTextField caixaMatricula;
	private JTextField caixaVertente;
	
	public AbaCadastrar() {
		
		this.caixaNome = new JTextField();
		this.caixaCPF = new JTextField();
		this.caixaMatricula = new JTextField();
		this.caixaVertente = new JTextField();
		
		JButton botaoSalvar = new JButton("Cadastrar");
		botaoSalvar.addActionListener(new ActionCadastrar());
		
		JPanel painelEsquerda = new JPanel();
		painelEsquerda.setLayout(new GridLayout(5,1));
		
		JLabel textoNome = new JLabel("Nome:");
		JLabel textoCPF = new JLabel("CPF:");
		JLabel textoMatricula = new JLabel("Matrícula:");
		JLabel textoVertente = new JLabel("Vertente:");
		
		painelEsquerda.add(textoNome);
		painelEsquerda.add(textoCPF);
		painelEsquerda.add(textoMatricula);
		painelEsquerda.add(textoVertente);
		
		JPanel painelDireita = new JPanel();
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
