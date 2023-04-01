import java.util.Scanner;

public class Questao09 {
	
	public static int KEsimoMenorValor(int[] vetorInteiro, int k) {
		
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
		
		if (k <= vetorOrdenado.length) {
		
			return vetorOrdenado[k - 1];
			
		} else {
			
			System.out.println("não há um K-ésimo menor valor");
			return 0;
					
		}
		
	}

	public static void main(String[] args) {
		
		/*
		 * K-ésimo menor valor: Sua função deverá receber um vetor e um K e 
		 * retornar o K-ésimo menor valor presente no vetor.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("tamanho do vetor: ");
		int tamanhoVetor = reader.nextInt();
		
		int vetor[] = new int[tamanhoVetor];
		
		for (int index = 0; index < tamanhoVetor; index++) {
			System.out.print("elemento " + (index + 1) + ": ");
			vetor[index] = reader.nextInt();
		}
		
		System.out.print("valor de k: ");
		int k = reader.nextInt();
		
		reader.close();
		
		int KEsimoMenorValor = KEsimoMenorValor(vetor, k);
		
		System.out.println("K-ésimo menor valor: " + KEsimoMenorValor);

	}

}