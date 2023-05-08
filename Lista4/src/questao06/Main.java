package questao06;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends Object {

	public static void main(String[] args) {
		
		/*
		 * Crie uma implementação orientada a objetos conforme os passos abaixo: 
		 * a) Crie uma classe chamada Ingresso que possua um atributo valor e um 
		 * método toString que retorne à informação do valor do ingresso. 
		 * b) Crie uma classe IngressoVIP, que herda de Ingresso e possui um atributo 
		 * valor Adicional. O método toString da classe IngressoVIP deve considerar que o 
		 * valor do ingresso é o valor da superclasse somado ao valor Adicional do 
		 * IngressoVIP. 
		 * c) Crie uma classe evento que é composta de uma lista ingresso. 
		 * d) Crie um método para possibilitar uma venda um determinado ingresso 
		 * e) Crie um método para computar o valor total dos ingressos vendidos 
		 * f) Crie um método que permita mostrar os ingressos que não foram vendidos 
		 * c) Crie uma classe para testar os objetos das classes Ingresso e IngressoVIP
		 */
		
		ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>();
		
		for (int i = 0; i < 30; i++) {
			listaIngressos.add(new Ingresso(12.50));
		}
		
		for (int i = 0; i < 10; i++) {
			listaIngressos.add(new IngressoVIP(12.50, 7.50));
		}
		
		Evento festa = new Evento(listaIngressos);
		
		int numeroIngressosASeremComprados = ThreadLocalRandom.current().nextInt(1, 30 + 1);
		for (int i = 0; i < numeroIngressosASeremComprados; i++) {
			
			int indexIngressoASerComprado = ThreadLocalRandom.current().nextInt(0, festa.getListaIngressos().size());
			Ingresso ingressoASerComprado = festa.getListaIngressos().get(indexIngressoASerComprado);
			festa.venderIngresso(ingressoASerComprado);
		}
		
		festa.mostrarTodosIngressosNaoVendidos();
		System.out.println("total vendido: " + festa.totalVendido());

	}

}
