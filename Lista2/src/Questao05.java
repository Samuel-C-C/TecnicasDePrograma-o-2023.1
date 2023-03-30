
import java.util.Scanner;

public class Questao05 {

	public static void main(String[] args) {
		
		/*
		 * Faça um programa que possa exibir uma sequência como a abaixo, 
		 * sendo o limite superior dos pares da esquerda e direita informados pelo 
		 * usuário. Exemplo: com pares da esquerda e direta com o limite superior 
		 * de 2 unidades. 
		 * 0 - 0 
		 * 0 - 1 
		 * 0 - 2 
		 * 1 - 0 
		 * 1 - 1 
		 * 1 - 2 
		 * 2 - 0 
		 * 2 - 1 
		 * 2 - 2
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("limite superior: ");
		int superiorLimit = reader.nextInt();
		
		reader.close();
		
		for (int i = 0; i <= superiorLimit; i++) {
			for (int j = 0; j <= superiorLimit; j++) {
				System.out.println(i + " - " + j);
			}
		}
	}

}
