package questao18;

import java.util.ArrayList;

public class Plano {
	
	private char[][] matriz;
	private int tamanho;
	
	private ArrayList<Entidade> listaEntidades;
	
	public char[][] getMatriz() {
		return matriz;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public ArrayList<Entidade> getListaEntidades() {
		return listaEntidades;
	}
	
	public Plano(int tamanho) {
		if (tamanho <= 0) {
			tamanho = 1;
		}
		
		this.matriz = new char[tamanho][tamanho];
		this.tamanho = tamanho;
		
		this.listaEntidades = new ArrayList<Entidade>();
	
		this.atualizarPlano();
	}
	
	public void adicionarEntidade(Entidade entidade) {
		this.listaEntidades.add(entidade);
		entidade.setPlano(this);
		
		this.atualizarPlano();
	}
	
	public void removerEntidade(Entidade entidade) {
		if (this.listaEntidades.remove(entidade)) {
			entidade.setPlano(null);
		}
		
		this.atualizarPlano();
	}
	
	// verifica se uma posicao pertence ao plano
	public boolean verificarPosicao(Vetor2D posicao) {
		return 1 <= posicao.x && posicao.x <= tamanho && 1 <= posicao.y && posicao.y <= tamanho;
	}
	
	// atualizar a matriz do plano
	public void atualizarPlano() {
		
		for (int linha = 0; linha < tamanho; linha++) {
			for (int coluna = 0; coluna < tamanho; coluna++) {
				this.matriz[linha][coluna] = ' ';
			}
		}
		
		for (Entidade entidade : this.listaEntidades) {
			
			if (entidade instanceof Robo) {
				Robo robo = (Robo) entidade;
				
				for (Vetor2D posicaoVisitada : robo.getPosicoesVisitadas()) {
					if (verificarPosicao(posicaoVisitada)) {
						this.matriz[posicaoVisitada.y - 1][posicaoVisitada.x - 1] = '@';
					}
				}
			}
			
			if (this.verificarPosicao(entidade.getPosicao())) {
				this.matriz[entidade.getPosicao().y - 1][entidade.getPosicao().x - 1] = entidade.getSimbolo();
			}
			
		}
		
	}
	
	// retorna a String que representa o desenho do plano baseado na matriz
	public String desenharPlano() {
		this.atualizarPlano();
		
		String plano = "";
		
		for (int linha = 0; linha < tamanho; linha++) {
			for (int coluna = 0; coluna < tamanho; coluna++) {
				plano += this.matriz[linha][coluna];
			}
			
			if (linha < tamanho - 1) 
				plano += "\n";
		}
		
		return plano;
	}
	
	private ArrayList<Vetor2D> todasAsPosicoesVisitadasRobo(Robo robo) {
		ArrayList<Vetor2D> posicoesVisitadas = new ArrayList<>();
		
		for (Vetor2D posicao : robo.getPosicoesVisitadas()) {
			if (this.verificarPosicao(posicao)) {
				posicoesVisitadas.add(posicao);
			}
		}
		
		return posicoesVisitadas;
	}
	
	private ArrayList<Vetor2D> todasAsPosicoesNaoVisitadasRobo(Robo robo) {
		ArrayList<Vetor2D> posicoesNaoVisitadas = new ArrayList<>();
		
		for (int x = 1; x < this.tamanho; x++) {
			for (int y = 1; y < this.tamanho; y++) {
				posicoesNaoVisitadas.add(new Vetor2D(x, y));
			}
		}
		
		ArrayList<Vetor2D> posicoesASeremRemovidas = new ArrayList<>();
		
		for (Vetor2D posicao : posicoesNaoVisitadas) {
			for (Vetor2D posicaoRobo : robo.getPosicoesVisitadas()) {
				if (posicaoRobo.equals(posicao)) {
					posicoesASeremRemovidas.add(posicao);
				}
			}
		}
		
		posicoesNaoVisitadas.removeAll(posicoesASeremRemovidas);
		
		return posicoesNaoVisitadas;
	}
	
	public String contarPosicoesVisitadas(Robo robo) {
		ArrayList<Vetor2D> posicoesVisitadas = this.todasAsPosicoesVisitadasRobo(robo);
		
		String string = "posicoes visitadas pelo robo: " + robo.toString() + "\n";
		
		for (Vetor2D posicao : posicoesVisitadas) {
			string += "(" + posicao.x + ", " + posicao.y + ")\n";
		}
		
		return string;
	}
	
	public String contarPosicoesNaoVisitadas(Robo robo) {
		ArrayList<Vetor2D> posicoesNaoVisitadas = this.todasAsPosicoesNaoVisitadasRobo(robo);
		
		String string = "posicoes não visitadas pelo robo: " + robo.toString() + "\n";
		
		for (Vetor2D posicao : posicoesNaoVisitadas) {
			string += "(" + posicao.x + ", " + posicao.y + ")\n";
		}
		
		return string;
	}

}
