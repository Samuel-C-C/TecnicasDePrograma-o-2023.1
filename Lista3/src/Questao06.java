import java.util.Scanner;

public class Questao06 {
	
	public static int[] ordenarCrescente(int[] vetorInteiro) {
		
		int vetorOrdenado[] = new int[vetorInteiro.length];
		
		for (int index = 0; index < vetorInteiro.length; index++) {
			
			vetorOrdenado[index] = vetorInteiro[index];
			
		}
		
		// bubble sort
		
		boolean ordenado = false;
		
		while (!ordenado) {
			
			ordenado = true;
			
			for (int index = 0; index < vetorOrdenado.length - 1; index++) {
				
				if (vetorOrdenado[index] > vetorOrdenado[index + 1]) {
					
					ordenado = false;
					
					int variavelDeTransicao = vetorOrdenado[index + 1];
					vetorOrdenado[index + 1] = vetorOrdenado[index];
					vetorOrdenado[index] = variavelDeTransicao;
					
				}
				
			}
			
		}
		
		return vetorOrdenado;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Ordenação crescente: Sua função deverá receber um vetor e retornar o 
		 * vetor ordenado em ordem crescente. Exemplo: [5, 2, 9, 1, 7] -> [1, 2, 5, 7, 9]
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("tamanho do vetor: ");
		int tamanhoVetor = reader.nextInt();
		
		int vetor[] = new int[tamanhoVetor];
		
		for (int index = 0; index < tamanhoVetor; index++) {
			System.out.print("elemento " + (index + 1) + ": ");
			vetor[index] = reader.nextInt();
		}
		
		reader.close();
		
		int vetorOrdenado[] = ordenarCrescente(vetor);
		
		System.out.println("\nvetor ordenado:\n");
		
		for (int index = 0; index < vetorOrdenado.length; index++) {
			
			System.out.println("elemento " + index + ": " + vetorOrdenado[index]);
			
		}

	}

}
