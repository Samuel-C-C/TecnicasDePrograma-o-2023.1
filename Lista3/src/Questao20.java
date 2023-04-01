import java.util.Scanner;

public class Questao20 {
	
	public static void diminuicaoVetor (int numeroQualquer) {
		
		Scanner readerFuncao = new Scanner(System.in);
		
		int[] vetor = new int[numeroQualquer];
		
		for (int index = 0; index < vetor.length; index++) {
			
			System.out.print("elemento " + (index + 1) + ": ");
			vetor[index] = readerFuncao.nextInt();
			
		}
		
		readerFuncao.close();
		
		int tamanhoVetor = numeroQualquer;
		
		System.out.println("");
		
		while (tamanhoVetor >= 1) {
			
			for (int index = 0; index < vetor.length; index++) {
				
				if (index == 0) {
					
					System.out.print("[");
					
				}
				
				System.out.print(vetor[index]);
				
				if (index < vetor.length - 1) {
					
					System.out.print(", ");
					
				} else {
					
					System.out.println("]\n");
					
				}
				
			}
			
			int[] novoVetor = new int[tamanhoVetor - 1];
			
			for (int index = 0; index < novoVetor.length; index++) {
				
				novoVetor[index] = vetor[index];
				
			}
			
			vetor = novoVetor;
			tamanhoVetor--;
			
		}
		
	}

	public static void main(String[] args) {
		
		/*
		 * Diminuição do vetor: sua função deverá receber um número qualquer que 
		 * represente e criar um vetor com o tamanho informado. Este vetor deverá ter 
		 * sucessivas diminuições do seu tamanho em um unidade até que seu 
		 * tamanho seja igual a 1.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("número qualquer: ");
		int numeroQualquer = reader.nextInt();
		
		diminuicaoVetor(numeroQualquer);
		
		reader.close();

	}

}
