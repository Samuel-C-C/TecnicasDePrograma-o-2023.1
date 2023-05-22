package robo;

import java.util.ArrayList;

import entidade.*;
import exceptions.OutOfPlaneException;
import tabuleiro.*;

public abstract class Robo extends Entidade {
	
	/*
	 * Modelo dos Robos
	 */
	
	// usado para dar id para os Robos
	private static int numeroRobos = 0;
	
	private String nome;
	private int id;
	private int pontuacao;
	
	// usado para dizer o maximo que o robo pode andar quando avançar ou retroceder
	private int numeroMaximoCelulasMover;
	// -1 significa que não há maximo
	
	private int numeroAlunosResgatados;
	private int numeroBugsEncontrados;
	
	// usado no final do jogo
	private ArrayList<Celula> celulasVisitadas;
	
	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public int getNumeroMaximoCelulasMover() {
		return numeroMaximoCelulasMover;
	}
	
	public int getNumeroAlunosResgatados() {
		return numeroAlunosResgatados;
	}
	
	public int getNumeroBugsEncontrados() {
		return numeroBugsEncontrados;
	}
	
	public ArrayList<Celula> getCelulasVisitadas() {
		return celulasVisitadas;
	}

	// construtores
	public Robo(Celula celula, String nome, int maximoMover, char simbolo) throws Exception {
		super(celula, simbolo);
		this.nome = nome;
		this.numeroMaximoCelulasMover = maximoMover;
		
		this.pontuacao = 0;
		this.numeroAlunosResgatados = 0;
		this.numeroBugsEncontrados = 0;
		
		this.celulasVisitadas = new ArrayList<Celula>();
		this.mover(celula);
		
		this.id = Robo.numeroRobos;
		Robo.numeroRobos++;
	}

	public Robo(Coordenada posicao, Plano plano, String nome, int maximoMover, char simbolo) throws Exception {
		this(plano.getCelula(posicao), nome, maximoMover, simbolo);
	}

	public Robo(int x, int y, Plano plano, String nome, int maximoMover, char simbolo) throws Exception {
		this(new Coordenada(x, y), plano, nome, maximoMover, simbolo);
	}
	
	// mover para outra celula
	public void mover(Celula celula) {
		
		celula.visitar();
		this.celulasVisitadas.add(celula);
		this.celula = celula;
		
		for (Entidade entidade : this.getPlano().verificarCelula(celula.getPosicao())) {
			
			if (entidade instanceof Aluno) {
				Aluno aluno = (Aluno) entidade;
				aluno.encontrar(this);
				
				this.pontuacao += 10;
				this.numeroAlunosResgatados++;
				
			} else if (entidade instanceof Bug) {
				Bug bug = (Bug) entidade;
				bug.encontrar(this);
				
				this.pontuacao -= 15;
				this.numeroBugsEncontrados++;
			}
			
		}
		
	}
	
	public void mover(Coordenada posicao) throws OutOfPlaneException {
		Celula celula = this.getPlano().getCelula(posicao);
		
		if (celula == null) {
			throw new OutOfPlaneException(posicao, getPlano());
		} else {
			this.mover(celula);
		}
	}
	
	public void mover(int x, int y) throws OutOfPlaneException {
		this.mover(new Coordenada(x, y));
	}
	
	/*
	public boolean perguntarAvancarOuRetroceder(Scanner teclado) {
		int resposta;
		do {
			System.out.print("escolha uma opção:\n" + 
					"1. avançar\n" + 
					"2. retroceder\n" + 
					"> ");
			resposta = teclado.nextInt();
			
			if (resposta != 1 && resposta != 2) {
				System.out.println("opção inválida");
			}
			
		} while (resposta != 1 && resposta != 2);
		
		return resposta == 1;
	}
	*/

	/*
	public int perguntarNumeroCasas(int maximo, Scanner teclado) {
		int numeroCasas;
		do {
			System.out.print("número de casas: ");
			numeroCasas = teclado.nextInt();
			
			if (numeroCasas < 0) {
				System.out.println("número de casas não pode ser negativo");
			} else if (numeroCasas == 0) {
				System.out.println("número de casas não pode ser zero");
			} else if (numeroCasas > maximo) {
				System.out.println(this.nome + " só pode andar " + maximo + " casas");
			}
			
		} while (numeroCasas <= 0 || numeroCasas > maximo);
		
		return numeroCasas;
		
	}
	*/

	/*
	public int perguntarNumeroCasas(Scanner teclado) {
		int numeroCasas;
		do {
			System.out.print("número de casas: ");
			numeroCasas = teclado.nextInt();
			
			if (numeroCasas < 0) {
				System.out.println("número de casas não pode ser negativo");
			} else if (numeroCasas == 0) {
				System.out.println("número de casas não pode ser zero");
			}
			
		} while (numeroCasas <= 0);
		
		return numeroCasas;
		
	}
	*/
	
	public abstract void avancar(int numeroCasas) throws OutOfPlaneException; // ação de avançar
	
	public abstract void retroceder(int numeroCasas) throws OutOfPlaneException; // ação de retroceder

}
