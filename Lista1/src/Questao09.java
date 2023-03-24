
public class Questao09 {

	public static void main(String[] args) {
		
		/*
		 * Verifique se A é maior que 10 e verifique se A mais B é igual a 20, se 
		 * verdadeiro, imprima: "A + B == 20''. Caso as afirmações não forem 
		 * verdadeiras imprima: "número não válido".
		 */
		
		int a = 10;
		int b = 10;
		
		if (a > 10) {
			;
		}
		
		if (a + b == 20) {
			System.out.println("A + B == 20");
		}
		
		if (!(a > 10 || a + b == 20)) {
			System.out.println("número não válido");
		}

	}

}
