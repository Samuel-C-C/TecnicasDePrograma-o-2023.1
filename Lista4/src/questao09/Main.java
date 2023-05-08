package questao09;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Crie uma classe que será chamada de Forma. A classe Forma é composta 
		 * dos métodos calcularArea e imprimirNome. Crie as classes Círculo, 
		 * Retângulo, Quadrado e Triângulo. Cada classe deverá ter os métodos 
		 * calcularArea e imprimirNome. Porém, para cada classe deverá implementar 
		 * as operações segundo cada forma geométrica. Por exemplo, o quadrado 
		 * deverá calcular a área segundo o quadrado e imprimir o nome “quadrado”. 
		 * Utilize os recursos da orientação a objetos para modelar os requisitos acima.
		 */
		
		Circulo circulo = new Circulo(2);
		circulo.imprimirNome();
		System.out.println("area: " + circulo.calcularArea());
		
		Retangulo retangulo = new Retangulo(2, 3);
		retangulo.imprimirNome();
		System.out.println("area: " + retangulo.calcularArea());
		
		Quadrado quadrado = new Quadrado(3);
		quadrado.imprimirNome();
		System.out.println("area: " + quadrado.calcularArea());
		
		Triangulo triangulo = new Triangulo(5, 1);
		triangulo.imprimirNome();
		System.out.println("area: " + triangulo.calcularArea());

	}

}
