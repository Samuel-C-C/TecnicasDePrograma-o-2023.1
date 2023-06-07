package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Aluno;

public class AbaAtualizar extends JPanel {

	private static final long serialVersionUID = -1383494888632096136L;
	
	private JTextField caixaMatricula;
	private JTextField caixaVertente;
	
	private Janela janelaPrincipal;
	
	public AbaAtualizar(Janela janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
		
		this.caixaMatricula = new JTextField();
		this.caixaVertente = new JTextField();
		
		JButton botaoSalvar = new JButton("Atualizar");
		botaoSalvar.addActionListener(new  ActionAtualizar());
		
		JPanel painelEsquerda = new JPanel();
		painelEsquerda.setLayout(new GridLayout(3, 1, 0, 10));
		
		JLabel textoMatricula = new JLabel("Matrícula:");
		JLabel textoVertente = new JLabel("Vertente:");
		
		painelEsquerda.add(textoMatricula);
		painelEsquerda.add(textoVertente);
		
		JPanel painelDireita = new JPanel();
		painelDireita.setLayout(new GridLayout(3, 1, 0, 10));
		
		painelDireita.add(caixaMatricula);
		painelDireita.add(caixaVertente);
		painelDireita.add(botaoSalvar);

		this.setBackground(Color.red);
		this.setLayout(new GridLayout(1, 2));
		
		this.add(painelEsquerda);
		this.add(painelDireita);
// 		this.setVisible(false);
		
	}
	
	public void limparCaixas() {
		this.caixaMatricula.setText("");
		this.caixaVertente.setText("");
	}
	
	private class ActionAtualizar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = janelaPrincipal.colecaoAlunos.findAlunoMatricula(caixaMatricula.getText());
			if (index >= 0) {
				Aluno aluno = janelaPrincipal.colecaoAlunos.getAluno(index);
				aluno.setVertente(caixaVertente.getText());
			}
			
			janelaPrincipal.painelAbas.updateDados();
			limparCaixas();
		}
	}

}
