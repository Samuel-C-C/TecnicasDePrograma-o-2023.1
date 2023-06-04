package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PainelControleAbas extends JPanel {

	private static final long serialVersionUID = -5021656132881604141L;
	
	private PainelAbas painelAbas;
	
	public PainelControleAbas(PainelAbas painelAbas) {
		this.painelAbas = painelAbas;

		this.setLayout(new FlowLayout());
		
		BotaoControleAbas botaoCadastrar = new BotaoControleAbas("Cadastrar");
		botaoCadastrar.addActionListener(new ActionMostrarAbaCadastrar());
		
		BotaoControleAbas botaoListar = new BotaoControleAbas("Listar");
		botaoListar.addActionListener(new ActionMostrarAbaListar());
		
		BotaoControleAbas botaoAtualizar = new BotaoControleAbas("Atualizar");
		botaoAtualizar.addActionListener(new ActionMostrarAbaAtualizar());
		
		BotaoControleAbas botaoDeletar = new BotaoControleAbas("Deletar");
		botaoDeletar.addActionListener(new ActionMostrarAbaDeletar());

		this.add(botaoCadastrar);
		this.add(botaoListar);
		this.add(botaoAtualizar);
		this.add(botaoDeletar);
		
	}
	
	private class ActionMostrarAbaCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			painelAbas.mostrarAbaCadastrar();
		}
	}
	
	private class ActionMostrarAbaListar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			painelAbas.mostrarAbaListar();
		}
	}
	
	private class ActionMostrarAbaAtualizar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			painelAbas.mostrarAbaAtualizar();
		}
	}
	
	private class ActionMostrarAbaDeletar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			painelAbas.mostrarAbaDeletar();
		}
	}

}
