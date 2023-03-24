
public class Questao13 {

	public static void main(String[] args) {
		
		/*
		 * Verifique se A é maior que 10, se verdade imprima: "A > 10". Ainda, 
		 * verifique se o A mais B é igual a 20, se verdade imprima: "A + B == 20”. 
		 * Caso as afirmações não sejam verdadeiras, imprima: "números não válidos".
		 */
		
		int a = 10;
		int b = 10;
		
		if (a > 10) {
			System.out.println("A > 10");
		}
		
		if (a + b == 20) {
			System.out.println("A + B == 20");
		}
		
		if (!(a > 10 || a + b == 20)) {
			System.out.println("números não válidos");
		}
	}

}
