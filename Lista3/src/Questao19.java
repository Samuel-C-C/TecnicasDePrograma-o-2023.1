import java.util.Scanner;
import java.util.ArrayList;

public class Questao19 {
	
	public static boolean verificarNumeroPerfeito(int numero) {
		
		ArrayList<Integer> divisores = new ArrayList<Integer>();
		
		for (int divisor = 1; divisor < numero; divisor++) {
			
			if (numero % divisor == 0) {
				
				divisores.add(divisor);
				
			}
			
		}
		
		int somaDivisores = 0;
		
		for (Integer divisor : divisores) {
			
			somaDivisores += divisor;
			
		}
		
		return somaDivisores == numero;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Verificação de número perfeito: Sua função deverá receber um número 
		 * inteiro e verificar se ele é um número perfeito, ou seja, se a soma dos seus 
		 * divisores próprios é igual a ele mesmo. Exemplo: 6 -> True
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("numero para verificar: ");
		int numero = reader.nextInt();
		
		reader.close();
		
		if (verificarNumeroPerfeito(numero)) {
			
			System.out.println(numero + " é um número perfeito");
			
		} else {
			
			System.out.println(numero + " não é um número perfeito");
			
		}

	}

}
