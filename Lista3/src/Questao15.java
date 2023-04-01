import java.util.Scanner;

public class Questao15 {
	
	public static boolean checarPalindromo(String stringGenerica) {
		
		for (int index = 0; index < stringGenerica.length() / 2; index++) {
			
			if (stringGenerica.charAt(index) != stringGenerica.charAt(stringGenerica.length() - index - 1)) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Verificação de palíndromo: Sua função deverá receber uma string e 
		 * verificar se ela é um palíndromo, ou seja, se pode ser lida da mesma forma 
		 * de trás para frente. Exemplo: "ana" -> True.
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("string: ");
		String stringASerVerificada = reader.nextLine();
		
		reader.close();
		
		if (checarPalindromo(stringASerVerificada)) {
			
			System.out.println(stringASerVerificada + " é um palindromo");
			
		} else {
			
			System.out.println(stringASerVerificada + " não é um palindromo");
			
		}

	}

}
