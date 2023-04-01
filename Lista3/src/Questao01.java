
import java.util.Scanner;

public class Questao01 {
	
	public static int somatorio(int vetorNumerosASomar[]) {
		
		int soma = 0;
		
		for (int index = 0; index < vetorNumerosASomar.length; index++) {
			
			if (index != 0 && index != 1 && index != vetorNumerosASomar.length - 1 && index != vetorNumerosASomar.length - 2) {
				
				soma += vetorNumerosASomar[index];
				
			}
			
		}
		
		return soma;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Somatório: Sua função deverá receber um vetor como parâmetro e retornar 
		 * a soma de todos elementos do vetor, sendo que as primeiras duas e as 
		 * últimas posições do vetor de entrada não devem ser consideradas;
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
		
		int somatorio = somatorio(vetor);
		
		System.out.println("a soma dos valores é: " + somatorio);

	}

}
