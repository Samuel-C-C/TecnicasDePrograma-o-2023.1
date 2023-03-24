
public class Questao07 {

	public static void main(String[] args) {
		
		/*
		 * Verifique se A é maior que 10 ou se o A mais B é igual a 20, caso sejam 
		 * verdadeiras as afirmações imprima: "números válidos”. Caso a primeira 
		 * afirmação não seja verdadeira, imprima: "número não válido".
		 */

		int a = 13;
		int b = 7;
		
		if (a > 10 || a + b == 20) {
			System.out.println("números válidos");
		}
		
		if (!(a > 10)) {
			System.out.println("número não válido");
		}
		
	}

}
