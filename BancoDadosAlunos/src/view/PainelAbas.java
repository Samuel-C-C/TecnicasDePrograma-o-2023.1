package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PainelAbas extends JPanel {
	
	private static final long serialVersionUID = -4136081099413851612L;
	
	private AbaCadastrar abaCadastrar;
	private AbaListar abaListar;
	private AbaAtualizar abaAtualizar;
	private AbaDeletar abaDeletar;
	
	public PainelAbas(Janela janelaPrincipal) {
		this.abaCadastrar = new AbaCadastrar(janelaPrincipal);
		this.abaListar = new AbaListar(janelaPrincipal);
		this.abaAtualizar = new AbaAtualizar(janelaPrincipal);
		this.abaDeletar = new AbaDeletar(janelaPrincipal);
		
		this.setLayout(new BorderLayout());
	}
	
	public void updateDados() {
		this.abaListar.updateDados();
	}
	
	public void mostrarAbaCadastrar() {
		
		this.remove(abaListar);
		this.remove(abaAtualizar);
		this.remove(abaDeletar);
		this.add(abaCadastrar, BorderLayout.CENTER);
		
		abaCadastrar.limparCaixas();
		this.updateUI();
	}
	
	public void mostrarAbaListar() {
		
		this.remove(abaCadastrar);
		this.remove(abaAtualizar);
		this.remove(abaDeletar);
		this.add(abaListar, BorderLayout.CENTER);
		
		this.updateUI();
	}
	
	public void mostrarAbaAtualizar() {
		
		this.remove(abaCadastrar);
		this.remove(abaListar);
		this.remove(abaDeletar);
		this.add(abaAtualizar, BorderLayout.CENTER);
		
		abaAtualizar.limparCaixas();
		this.updateUI();
	}
	
	public void mostrarAbaDeletar() {
		
		this.remove(abaCadastrar);
		this.remove(abaListar);
		this.remove(abaAtualizar);
		this.add(abaDeletar, BorderLayout.CENTER);
		
		abaDeletar.limparCaixas();
		this.updateUI();
	}

}
