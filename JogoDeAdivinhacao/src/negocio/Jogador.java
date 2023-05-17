package negocio;

import java.util.ArrayList;

public class Jogador {

	private String nome;
	
	private int numeroTentativa;
	private ArrayList<Integer> listaNumeros;
	
	public String getNome() {
		return this.nome;
	}
	
	public int getNumeroTentativa() {
		return numeroTentativa;
	}
	
	public ArrayList<Integer> getListaNumeros(){
		return listaNumeros;
	}

	public Jogador(String nome) {
		this.nome = nome;
		this.numeroTentativa = 0;
	    this.listaNumeros = new ArrayList<Integer>();
	}
	
	public void tentarNumero(int numero) {
		this.numeroTentativa++;
		this.listaNumeros.add(numero);
	}
	
	public void resetarTentativas() {
		this.numeroTentativa = 0;
		this.listaNumeros = new ArrayList<>();
	}
}
