import java.util.Scanner;

public class Questao04 {
	
	public static int contagem(int vetor1[], int vetor2[], int valorASerProcuradao) {
		
		int quantasVezesFoiEncontrado = 0;
		
		for (int indexVetor1 = 0; indexVetor1 < vetor1.length; indexVetor1++) {
			if (vetor1[indexVetor1] == valorASerProcuradao) {
				quantasVezesFoiEncontrado++;
			}
		}
		
		for (int indexVetor2 = 0; indexVetor2 < vetor2.length; indexVetor2++) {
			if (vetor2[indexVetor2] == valorASerProcuradao) {
				quantasVezesFoiEncontrado++;
			}
		}
		
		return quantasVezesFoiEncontrado;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Contagem de elementos: Sua função deverá receber dois vetores e um 
		 * elemento a ser contado. A função deve retornar a quantidade de vezes que 
		 * esse elemento aparece nos vetores. Exemplo: [1,3, 3, 2, 5],[1, 2, 3, 2, 4], 
		 * 2 -> 3
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
		
		System.out.print("valor a ser procurado nesses vetores: ");
		int valor = reader.nextInt();
		
		reader.close();
		
		int vezes = contagem(vetor1, vetor2, valor);
		
		System.out.println("o número de vezes que " + valor + 
				" foi encontrado nos dois vetores é: " + vezes);

	}

}
