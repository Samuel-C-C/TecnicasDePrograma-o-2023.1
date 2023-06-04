package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AbaDeletar extends Panel {
	
	private static final long serialVersionUID = -8686685617221306416L;
	
	private TextField caixaMatricula;
	
	public AbaDeletar() {
	
		this.caixaMatricula = new TextField();
		
		JButton botaoSalvar = new JButton("Deletar");
		botaoSalvar.addActionListener(new ActionDeletar());
		
		Panel painelEsquerda = new Panel();
		painelEsquerda.setLayout(new GridLayout(2,1));
		
		painelEsquerda.add(new Label("Matrícula:"));
		
		Panel painelDireita = new Panel();
		painelDireita.setLayout(new GridLayout(2,1));
		
		painelDireita.add(caixaMatricula);
		painelDireita.add(botaoSalvar);
		
		this.setBackground(Color.blue);
		this.setLayout(new GridLayout(1, 2));
		
		this.add(painelEsquerda);
		this.add(painelDireita);
// 		this.setVisible(false);
		
	}
	
	private class ActionDeletar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}	
	}

}
