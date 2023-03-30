
import java.util.Scanner;

public class Questao06 {

	public static void main(String[] args) {
		
		/*
		 * Escreva um programa que utilize uma estrutura "if-else" para verificar se 
		 * uma matriz é simétrica (ou seja, a matriz é igual à sua transposta).
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("tamanho da matriz quadrada: ");
		int numeroLinhasEColunas = reader.nextInt();
		
		int matriz[][] = new int[numeroLinhasEColunas][numeroLinhasEColunas];
		
		for (int linha = 1; linha <= numeroLinhasEColunas; linha++) {
			for (int coluna = 1; coluna <= numeroLinhasEColunas; coluna++) {
				System.out.print("elemento " + linha + ", " + coluna + ": ");
				matriz[linha - 1][coluna - 1] = reader.nextInt();
			}
		}
		
		reader.close();
		boolean isSymmetrical = true;
		
		for (int linha = 2; linha <= numeroLinhasEColunas && isSymmetrical; linha++) {
			for (int coluna = 1; coluna <= numeroLinhasEColunas - linha && isSymmetrical; coluna++) {
				
				isSymmetrical = matriz[linha - 1][coluna - 1] == matriz[coluna - 1][linha - 1];

			}
		}
		
		if (isSymmetrical) {
			System.out.println("a matriz é simétrica");
		} else {
			System.out.println("a matriz não é simétrica");
		}
		
	}

}
