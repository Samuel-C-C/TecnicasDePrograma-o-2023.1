import java.util.Scanner;

public class Questao05 {
	
	public static int[] copiaVetorInteiro(int vetorBase[]) {
		
		int vetorCopia[] = new int[vetorBase.length];
		
		for (int index = 0; index < vetorBase.length; index++) {
			
			vetorCopia[index] = vetorBase[index];
			
		}
		
		return vetorCopia;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Cópia de vetor: Sua função deverá receber um vetor e retornar uma cópia 
		 * exata desse vetor.
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
		
		int vetorCopia[] = copiaVetorInteiro(vetor);
		
		System.out.println("\nvetor copia:\n");
		
		for (int index = 0; index < vetorCopia.length; index++) {
			
			System.out.println("elemento " + index + ": " + vetorCopia[index]);
			
		}
		
		System.out.println("\nendereço vetor: " + vetor + "\nendereço vetor copia: " + vetorCopia);

	}

}
