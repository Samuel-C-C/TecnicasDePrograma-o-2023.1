import java.util.Scanner;

public class Questao13 {
	
	public static int[] buscaOcorrencias(int[] vetor1, int[] vetor2) {
		
		int tamanhoMenorVetor = 0;
		
		if (vetor1.length < vetor2.length) {
			tamanhoMenorVetor = vetor1.length;
		} else {
			tamanhoMenorVetor = vetor2.length;
		}
		
		int[] vetorOcorrenciasTemporario = new int[tamanhoMenorVetor];
		int contador = 0;
		
		for (int indexVetor1 = 0; indexVetor1 < vetor1.length; indexVetor1++) {
			
			boolean equivalenteEcontrado = false;
			
			int valoresCortadosVetor2 = 0;
			
			for (int indexVetor2 = 0; indexVetor2 < vetor2.length - valoresCortadosVetor2 && !equivalenteEcontrado; indexVetor2++) {
				
				if (vetor1[indexVetor1] == vetor2[indexVetor2]) {
					
					vetorOcorrenciasTemporario[contador] = vetor1[indexVetor1];
					contador++;
					
					for (int index = indexVetor2; index < vetor2.length - valoresCortadosVetor2 - 1; index++) {
						
						vetor2[index] = vetor2[index + 1];
						
					}
					
					valoresCortadosVetor2++;
					
					equivalenteEcontrado = true;
					
				}
				
			}
			
		}
		
		int[] vetorOcorrencias = new int[contador];
		
		for (int index = 0; index < contador; index++) {
			
			vetorOcorrencias[index] = vetorOcorrenciasTemporario[index];
			
		}
		
		return vetorOcorrencias;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Busca por ocorrências: Sua função deverá receber dois vetores e deverá 
		 * retornar um novo vetor com todos os elementos que aparecem em ambos os 
		 * vetores.
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
		
		System.out.println("\nelementos que aparecem em ambos os vetores: ");
		
		int[] vetorOcorrencias = buscaOcorrencias(vetor1, vetor2);
		
		for (int index = 0; index < vetorOcorrencias.length; index++) {
			System.out.print(vetorOcorrencias[index]);
			
			if (index < vetorOcorrencias.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("");
			}
		}
		
	}

}
