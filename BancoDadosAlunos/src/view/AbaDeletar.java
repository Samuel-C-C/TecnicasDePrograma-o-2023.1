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

public class AbaDeletar extends JPanel {
	
	private static final long serialVersionUID = -8686685617221306416L;
	
	private JTextField caixaMatricula;
	
	private Janela janelaPrincipal;
	
	public AbaDeletar(Janela janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
		
		this.caixaMatricula = new JTextField();
		
		JButton botaoSalvar = new JButton("Deletar");
		botaoSalvar.addActionListener(new ActionDeletar());
		
		JPanel painelEsquerda = new JPanel();
		painelEsquerda.setLayout(new GridLayout(2,1, 0, 10));
		
		JLabel textoMatricula = new JLabel("Matrícula:");
		
		painelEsquerda.add(textoMatricula);
		
		JPanel painelDireita = new JPanel();
		painelDireita.setLayout(new GridLayout(2,1, 0, 10));
		
		painelDireita.add(caixaMatricula);
		painelDireita.add(botaoSalvar);
		
		this.setBackground(Color.blue);
		this.setLayout(new GridLayout(1, 2));
		
		this.add(painelEsquerda);
		this.add(painelDireita);
// 		this.setVisible(false);
		
	}
	
	public void limparCaixas() {
		this.caixaMatricula.setText("");
	}
	
	private class ActionDeletar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = janelaPrincipal.colecaoAlunos.findAlunoMatricula(caixaMatricula.getText());
			if (index >= 0) {
				Aluno aluno = janelaPrincipal.colecaoAlunos.getAluno(index);
				janelaPrincipal.colecaoAlunos.removeAluno(aluno);
			}
			
			janelaPrincipal.painelAbas.updateDados();
			limparCaixas();
		}
	}

}
