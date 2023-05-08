package questao06;

import java.util.ArrayList;

public class Evento {
	
	private ArrayList<Ingresso> listaIngressos;
	private ArrayList<Ingresso> listaIngressosVendidos;
	
	public ArrayList<Ingresso> getListaIngressos() {
		return listaIngressos;
	}
	
	public Evento(ArrayList<Ingresso> listaIngressos) {
		
		this.listaIngressos = listaIngressos;
		this.listaIngressosVendidos = new ArrayList<Ingresso>();
		
	}
	
	public void venderIngresso(Ingresso ingresso) {
		
		if (this.listaIngressos.remove(ingresso)) {
			listaIngressosVendidos.add(ingresso);
		}
	}
	
	public double totalVendido() {
		double totalVendido = 0;
		
		for (Ingresso ingresso : this.listaIngressosVendidos) {
			totalVendido += ingresso.getValorTotal();
		}
		
		return totalVendido;
	}
	
	public void mostrarTodosIngressosNaoVendidos() {
		for (int index = 0; index < this.listaIngressos.size(); index++) {
			Ingresso ingresso = this.listaIngressos.get(index);
			System.out.print(ingresso.toString());
			
			if (index < this.listaIngressos.size() - 1) {
				System.out.print(", ");
			} else {
				System.out.println("");
			}
			
		}
		
	}

}
