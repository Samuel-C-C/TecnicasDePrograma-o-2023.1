package control;

import java.util.ArrayList;

/**
 * Representa o tabuleiro do jogo, onde todos os elementos estam
 * 
 * @author Samuel
 */
public class Tabuleiro {
	
	/**
	 * Número de linhas do tabuleiro
	 */
	private int numeroDeLinhas;
	
	/**
	 * Número de colunas do tabuleiro
	 */
	private int numeroDeColunas;
	
	/**
	 * Um {@code ArrayList} de todos os elementos do tabuleiro
	 * 
	 * @see ArrayList
	 * @see Elemento
	 */
	private ArrayList<Elemento> elementos;
	
	/**
	 * Cria um tabuleiro de tamanho 8x8
	 * 
	 * <p>coloca um número aleatorio de alunos e bugs em posições aleatorias</p>
	 */
	public Tabuleiro() {
		numeroDeColunas = 8;
		numeroDeLinhas = 8;
		
		elementos = new ArrayList<>();
		
		for (int x = 1; x <= numeroDeColunas; x++) {
			for (int y = 1; y <= numeroDeLinhas; y++) {
				elementos.add(new Celula(x, y));
			}
		}
		
		GeradorNumeroAleatorio geradorAleatorio = new GeradorNumeroAleatorio();
		
		colocarAlunosTabuleiro(geradorAleatorio.numeroAleatorio(10, 20));
		colocarBugsTabuleiro(geradorAleatorio.numeroAleatorio(5, 10));
		colocarRobosTabuleiro();
	}
	
	/**
	 * Retorna o numero de colunas
	 * 
	 * @return numero de colunas
	 * 
	 * @see Tabuleiro#numeroDeColunas
	 */
	public int getNumeroDeColunas() {
		return numeroDeColunas;
	}
	
	/**
	 * Retorna o numero de linhas
	 * 
	 * @return numero de linhas
	 * 
	 * @see Tabuleiro#numeroDeLinhas
	 */
	public int getNumeroDeLinhas() {
		return numeroDeLinhas;
	}
	
	/**
	 * Coloca 3 robos no Tabuleiro
	 * 
	 * @see Robo
	 */
	private void colocarRobosTabuleiro() {
		for (int i = 1; i <= 3; i++) {
			elementos.add(new Robo(this, i, "Robo " + i, 0, 0));
		}
	}
	
	/**
	 * Coloca {@code numeroAlunos} alunos no Tabuleiro
	 * 
	 * @param numeroAlunos número de alunos a serem colocados no Tabuleiro
	 * 
	 * @see Aluno
	 */
	private void colocarAlunosTabuleiro(int numeroAlunos) {
		GeradorNumeroAleatorio geradorAleatorio = new GeradorNumeroAleatorio();
		
		for (int i = 0; i < numeroAlunos; i++) {
			boolean posicaoOcupada = false;
			int posicaoX;
			int posicaoY;
			
			do {
				posicaoX = geradorAleatorio.numeroAleatorio(1, numeroDeColunas);
				posicaoY = geradorAleatorio.numeroAleatorio(1, numeroDeLinhas);
				
				posicaoOcupada = getAlunoOuBug(posicaoX, posicaoY) != null;
			} while (posicaoOcupada);
			
			elementos.add(new Aluno(posicaoX, posicaoY));
		}
	}
	
	/**
	 * Coloca {@code numeroBugs} bugs no Tabuleiro
	 * 
	 * @param numeroBugs número de bugs a serem colocados no Tabuleiro
	 * 
	 * @see Bug
	 */
	private void colocarBugsTabuleiro(int numeroBugs) {
		GeradorNumeroAleatorio geradorAleatorio = new GeradorNumeroAleatorio();
		
		for (int i = 0; i < numeroBugs; i++) {
			boolean posicaoOcupada = false;
			int posicaoX;
			int posicaoY;
			
			do {
				posicaoX = geradorAleatorio.numeroAleatorio(1, numeroDeColunas);
				posicaoY = geradorAleatorio.numeroAleatorio(1, numeroDeLinhas);
				
				posicaoOcupada = getAlunoOuBug(posicaoX, posicaoY) != null;
			} while (posicaoOcupada);
			
			elementos.add(new Bug(posicaoX, posicaoY));
		}
	}
	
	/**
	 * Retorna uma lista de todas as celulas do tabuleiro
	 * 
	 * @return um {@code ArrayList} com todas as celulas do tabuleiro
	 * 
	 * @see ArrayList
	 * @see Celula
	 */
	public ArrayList<Celula> getCelulas() {
		ArrayList<Celula> celulas = new ArrayList<>();
		
		for (Elemento elemento : elementos) {
			if (elemento instanceof Celula) {
				celulas.add((Celula) elemento);
			}
		}
		
		return celulas;
	}
	
	/**
	 * Retorna uma celula que tenha a posição (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * @return uma celula cuja posição seja (x, y), {@code null} se não houver celula
	 */
	public Celula getCelula(int x, int y) {
		for (Celula celula : getCelulas()) {
			if (celula.verificarPosicao(x, y)) {
				return celula;
			}
		}
		
		return null;
	}
	
