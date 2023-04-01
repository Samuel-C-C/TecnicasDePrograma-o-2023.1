import java.util.Scanner;

public class Questao07 {
	

	private static boolean estaOrdenado(int[] vetor) {
		
		for (int index = 0; index < vetor.length - 1; index++) {
			
			if (vetor[index] > vetor[index + 1]) {
				
				return false;
				
			}
			
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		/*
		 * Verificação de ordenação: Sua função deverá receber um vetor e verificar 
		 * se ele está ordenado em ordem crescente. Se sim retornar true.
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
		
		if (estaOrdenado(vetor)) {
			
			System.out.println("o vetor está ordenado");
			
		} else {
			
			System.out.println("o vetor está desordenado");
			
		}

	}

}
