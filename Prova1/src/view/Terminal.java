package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Terminal implements EntradaSaida {
	
	private Scanner teclado;
	
	public Terminal() {
		this.teclado = new Scanner(System.in);
	}

	public String pedirString(String mensagem) {
		this.escrever(mensagem);
		return this.teclado.nextLine();
	}

	public int pedirInt(String mensagem) {
		while (true) {
			try {
				this.escrever(mensagem);
				return teclado.nextInt();
				
			} catch (InputMismatchException e) {
				this.escreverln("Valor inválido! digite novamente");
			}
		}
	}

	public boolean pedirBoolean(String mensagem, String trueString, String falseString) {
		String resposta;
		
		while (true) {
			this.escrever(mensagem);
			teclado.nextLine();
			resposta = teclado.nextLine();
			
			if (resposta.equals(trueString)) {
				return true;
			} else if (resposta.equals(falseString)) {
				return false;
			} else {
				this.escreverln("Resposta inválida! digite novamente");
			}
		}
	}
	
	public int pedirOpcao(String mensagem, ArrayList<String> opcoes) {
		int resposta;
		
		do {
			this.escreverln(mensagem);
			
			for (int index = 0; index < opcoes.size(); index++) {
				this.escreverln((index + 1) + " - " + opcoes.get(index));
			}
			resposta = this.pedirInt("> ");
			
			if (resposta < 1 || resposta > opcoes.size()) {
				this.escreverln("Opção inválida! escolha novamente");
			}
			
		} while (resposta < 1 || resposta > opcoes.size());
		
		return resposta;
	}

	public void escreverln(String string) {
		this.escrever(string + "\n"); 
	}

	public void escrever(String string) {
		System.out.print(string);
	}

}
