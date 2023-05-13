package questao17;

import java.util.Scanner;

public class Jogador {
	
	public String nome;
	private JogoDaVelha jogo;
	
	public Jogador(String nome, JogoDaVelha jogo) {
		this.nome = nome;
		this.jogo = jogo;
	}
	
	public void jogar(Scanner teclado) {
		
		int linha, coluna;
		
		System.out.println(this.nome + ", sua vez!\n" + 
				"escolha uma posicao para jogar\n");
		
		boolean espacoInvalido;
		do {
			System.out.print("linha: ");
			linha = teclado.nextInt();
			
			System.out.print("coluna: ");
			coluna = teclado.nextInt();
			
			espacoInvalido = false;
			if (linha < 1 || linha > 3 || coluna < 1 || coluna > 3) {
				System.out.println("espaço inválido\n");
				espacoInvalido = true;
			} else if (jogo.verificarPosicao(linha - 1, coluna - 1)) {
				System.out.println("espaço ocupado\n");
				espacoInvalido = true;
			}
			
		} while (espacoInvalido);
		
		jogo.escreverGrade(linha - 1, coluna - 1);
		
	}

}
