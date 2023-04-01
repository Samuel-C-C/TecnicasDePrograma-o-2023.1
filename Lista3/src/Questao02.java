
import java.util.Scanner;

public class Questao02 {
	
	public static float media(int vetor1[], int vetor2[]) {
		
		float media = 0;
		
		for (int indexVetor1 = 0; indexVetor1 < vetor1.length; indexVetor1++) {
			media += vetor1[indexVetor1];
		}
		
		for (int indexVetor2 = 0; indexVetor2 < vetor2.length; indexVetor2++) {
			media += vetor2[indexVetor2];
		}
		
		media /= (vetor1.length + vetor2.length);
		
		return media;
				
	}

	public static void main(String[] args) {
		
		/*
		 * Média: Sua função deverá receber dois vetores como entrada e retornar a 
		 * média dos valores presentes nos vetores.
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
		
		float media = media(vetor1, vetor2);
		
		System.out.println("a média dos valores presentes nos vetores é: " + media);

	}

}
