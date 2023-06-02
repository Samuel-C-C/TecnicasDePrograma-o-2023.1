package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelControleAbas extends Panel {

	private static final long serialVersionUID = -5021656132881604141L;
	
	private PainelAbas painelAbas;
	
	public PainelControleAbas(PainelAbas painelAbas) {
		this.painelAbas = painelAbas;

		this.setLayout(new GridLayout(1, 4));
		this.setBackground(Color.black);
		
		BotaoControleAbas botaoCadastrar = new BotaoControleAbas("Cadastrar");
		botaoCadastrar.addActionListener(new ActionMostrarAbaCadastrar());
		this.add(botaoCadastrar);
		
		BotaoControleAbas botaoListar = new BotaoControleAbas("Listar");
		botaoListar.addActionListener(new ActionMostrarAbaListar());
		this.add(botaoListar);
		
		BotaoControleAbas botaoAtualizar = new BotaoControleAbas("Atualizar");
		botaoAtualizar.addActionListener(new ActionMostrarAbaAtualizar());
		this.add(botaoAtualizar);
		
		BotaoControleAbas botaoDeletar = new BotaoControleAbas("Deletar");
		botaoDeletar.addActionListener(new ActionMostrarAbaDeletar());
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
