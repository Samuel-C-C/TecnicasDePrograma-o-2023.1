
import java.util.Scanner;

public class Questao02 {

	public static void main(String[] args) {
		
		/*
		 * Escreva um programa que leia uma sequência de números do usuário e 
		 * pare a leitura quando o usuário digitar um número negativo. Em seguida, 
		 * o programa deve imprimir a soma dos números positivos lidos.
		 */
		
		int soma = 0;
		int novoNumero = 0;
		
		Scanner reader = new Scanner(System.in);
		
		do {
			System.out.print("número: ");
			novoNumero = reader.nextInt();
			if (novoNumero >= 0) {
				soma += novoNumero;
			}
		} while (novoNumero >= 0);
		
		reader.close();
		
		System.out.println("soma dos números positivos lidos: " + soma);

	}

}
