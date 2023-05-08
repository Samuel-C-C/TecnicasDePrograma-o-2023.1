package questao09;

import java.lang.Math;

public class Circulo extends Forma {
	
	public double raio;
	
	public Circulo(double raio) {
		super();
		this.raio = raio;
		
	}

	public double calcularArea() {
		return Math.PI * Math.pow(raio, 2);
	}

	public void imprimirNome() {
		System.out.println("circulo");
	}
	
}
