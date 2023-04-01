
import java.util.Scanner;

public class Questao11 {
	
	public static int potencia(int base, int expoente) {
		
		int resultado = 1;
		
		for (int i = 0; i < expoente; i++) {
			
			resultado *= base;
			
		}
		
		return resultado;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Potenciação: Sua função deverá receber dois números, a base e o 
		 * expoente, e retornar a potência da base elevada ao expoente.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("base: ");
		int base = reader.nextInt();
		
		System.out.print("expoente: ");
		int expoente = reader.nextInt();
		
		reader.close();
		
		int resultado = potencia(base, expoente);
		
		System.out.println( base + " elevado a " + expoente + " é: " + resultado);
		

	}

}
