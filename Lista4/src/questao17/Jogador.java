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
		
		boolean espacoOcupado;
		do {
			System.out.print("linha: ");
			linha = teclado.nextInt();
			
			System.out.print("coluna: ");
			coluna = teclado.nextInt();
			
			espacoOcupado = jogo.verificarPosicao(linha - 1, coluna - 1);
			if (espacoOcupado) {
				System.out.println("espaço ocupado\n");
			}
			
		} while (espacoOcupado);
		
		jogo.escreverGrade(linha - 1, coluna - 1);
		
	}

}
