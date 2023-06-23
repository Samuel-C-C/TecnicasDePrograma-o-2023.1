package control;

import java.util.Random;

/**
 * gera numeros aleatorios
 * 
 * @author Samuel
 */
public class GeradorNumeroAleatorio {
	
	/**
	 * Usa um gerador {@code Random} para criar numeros
	 * 
	 * @see Random
	 */
	private Random geradorAleatorio;
	
	/**
	 * Cria o gerador
	 */
	public GeradorNumeroAleatorio() {
		geradorAleatorio = new Random();
	}
	
	/**
	 * cria um número inteiro aleatorio dentro do intervalo fechado
	 * [minimo, maximo]
	 * 
	 * @param minimo menor número que o método pode retornar
	 * @param maximo maior número que o método pode retornar
	 * 
	 * @return um número aleatorio dentro do intervalo fechado [minimo, maximo]
	 */
	public int numeroAleatorio(int minimo, int maximo) {
		
		if (maximo < minimo) {
			maximo += minimo;
			minimo = maximo - minimo;
			maximo -= minimo;
		}
		
		return Math.abs(geradorAleatorio.nextInt() % (maximo - minimo)) + minimo;
	}

}
