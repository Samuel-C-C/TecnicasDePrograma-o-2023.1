package view;

import java.awt.BorderLayout;
import java.awt.Panel;

public class PainelAbas extends Panel {
	
	private static final long serialVersionUID = -4136081099413851612L;
	
	private AbaCadastrar abaCadastrar;
	private AbaListar abaListar;
	private AbaAtualizar abaAtualizar;
	private AbaDeletar abaDeletar;
	
	private Janela janela;
	
	public PainelAbas(Janela janela) {
		this.janela = janela;

		this.abaCadastrar = new AbaCadastrar();
		this.abaListar = new AbaListar();
		this.abaAtualizar = new AbaAtualizar();
		this.abaDeletar = new AbaDeletar();
		
		this.setLayout(new BorderLayout());
		
		this.add(abaCadastrar, BorderLayout.CENTER);
		this.add(abaListar, BorderLayout.CENTER);
		this.add(abaAtualizar, BorderLayout.CENTER);
		this.add(abaDeletar, BorderLayout.CENTER);
		
	}
	
	public void mostrarAbaCadastrar() {
		
		this.abaCadastrar.setVisible(true);
		this.abaListar.setVisible(false);
		this.abaAtualizar.setVisible(false);
		this.abaDeletar.setVisible(false);
		
		this.updateUI();
	}
	
	public void mostrarAbaListar() {
		
		this.abaCadastrar.setVisible(false);
		this.abaListar.setVisible(true);
		this.abaAtualizar.setVisible(false);
		this.abaDeletar.setVisible(false);
		
		this.updateUI();
	}
	
	public void mostrarAbaAtualizar() {
		
		this.abaCadastrar.setVisible(false);
		this.abaListar.setVisible(false);
		this.abaAtualizar.setVisible(true);
		this.abaDeletar.setVisible(false);
		
		this.updateUI();
	}
	
	public void mostrarAbaDeletar() {
		
		this.abaCadastrar.setVisible(false);
		this.abaListar.setVisible(false);
		this.abaAtualizar.setVisible(false);
		this.abaDeletar.setVisible(true);
		
		this.updateUI();
	}
	
	private void updateUI() {
		janela.updateUI();
	}

}
