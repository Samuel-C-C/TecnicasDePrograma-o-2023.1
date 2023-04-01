
import java.util.Scanner;
import java.util.ArrayList;

public class Questao16 {
	
	public static boolean verificarSeEPrimo(ArrayList<Integer> primosLista, int numero) {
		
		for (Integer primo : primosLista) {
			
			if (numero % primo == 0) {
				
				return false;
				
			}
			
			if (primo >= numero) {
				
				return true;
				
			}
			
		}
		
		int ultimoPrimo = primosLista.get(primosLista.size() - 1);
		int candidatoAPrimo = ultimoPrimo + 1;
		
		while (ultimoPrimo < numero) {
			
			boolean ePrimo = true;
			
			for (int index = 0; index < primosLista.size() && ePrimo; index++) {
				
				int primo = primosLista.get(index);
				
				if (candidatoAPrimo % primo == 0) {
					
					ePrimo = false;
					
				}
				
			}
			
			if (ePrimo) {
				
				primosLista.add(candidatoAPrimo);
				
				ultimoPrimo = primosLista.get(primosLista.size() - 1);
				
				if (ultimoPrimo >= numero) {
					
					return true;
					
				}
				
			}
			
			candidatoAPrimo++;
			
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Verificação de número primo: Sua função deverá receber um número 
		 * inteiro e verificar se ele é um número primo. Exemplo: 7 -> True.
		 */
		
		ArrayList<Integer> primos = new ArrayList<Integer>();
		primos.add(2);
		primos.add(3);
		primos.add(5);
		primos.add(7);
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("numero para verificar se é primo: ");
		int numeroParaSerVerificado = reader.nextInt();
		
		reader.close();
		
		if (verificarSeEPrimo(primos, numeroParaSerVerificado)) {
			
			System.out.println(numeroParaSerVerificado + " é primo");
			
		} else {
			
			System.out.println(numeroParaSerVerificado + " não é primo");
			
		}

	}

}
