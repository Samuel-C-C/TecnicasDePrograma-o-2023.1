package jogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import entidade.*;
import exceptions.OutOfPlaneException;
import robo.*;
import tabuleiro.*;
import view.*;

public class Jogo {
	
	private EntradaSaida IO;
	private Jogador jogador;
	private Plano plano;
	
	public void iniciarJogo() {
		this.IO = new Terminal();
		
		// pedir nome jogador
		this.jogador = new Jogador(this.IO.pedirString("digite seu nome: "));
		
		// pedir tamanho X Y do Plano
		this.plano = new Plano(this.pedirNumeroColunasPlano(), this.pedirNumeroLinhasPlano());
		
		// colocar alunos no Plano
		this.colocarAlunosPlano(this.pedirNumeroAlunos());
		
		// colocar bugs no Plano
		this.colocarBugsPlano(this.pedirNumeroBugs());
		
		// colocar os robos no Plano
		this.colocarRobosPlano();
		
		// avisar ao player que alguns alunos e bugs foram encontrados (se algum for)
		this.relatorioAlunosBugsEncontrados();
		
		/* se por muita sorte todos os alunos forem encontrados antes de mover os robos, 
		 * o jogo acaba */
		if (this.plano.numeroAlunos() <= 0) {
			this.fimJogo();
			return;
		} 
		
		// entrar no loop principal
		this.loopPrincipal();
	}
	
	private int pedirNumeroColunasPlano() {
		int x;
		
		do {
			x = this.IO.pedirInt("número de colunas: ");
			if (x <= 1) {
				this.IO.escreverln("número de colunas inválido!");
			}
		} while (x <= 1);
		
		return x;
	}
	
	private int pedirNumeroLinhasPlano() {
		int y;
		
		do {
			y = this.IO.pedirInt("número de linhas: ");
			if (y <= 1) {
				this.IO.escreverln("número de linhas inválido!");
			}
		} while (y <= 1);
		
		return y;
	}
	
	private int pedirNumeroAlunos() {
		int numeroAlunos;
		int numeroCelulas = this.plano.getTamanhoX() * this.plano.getTamanhoY();
		
		do {
			numeroAlunos = this.IO.pedirInt("número de alunos: ");
			if (numeroAlunos >= numeroCelulas / 2) {
				this.IO.escreverln("número muito grande de alunos!");
			}
		} while (numeroAlunos >= numeroCelulas / 2);
		
		return numeroAlunos;
	}
	
	private int pedirNumeroBugs() {
		int numeroBugs;
		int numeroCelulas = this.plano.getTamanhoX() * this.plano.getTamanhoY();
		
		do {
			numeroBugs = this.IO.pedirInt("número de bugs: ");
			if (numeroBugs >= numeroCelulas / 2) {
				this.IO.escreverln("número muito grande de bugs!");
			}
		} while (numeroBugs >= numeroCelulas / 2);
		
		return numeroBugs;
	}
	
	private int gerarNumeroAleatorio(int minimo, int maximo) {
		Random geradorAleatorio = new Random();
		
		// trocar os valores se maximo for menor que minimo
		if (maximo < minimo) {
			maximo += minimo;
			minimo = maximo - minimo;
			maximo -= minimo;
		}
		
		return Math.abs(geradorAleatorio.nextInt() % (maximo - minimo)) + minimo;
	}
	
