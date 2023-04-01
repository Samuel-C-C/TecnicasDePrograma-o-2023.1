
import java.util.Scanner;

public class Questao03 {
	
	public static float mediaPonderada(int vetorNotas[], int vetorPesos[]) {
		
		float mediaPonderada = 0;
		int somaPesos = 0;
		
		for (int index = 0; index < vetorNotas.length; index++) {
			
			mediaPonderada += vetorNotas[index] * vetorPesos[index];
			somaPesos += vetorPesos[index];
		}
		
		mediaPonderada /= somaPesos;
		
		return mediaPonderada;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Média ponderada: Sua função deverá receber um vetor de notas e um vetor 
		 * de pesos correspondentes. A função deve retornar a média ponderada das 
		 * notas. Exemplo: [7, 8, 6], [2, 3, 1] -> 7.33
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("número de notas: ");
		int numeroDeNotas = reader.nextInt();
		
		int notas[] = new int[numeroDeNotas];
		int pesos[] = new int[numeroDeNotas];
		
		for (int index = 0; index < numeroDeNotas; index++) {
			
			System.out.print("nota " + (index + 1) + ": ");
			notas[index] = reader.nextInt();
			
			System.out.print("peso " + (index + 1) + ": ");
			pesos[index] = reader.nextInt();
			
		}
		
		reader.close();
		
		float media = mediaPonderada(notas, pesos);
		
		System.out.println("a média ponderadas dass notas é: " + media);

	}

}
