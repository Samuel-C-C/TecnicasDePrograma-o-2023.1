import java.util.Scanner;

public class Questao14 {
	
	public static int[] removerElementoVetor(int[] vetor, int elemento) {
		
		int[] vetorTemporario = new int[vetor.length];
		int contador = 0;
		
		for (int index = 0; index < vetor.length; index++) {
			
			int elementoGenerico = vetor[index];
			
			if (elementoGenerico != elemento) {
				
				vetorTemporario[contador] = elementoGenerico;
				contador++;
				
			}
			
		}
		
		int[] vetorResultado = new int[contador];
		for (int index = 0; index < contador; index++) {
			
			vetorResultado[index] = vetorTemporario[index];
			
		}
		
		return vetorResultado;
		
	}

	public static void main(String[] args) {

		/*
		 * Remoção de elemento do vetor: Sua função deverá receber um vetor e um 
		 * elemento a ser removido. A função deve remover todas as ocorrências desse 
		 * elemento no vetor. Um novo vetor, apenas com elementos mantindos, deve 
		 * ser retornado: Exemplo: [1, 2, 3, 2, 4], 2 -> [1, 3, 4]
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("tamanho do vetor1: ");
		int tamanhoVetor1 = reader.nextInt();
		
		int vetor1[] = new int[tamanhoVetor1];
		
		for (int index = 0; index < tamanhoVetor1; index++) {
			System.out.print("elemento " + (index + 1) + ": ");
			vetor1[index] = reader.nextInt();
		}
		
		System.out.print("elemento a ser removido: ");
		int elementoASerRemovido = reader.nextInt();
		
		reader.close();
		
		int[] novoVetor = removerElementoVetor(vetor1, elementoASerRemovido);
		
		System.out.print("novo vetor sem o elemento " + elementoASerRemovido + ": ");
		
		for (int index = 0; index < novoVetor.length; index++) {
			
			System.out.print(novoVetor[index]);
			
			if (index < novoVetor.length - 1) {
				
				System.out.print(", ");
				
			} else {
				
				System.out.println("");
				
			}
			
		}

	}

}
