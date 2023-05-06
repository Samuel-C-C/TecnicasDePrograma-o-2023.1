package main;

import pessoas.Cliente;
import publicacoes.Publicacao;

public class Emprestimo {
	
	private Publicacao publicacaoEmprestada;
	private Cliente cliente;
	private int numeroDias;
	
	public Publicacao getPublicacaoEmprestada() {
		return publicacaoEmprestada;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public int getNumeroDias() {
		return numeroDias;
	}

	public Emprestimo(Publicacao publicacaoEmprestada, Cliente cliente) {
		cliente.pegarPublicacaoEmprestada(publicacaoEmprestada);
		publicacaoEmprestada.emprestar();
		
		this.publicacaoEmprestada = publicacaoEmprestada;
		this.cliente = cliente;
		this.numeroDias = cliente.getNumeroDiasEmprestimo();
		
		System.out.println(cliente.getNome() + " deve devolver " + publicacaoEmprestada.getTitulo() + " em " + this.numeroDias + " dias");
		
	}
	
	public String toString() {
		return "Publicação: " + this.publicacaoEmprestada.getTitulo() + " Cliente: " + this.cliente.getNome() + " dias restantes: " + this.numeroDias;
	}
	
}