	private void colocarAlunosPlano(int numeroAlunos) {
		for (int i = 0; i < numeroAlunos; i++) {
			Coordenada posicaoAleatoria;
			
			do {
				int x = this.gerarNumeroAleatorio(1, this.plano.getTamanhoX());
				int y = this.gerarNumeroAleatorio(1, this.plano.getTamanhoY());
				posicaoAleatoria = new Coordenada(x, y);
			} while (this.plano.verificarCelula(posicaoAleatoria).size() > 0);
			
			try {
				new Aluno(posicaoAleatoria, this.plano);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void colocarBugsPlano(int numeroBugs) {
		for (int i = 0; i < numeroBugs; i++) {
			Coordenada posicaoAleatoria;
			
			do {
				int x = this.gerarNumeroAleatorio(1, this.plano.getTamanhoX());
				int y = this.gerarNumeroAleatorio(1, this.plano.getTamanhoY());
				posicaoAleatoria = new Coordenada(x, y);
			} while (this.plano.verificarCelula(posicaoAleatoria).size() > 0);
			
			try {
				new Bug(posicaoAleatoria, this.plano);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void colocarRobosPlano() {
		for (int i = 0; i < 7; i++) {
			int x = this.gerarNumeroAleatorio(1, this.plano.getTamanhoX());
			int y = this.gerarNumeroAleatorio(1, this.plano.getTamanhoY());
			Coordenada posicaoAleatoria = new Coordenada(x, y);
			
			try {
				
				if (i == 0) {
					new Andador(posicaoAleatoria, this.plano);
				} else if (i == 1) {
					new Peao(posicaoAleatoria, this.plano);
				} else if (i == 2) {
					new Torre(posicaoAleatoria, this.plano);
				} else if (i == 3) {
					new Bispo(posicaoAleatoria, this.plano);
				} else if (i == 4) {
					new Cavalo(posicaoAleatoria, this.plano);
				} else if (i == 5) {
					new Rei(posicaoAleatoria, this.plano);
				} else if (i == 6) {
					new Rainha(posicaoAleatoria, this.plano);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void relatorioAlunosBugsEncontrados() {
		ArrayList<Aluno> alunosEncontrados = this.plano.getAlunosEncontrados();
		ArrayList<Bug> bugsEncontrados = this.plano.getBugsEncontrados();
		
		if (alunosEncontrados.size() > 0 || bugsEncontrados.size() > 0) {
			this.IO.escreverln("\n---\n"); // linha de separação
		}
		
		if (alunosEncontrados.size() > 0) {
			this.IO.escreverln(alunosEncontrados.size() + " alunos foram encontrados");
			for (Aluno aluno : alunosEncontrados) {
				for (String roboNome : aluno.getNomesRobosEncontrou()) {
					this.IO.escreverln(roboNome + " encontrou um aluno em (" + 
							aluno.celula.getPosicao().x + ", " + 
							aluno.celula.getPosicao().y + ")");
				}
			}
		}
		
		if (bugsEncontrados.size() > 0) {
			this.IO.escreverln(bugsEncontrados.size() + " bugs foram encontrados");
			for (Bug bug : bugsEncontrados) {
				for (String roboNome : bug.getNomesRobosEncontrou()) {
					this.IO.escreverln(roboNome + " encontrou um bug em (" + 
							bug.celula.getPosicao().x + ", " + 
							bug.celula.getPosicao().y + ")");
				}
			}
		}
		
		this.plano.removerAlunosEBugsEncontrados();
		
	}
	
	private void relatorioRoboPontuacao() {
		
		this.IO.escreverln("\n---\n"); // linha de separação
		
		for (Robo robo : this.plano.getRobos()) {
			this.IO.escreverln("Robo: " + robo.getNome() + 
					" - pontuação: " + robo.getPontuacao());
		}
	}
	
	private void mostrarPlano() {
		this.IO.escreverln("\n---\n"); // linha de separação
		
		this.IO.escreverln(this.plano.toString());
	}
	
	private int pedirNumeroCasas(int maximo) {
		
		if (maximo < 0) {
			return this.IO.pedirInt("número de casas a andar: ");
		} else if (maximo == 0) {
			return 0;
		} else {
			int numero;
			
			do {
				numero = this.IO.pedirInt("número de casas a andar: ");
				
				if (numero > maximo) 
					this.IO.escreverln("número maior que o maximo possível para esse robô!");
				
				if (numero < 0) {
					this.IO.escreverln("número não pode ser negativo!");
				}
				
			} while (numero > maximo || numero < 0);
			
			return numero;
		}
	}
	
	private void controlarRobo(Robo robo) {
		int opcao;
		int numeroCasas;
		
		this.IO.escreverln("\n---\n"); // linha de separação
		
		while (true) {
			this.IO.escreverln("Robo: " + robo.getNome() + " - Posicao: (" + 
					robo.celula.getPosicao().x + ", " + robo.celula.getPosicao().y + ")");
			
			opcao = this.IO.pedirOpcao("Escolha uma opção: ", 
					new ArrayList<>(Arrays.asList("avançar", "retroceder")));
			
			numeroCasas = this.pedirNumeroCasas(robo.getNumeroMaximoCelulasMover());
			
			try {
				
				if (opcao == 1) {
					robo.avancar(numeroCasas);
				} else if (opcao == 2) {
					robo.retroceder(numeroCasas);
				} else {
					robo.avancar(0);
					this.IO.escreverln("isso nunca deveria ser escrito," + 
							" se vc está lendo isso, algo terrivelmente horrível aconteceu :D");
				}
				
				return;
				
			} catch (OutOfPlaneException e) {
				this.IO.escreverln(e.getMessage());
			}
		}
	}
	
	private void loopPrincipal() {
		
		while (this.rodada());
		
		this.fimJogo();
	}

	private boolean rodada() {
		
		// mostrar o plano antes de mover os robos
		this.mostrarPlano();
		
		// mover todos os robos
		for (Robo robo : this.plano.getRobos()) {
			this.controlarRobo(robo);
			
			this.mostrarPlano();
		}
		
		/* dizer quantos alunos e bugs foram encontrados, 
		 * bem como por qual robô e em qual posição */
		this.relatorioAlunosBugsEncontrados();
		
		// dizer a pontuação de cada robo
		this.relatorioRoboPontuacao();
		

		/* terminar o jogo se o número de alunos for 0 ou 
		 * se o jogador escolher sair do jogo*/
		if (this.plano.numeroAlunos() <= 0) {
			return false;
		} else if (this.IO.pedirBoolean("Terminar o jogo? (y/n): ", "y", "n")) {
			return false;
		}
		
		return true;
	}
	
	private void relatorioRobo(Robo robo) {
		this.IO.escreverln("\n---\n"); // linha de separação
		
		this.IO.escreverln("nome: " + robo.getNome());
		this.IO.escreverln("pontuação: " + robo.getPontuacao());
		this.IO.escreverln("celulas visitadas: ");
		
		for (Celula celula : robo.getCelulasVisitadas()) {
			this.IO.escreverln("(" + celula.getPosicao().x + ", " + celula.getPosicao().y + ")");
		}
		
		this.IO.escreverln("número de alunos resgatados: " + robo.getNumeroAlunosResgatados());
		this.IO.escreverln("número de bugs encontrados: " + robo.getNumeroBugsEncontrados());
	}
	
	private ArrayList<Robo> getMelhoresRobos() {
		int maiorPontuacao = this.plano.getRobos().get(0).getPontuacao();
		
		for (Robo robo : this.plano.getRobos()) {
			if (maiorPontuacao < robo.getPontuacao()) {
				maiorPontuacao = robo.getPontuacao();
			}
		}
		
		ArrayList<Robo> melhoresRobos = new ArrayList<>();
		
		for (Robo robo : this.plano.getRobos()) {
			if (robo.getPontuacao() == maiorPontuacao) {
				melhoresRobos.add(robo);
			}
		}
		
		return melhoresRobos;
	}
	
	private void fimJogo() {
		for (Robo robo : this.plano.getRobos()) {
			this.relatorioRobo(robo);
		}
		
		ArrayList<Robo> melhoresRobos = this.getMelhoresRobos();
		
		this.IO.escreverln("\n---\n"); // linha de separação
		
		if (melhoresRobos.size() > 1) {
			this.IO.escreverln("houve um empate entre: ");
			
			for (Robo robo : melhoresRobos) {
				this.IO.escreverln(robo.getNome());
			}
			
			this.IO.escreverln("todos com uma pontuação de: " + 
					melhoresRobos.get(0).getPontuacao());
		} else {
			this.IO.escreverln("o melhor robô é: " + melhoresRobos.get(0).getNome());
			this.IO.escreverln("com uma pontuação de: " + melhoresRobos.get(0).getPontuacao());
		}
		
		this.IO.escreverln("o nome do Jogador é: " + this.jogador.getNome());
	}
}