	/**
	 * Retorna uma lista com todos os alunos e bugs no tabuleiro
	 * 
	 * @return um {@code ArrayList} com todas os alunos e bugs do tabuleiro
	 * 
	 * @see ArrayList
	 * @see AlunoEBug
	 */
	public ArrayList<AlunoEBug> getAlunosEBugs() {
		ArrayList<AlunoEBug> alunosEBugs = new ArrayList<>();
		
		for (Elemento elemento : elementos) {
			if (elemento instanceof AlunoEBug) {
				alunosEBugs.add((AlunoEBug) elemento);
			}
		}
		
		return alunosEBugs;
	}
	
	/**
	 * Retorna um aluno ou bug que tenha a posição (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * 
	 * @return um aluno ou bug que tenha posição (x, y), {@code null} se não tiver nenhum
	 * aluno ou bug com essa posição
	 * 
	 * @see AlunoEBug
	 */
	public AlunoEBug getAlunoOuBug(int x, int y) {
		for (AlunoEBug alunoOuBug : getAlunosEBugs()) {
			if (alunoOuBug.verificarPosicao(x, y)) {
				return alunoOuBug;
			}
		}
		
		return null;
	}

	/**
	 * Retorna uma lista com todos os robos no tabuleiro
	 * 
	 * @return um {@code ArrayList} com todos os robos do tabuleiro
	 * 
	 * @see ArrayList
	 * @see Robo
	 */
	public ArrayList<Robo> getRobos() {
		ArrayList<Robo> robos = new ArrayList<>();
		
		for (Elemento elemento : elementos) {
			if (elemento instanceof Robo) {
				robos.add((Robo) elemento);
			}
		}
		
		return robos;
	}
	
	/**
	 * Retorna o primeiro robo cuja posição é (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * @return {@code Robo} cuja posição é (x, y), ou {@code null} se
	 * não houver robo na posição (x, y)
	 * 
	 * @see Robo
	 */
	public Robo getRobo(int x, int y) {
		for (Robo robo : getRobos()) {
			if (robo.verificarPosicao(x, y)) {
				return robo;
			}
		}
		
		return null;
	}

	/**
	 * Retorna o robo com ID especificado
	 * 
	 * @param id ID do robo
	 * 
	 * @return {@code null} se não houver robo com o id determinado,
	 * caso contrário, retorna o robo com o id dado
	 * 
	 * @see Robo
	 */
	public Robo getRobo(int id) {
		for (Robo robo : getRobos()) {
			if (robo.getId() == id) {
				return robo;
			}
		}
		
		return null;
	}

	/**
	 * Coloca todos os robos em uma posição fora do tabuleiro
	 * 
	 * @see Robo
	 */
	public void reiniciarRobos() {
		for (Robo robo : getRobos()) {
			robo.colocarForaTabuleiro();
		}
	}
	
	/**
	 * Faz os Robos verificarem as celulas onde se encontram e ganharem pontos
	 * 
	 * @see Celula#visitada
	 * @see AlunoEBug#encontrado
	 * @see AlunoEBug#valorPontos
	 */
	public void robosVerificarCelulas() {
		for (Robo robo : getRobos()) {
			if (robo.isPosicionado())
				robo.verificarCelula();
		}
	}
	
	/**
	 * Retorna o número de robos posicionados
	 * 
	 * @return numero de robos posicionados
	 * 
	 * @see Robo#isPosicionado()
	 */
	public int verificarNumeroRobosPosicionados() {
		int numeroRoboSelecionados = 0;
		
		for (Robo robo : getRobos()) {
			if (robo.isPosicionado()) {
				numeroRoboSelecionados++;
			}
		}
		
		return numeroRoboSelecionados;
	}
	
	/**
	 * Retorna o número de celulas não visitadas
	 * 
	 * @return o número de celulas não visitadas
	 * 
	 * @see Celula
	 */
	public int getNumberCelulasVazias() {
		int numeroCelulasVazias = 0;
		
		for (Celula celula : getCelulas()) {
			if (!celula.isVisitada()) {
				numeroCelulasVazias += 1;
			}
		}
		
		return numeroCelulasVazias;
	}

	/**
	 * Retorna o número de alunos no tabuleiro
	 * 
	 * @return o número de alunos no tabuleiro
	 * 
	 * @see Aluno
	 */
	public int getNumeroAlunosTotal() {
		int numeroAlunos = 0;
		
		for (AlunoEBug alunoOuBug : getAlunosEBugs()) {
			if (alunoOuBug.isAluno()) {
				numeroAlunos++;
			}
		}
		
		return numeroAlunos;
	}
	
	/**
	 * Retorna o número de alunos resgatados
	 * 
	 * @return o número de alunos resgatados
	 * 
	 * @see Aluno
	 */
	public int getNumeroAlunosResgatados() {
		int numeroAlunosEncontrados = 0;
		
		for (AlunoEBug alunoOuBug : getAlunosEBugs()) {
			if (alunoOuBug.isAluno() && alunoOuBug.isEncontrado()) {
				numeroAlunosEncontrados += 1;
			}
		}
		
		return numeroAlunosEncontrados;
	}

	/**
	 * Retorna o número de bugs encontrados
	 * 
	 * @return o número de bugs encontrados
	 * 
	 * @see Bug
	 */
	public int getNumeroBugsEncontrados() {
		int numeroBugsEncontrados = 0;
		
		for (AlunoEBug alunoOuBug : getAlunosEBugs()) {
			if (alunoOuBug.isBug() && alunoOuBug.isEncontrado()) {
				numeroBugsEncontrados += 1;
			}
		}
		
		return numeroBugsEncontrados;
	}

}
