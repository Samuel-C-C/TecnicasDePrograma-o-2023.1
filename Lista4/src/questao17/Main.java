package questao17;

import java.util.Scanner;

public class Main {
	
	public static boolean jogoContinua(Jogador jogador1, Jogador jogador2, JogoDaVelha jogo) {
		String resultado = jogo.verificarResultado();
		
		if (resultado.equals("vitoria jogador x")) {
			System.out.println("");
			System.out.println(jogo.gradeString());
			System.out.println("");
			System.out.println(jogador1.nome + " vence");
			return false;
			
		} else if (resultado.equals("vitoria jogador o")) {
			System.out.println("");
			System.out.println(jogo.gradeString());
			System.out.println("");
			System.out.println(jogador2.nome + " vence");
			return false;
			
		} else if (resultado.equals("empate")) {
			System.out.println("");
			System.out.println(jogo.gradeString());
			System.out.println("");
			System.out.println(jogador1.nome + " e " + jogador2.nome + " empatam");
			return false;
			
		} else {
			return true;
		}
		
	}

	public static void main(String[] args) {
		
		/*
		 * Escreva um programa completo para jogar o jogo da velha. Para tanto crie 
		 * uma classe Jogo da Velha (OBS: apenas terminal, ainda não estudamos 
		 * interface gráfica): 
		 * a. A classe deve conter como dados privados um array bidimensional 3x3 
		 * para representar a grade do jogo. 
		 * b. Utilize uma variável do tipo String para representar as possibilidades de 
		 * ocupação de uma casa na grade (vazia, jogador 1 ou jogador 2) 
		 * c. O construtor deve inicializar a grade como vazia 
		 * d. Forneça um método para exibir a grade 
		 * e. Permitir dois jogadores humanos 
		 * f. Forneça um método para jogar o jogo; todo movimento deve ocorrer em 
		 * uma casa vazia; depois de cada movimento, determine se houve uma derrota ou um 
		 * empate.
		 */
		
		JogoDaVelha jogo =  new JogoDaVelha();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("nome jogador X: ");
		Jogador jogador1 = new Jogador(teclado.nextLine(), jogo);
		
		System.out.print("nome jogador O: ");
		Jogador jogador2 = new Jogador(teclado.nextLine(), jogo);
		
		boolean primeiroJogador = true;
		
		boolean continuarJogo = true;
		do {
			
			System.out.println("");
			System.out.println(jogo.gradeString());
			System.out.println("");
			
			if (jogo.jogadorVez) {
				jogador1.jogar(teclado);
			} else {
				jogador2.jogar(teclado);
			}
			
			if (!jogoContinua(jogador1, jogador2, jogo)) {
				int resposta;
				
				do {
					System.out.println("");
					System.out.print("jogar de novo? (1/0): ");
					resposta = teclado.nextInt();
					
					if (resposta != 1 && resposta != 0) {
						System.out.println("resposta invalida");
					}
					
				} while (resposta != 1 && resposta != 0);
				
				if (resposta == 1) {
					jogo.reiniciarJogo();
					primeiroJogador = !primeiroJogador;
					jogo.jogadorVez = primeiroJogador;
					
				} else {
					continuarJogo = false;
				}
				
			}
			
		} while (continuarJogo);
		
		teclado.close();
		
		System.out.println("");
		System.out.println("obrigado por jogar <3");

	}

}
