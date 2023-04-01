import java.util.Scanner;

public class Questao17 {
	
	public static String inverterString(String stringASerInvertida) {
		
		String stringInversa = "";
		
		for (int index = stringASerInvertida.length() - 1; index >= 0; index--) {
			
			stringInversa += stringASerInvertida.charAt(index);
			
		}
		
		return stringInversa;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Inversão de string: Sua função deverá receber uma string e retornar a 
		 * mesma string invertida. Exemplo: "hello" -> "olleh".
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("string para ser invertida: ");
		String stringASerInvertida = reader.nextLine();
		
		reader.close();
		
		String stringInvertida = inverterString(stringASerInvertida);
		
		System.out.println("resultado: " + stringInvertida);

	}

}
