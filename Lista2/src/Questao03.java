
import java.util.Scanner;
import java.util.Random;

public class Questao03 {

	public static void main(String[] args) {
		
		/*
		 * Escreva um programa que peça ao usuário para adivinhar um número 
		 * entre 1 e 100. Se o usuário adivinhar incorretamente, o programa deve 
		 * dizer se o número a ser adivinhado é maior ou menor do que o número 
		 * digitado pelo usuário. O programa deve continuar a pedir ao usuário que 
		 * adivinhe até que ele adivinhe corretamente.
		 */
		
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(1, 101);
		
		Scanner reader = new Scanner(System.in);
		
		int chosenNumber = 0;
		
		System.out.println("Advinhe um número entre 1 e 100");
		while (chosenNumber != randomNumber) {
			System.out.print("número: ");
			chosenNumber = reader.nextInt();
			
			if (chosenNumber > randomNumber) {
				System.out.println(chosenNumber + " é maior que o número secreto");
			} else if (chosenNumber < randomNumber) {
				System.out.println(chosenNumber + " é menor que o número secreto");
			} else {
				System.out.println("você acertou! " + randomNumber + " era o número secreto");
			}
		}
		
		reader.close();
		

	}

}
