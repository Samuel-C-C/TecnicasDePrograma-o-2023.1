
import java.util.Scanner;

public class Questao07 {
	
	public static int encontrarPrimo(int primos[], int indexUltimoPrimo) {
		int candidatoAPrimo = primos[indexUltimoPrimo] + 1;
		
		boolean isPrime = false;
		
		while (!isPrime) {
			
			isPrime = true;
			for (int index = 0; index <= indexUltimoPrimo && isPrime; index++) {
				isPrime = candidatoAPrimo % primos[index] != 0;
			}
			
			if (!isPrime) {
				candidatoAPrimo++;
			}
			
		}
		
		return candidatoAPrimo;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Crie um programa que use um loop "while" para encontrar o maior 
		 * número primo que é menor do que um número fornecido pelo usuário.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("número: ");
		int limiteSuperior = reader.nextInt();
		
		reader.close();
		
		int primos[] = new int[1000];
		int indexMaiorPrimo = 0;
		
		primos[0] = 2;
		
		while (primos[indexMaiorPrimo] < limiteSuperior) {
			
			primos[indexMaiorPrimo + 1] = encontrarPrimo(primos, indexMaiorPrimo);
			indexMaiorPrimo++;
			
		}
		
		if (indexMaiorPrimo > 0) {
			System.out.println("maior primo menor que " + limiteSuperior + ": " + primos[indexMaiorPrimo - 1]);
		} else {
			System.out.println("não há primos menores que " + limiteSuperior);
		}
	}

}
