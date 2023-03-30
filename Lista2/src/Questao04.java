
import java.util.Scanner;

public class Questao04 {

	public static void main(String[] args) {
		
		/*
		 * Escreva um programa que imprima a tabela de multiplicação de um 
		 * número específico fornecido pelo usuário usando um loop while.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("número: ");
		int numeroEscolhido = reader.nextInt();
		
		reader.close();
		
		int fator = 1;
		while (fator <= 10) {
			System.out.print(numeroEscolhido * fator);
			
			if (fator < 10) {
				System.out.print(", ");
			} else {
				System.out.println(".");
			}
			
			fator++;
		}

	}

}
