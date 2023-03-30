
import java.util.Scanner;

public class Questao08 {

	public static void main(String[] args) {
		
		/*
		 * Escreva um programa que utilize uma estrutura para determinar se uma 
		 * expressão matemática contendo parênteses, colchetes e chaves está 
		 * bem formada (ou seja, se cada símbolo de abertura tem um símbolo de 
		 * fechamento correspondente).
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("expressão matemática: ");
		String expressao = reader.nextLine();
		
		reader.close();
		
		String pilhaAbertura = "";
		boolean eBemFormada = true;
		
		for (int index = 0; index < expressao.length() && eBemFormada; index++) {
			
			char caractereASerVerificado = expressao.charAt(index);
			
			if (caractereASerVerificado == '(') {
				pilhaAbertura += "(";
			} else if (caractereASerVerificado == ')') {
				
				if (pilhaAbertura.endsWith("(")) {
					pilhaAbertura = pilhaAbertura.substring(0, pilhaAbertura.length() - 1);
				} else {
					eBemFormada = false;
				}
				
			} else if (caractereASerVerificado == '[') {
				pilhaAbertura += "[";
			} else if (caractereASerVerificado == ']') {
				
				if (pilhaAbertura.endsWith("[")) {
					pilhaAbertura = pilhaAbertura.substring(0, pilhaAbertura.length() - 1);
				} else {
					eBemFormada = false;
				}
				
			} else if (caractereASerVerificado == '{') {
				pilhaAbertura += "{";
			} else if (caractereASerVerificado == '}') {
				
				if (pilhaAbertura.endsWith("{")) {
					pilhaAbertura = pilhaAbertura.substring(0, pilhaAbertura.length() - 1);
				} else {
					eBemFormada = false;
				}
				
			}
			
		}
		
		if (pilhaAbertura.length() > 0) {
			eBemFormada = false;
		}
		
		if (eBemFormada) {
			System.out.println("a expressão " + expressao + " é bem formada");
		} else {
			System.out.println("a expressão " + expressao + " é mal formada");
		}

	}

}
