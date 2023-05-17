package apresentacao;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Terminal implements EntradaSaida {
	
	Scanner teclado;
	
	public Terminal() {
		this.teclado = new Scanner(System.in);
	}

	public String pedirString(String mensagem) {
		System.out.print(mensagem + ": ");
		return teclado.nextLine();
	}

	public int pedirInteiro(String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem + ": ");
				return teclado.nextInt();
				
			} catch (InputMismatchException e) {
				this.escreverMensagem("Valor inválido! Digite novamente");
			}
		}
	}

	public void escreverMensagem(String mensagem) {
		System.out.println(mensagem);
		
	}

	public boolean pedirBoolean(String mensagem) {
		String resposta = "";
		
		do {
			System.out.print(mensagem + "(y/n): ");
			
			while (resposta.equals("")) {
				resposta = teclado.nextLine();
			}
			
			if (!resposta.equals("y") && !resposta.equals("n")) {
				System.out.println("Resposta inválida! Digite novamente");
			}
			
		} while (!resposta.equals("y") && !resposta.equals("n"));
		
		return resposta.equals("y");
	}

}
