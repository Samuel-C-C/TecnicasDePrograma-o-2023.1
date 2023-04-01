import java.util.Scanner;

public class Questao10 {
	
	public static boolean saoIguais(int[] vetor1, int[] vetor2) {
		
		if (vetor1.length == vetor2.length) {
			
			for (int index = 0; index < vetor2.length; index++) {
				
				if (vetor1[index] != vetor2[index]) {
					
					return false;
					
				}
				
			}
			
		} else {
			
			return false;
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Verificação de igualdade: Sua função deverá receber dois vetores e verificar 
		 * se eles são iguais, ou seja, se possuem os mesmos elementos na mesma 
		 * ordem.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("tamanho do vetor1: ");
		int tamanhoVetor1 = reader.nextInt();
		
		int vetor1[] = new int[tamanhoVetor1];
		
		for (int index = 0; index < tamanhoVetor1; index++) {
			System.out.print("elemento " + (index + 1) + ": ");
			vetor1[index] = reader.nextInt();
		}
		
		System.out.print("tamanho do vetor2: ");
		int tamanhoVetor2 = reader.nextInt();
		
		int vetor2[] = new int[tamanhoVetor2];
		
		for (int index = 0; index < tamanhoVetor2; index++) {
			System.out.print("elemento " + (index + 1) + ": ");
			vetor2[index] = reader.nextInt();
		}
		
		reader.close();
		
		if (saoIguais(vetor1, vetor2)) {
			
			System.out.println("os dois vetores são equivalentes");
			
		} else {
			
			System.out.println("os dois vetores são diferentes");
			
		}

	}

}
