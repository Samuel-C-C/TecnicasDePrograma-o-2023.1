import java.util.Scanner;

public class Questao18 {
	
	public static float jurosCompostos(float valorInicial, float taxaJuros, int numeroPeriodos) {
		
		for (int i = 0; i < numeroPeriodos; i++) {
			
			valorInicial *= (1 + taxaJuros);
			
		}
		
		return valorInicial;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Cálculo de juros compostos: Sua função deverá receber um valor inicial, 
		 * uma taxa de juros e um número de períodos. A função deve retornar o valor 
		 * final após a aplicação dos juros compostos. Exemplo: 1000, 0.05, 3 -> 
		 * 1157.63
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("valor inicial: ");
		float valorInicial = reader.nextFloat();
		
		System.out.print("taxa de juros: ");
		float taxaJuros = reader.nextFloat();
		
		System.out.print("número de periodos: ");
		int numeroPeriodos = reader.nextInt();
		
		reader.close();
		
		float total = jurosCompostos(valorInicial, taxaJuros, numeroPeriodos);
		
		System.out.println("valor total: " + total);

	}

}
