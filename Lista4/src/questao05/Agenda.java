package questao05;

import java.util.ArrayList;

public class Agenda {
	
	private String nomeAgenda;
	private String descricao;
	private ArrayList<Contato> listaDeContatos;
	
	private Cliente cliente;
	
	public Agenda(String nome, String descricao) {
		this.nomeAgenda = nome;
		this.descricao = descricao;
		this.listaDeContatos = new ArrayList<Contato>();
	}
	
	public String getNomeAgenda() {
		return nomeAgenda;
	}
	
	public void setNomeAgenda(String nomeAgenda) {
		this.nomeAgenda = nomeAgenda;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void adicionarContato(Contato novoContato) {
		this.listaDeContatos.add(novoContato);
	}
	
	public void removerContato(Contato contatoASerRemovido) {
		this.listaDeContatos.remove(contatoASerRemovido);
	}
	
	public ArrayList<Contato> getListaDeContatos() {
		return listaDeContatos;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
