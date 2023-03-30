
import java.util.Scanner;

public class Questao10 {
	
	public static void escreverMatriz(char[][] matriz) {
		
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
				System.out.print(matriz[linha][coluna] + " ");
			}
			System.out.print("\n");
		}
		
	}

	public static void main(String[] args) {
		
		/*
		 * Para cada item abaixo imprima as formas apresentadas. Permita que o 
		 * usuário escolha o número de linhas e colunas desejadas. No exemplo 
		 * abaixo, para cada matriz foram utilizadas 5 linhas e 5 colunas. Porém, 
		 * independentemente do número de linhas e colunas, as formas devem 
		 * ser mantidas. As matrizes sempre serão quadradas.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("número de linhas e colunas: ");
		int linhasEColunas = reader.nextInt();
		
		reader.close();
		
		int metade = linhasEColunas / 2;
		
		char matrizASerPrintada[][] = new char[linhasEColunas][linhasEColunas];
		
		for (int linha = 0; linha < linhasEColunas; linha++) {
			for (int coluna = 0; coluna < linhasEColunas; coluna++) {
				
				if (coluna > linha) {
					matrizASerPrintada[linha][coluna] = ' ';
				} else {
					matrizASerPrintada[linha][coluna] = (char)(coluna % 10 + '0');
				}
				
			}
			
		}
		
		escreverMatriz(matrizASerPrintada);
		
		for (int linha = 0; linha < linhasEColunas; linha++) {
			for (int coluna = 0; coluna < linhasEColunas; coluna++) {
				
				if ((coluna + linha) % 2 == 0) {
					matrizASerPrintada[linha][coluna] = '@';
				} else {
					matrizASerPrintada[linha][coluna] = '*';
				}
				
			}
			
		}
		
		System.out.println("");
		escreverMatriz(matrizASerPrintada);
		
		for (int linha = 0; linha < linhasEColunas; linha++) {
			for (int coluna = 0; coluna < linhasEColunas; coluna++) {
				
				if (linha == metade || coluna == metade) {
					matrizASerPrintada[linha][coluna] = '@';
				} else {
					if (linha % 2 == 1) {
						int numero = coluna;
						matrizASerPrintada[linha][coluna] = (char)((numero) % 10 + '0');
					} else {
						int numero = linhasEColunas - coluna - 1;
						matrizASerPrintada[linha][coluna] = (char)((numero) % 10 + '0');
					}
				}
				
			}
			
		}
		
		System.out.println("");
		escreverMatriz(matrizASerPrintada);
		
		for (int linha = 0; linha < linhasEColunas; linha++) {
			for (int coluna = 0; coluna < linhasEColunas; coluna++) {
				
				if (linha == 0 || coluna == 0 || linha == linhasEColunas - 1 || coluna == linhasEColunas - 1) {
					
					int numero = linha + coluna;
					if (numero >= linhasEColunas) {
						numero = 2 * linhasEColunas - numero - 2;
					}
					
					matrizASerPrintada[linha][coluna] = (char)((numero) % 10 + '0');
				} else {
					matrizASerPrintada[linha][coluna] = '*';
				}
				
			}
			
		}
		
		System.out.println("");
		escreverMatriz(matrizASerPrintada);
		
		
		for (int linha = 0; linha < linhasEColunas; linha++) {
			for (int coluna = 0; coluna < linhasEColunas; coluna++) {
				
				if (coluna < metade) {
					
					if (linha < metade) {
						matrizASerPrintada[linha][coluna] = '#';
					} else if (linha == metade) {
						matrizASerPrintada[linha][coluna] = '=';
					} else {
						matrizASerPrintada[linha][coluna] = '*';
					}
					
				} else if (coluna == metade) {
					
					matrizASerPrintada[linha][coluna] = '|';
					
				} else {
					
					if (linha < metade) {
						matrizASerPrintada[linha][coluna] = '!';
					} else if (linha == metade) {
						matrizASerPrintada[linha][coluna] = '=';
					} else {
						matrizASerPrintada[linha][coluna] = '%';
					}
					
				}
				
			}
			
		}
		
		System.out.println("");
		escreverMatriz(matrizASerPrintada);
		
		for (int linha = 0; linha < linhasEColunas; linha++) {
			for (int coluna = 0; coluna < linhasEColunas; coluna++) {
				
				if (linha == coluna || linha + coluna == linhasEColunas - 1) {
					matrizASerPrintada[linha][coluna] = (char)((coluna) % 10 + '0');
				} else {
					matrizASerPrintada[linha][coluna] = '*';
				}
				
			}
			
		}
		
		System.out.println("");
		escreverMatriz(matrizASerPrintada);

	}

}
