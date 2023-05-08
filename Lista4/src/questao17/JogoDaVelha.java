package questao17;

public class JogoDaVelha {
	
	private String[][] gradeJogo;
	public boolean jogadorVez = true;
	
	public JogoDaVelha() {
		this.gradeJogo = new String[3][3];
		
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				this.gradeJogo[linha][coluna] = "vazia";
			}
		}
	
	}
	
	public String gradeString() {
		String gradeString = "";
		
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				
				if (this.gradeJogo[linha][coluna].equals("vazia")) {
					gradeString += " ";
				} else if (this.gradeJogo[linha][coluna].equals("jogador 1")) {
					gradeString += "X";
				} else if (this.gradeJogo[linha][coluna].equals("jogador 2")) {
					gradeString += "O";
				} else {
					gradeString += "?";
				}
				
				if (coluna < 2) {
					gradeString += "|";
				} else {
					if (linha < 2) {
						gradeString += "\n";
					}
				}
				
			}
			
		}
		
		return gradeString;
		
	}
	
	public boolean verificarPosicao(int linha, int coluna) {
		return !this.gradeJogo[linha][coluna].equals("vazia");
	}
	
	public void escreverGrade(int linha, int coluna) {
		if (this.jogadorVez) {
			this.gradeJogo[linha][coluna] = "jogador 1";
		} else {
			this.gradeJogo[linha][coluna] = "jogador 2";
		}
		
		this.jogadorVez = !this.jogadorVez;
		
	}
	
	public String verificarResultado() {
		
		// verificar cada linha
		for (int linha = 0; linha < 3; linha++) {
			String casaLinhaEsquerda = this.gradeJogo[linha][0];
			String casaLinhaCentro = this.gradeJogo[linha][1];
			String casaLinhaDireita = this.gradeJogo[linha][2];
			
			if (casaLinhaEsquerda.equals(casaLinhaCentro) && casaLinhaCentro.equals(casaLinhaDireita) && !casaLinhaCentro.equals("vazia")) {
				return "vitoria " + casaLinhaCentro;
			}
			
		}
		
		// verificar cada coluna
		for (int coluna = 0; coluna < 3; coluna++) {
			String casaColunaTopo = this.gradeJogo[0][coluna];
			String casaColunaCentro = this.gradeJogo[1][coluna];
			String casaColunaBase = this.gradeJogo[2][coluna];
			
			if (casaColunaTopo.equals(casaColunaCentro) && casaColunaCentro.equals(casaColunaBase) && !casaColunaCentro.equals("vazia")) {
				return "vitoria " + casaColunaCentro;
			}
			
		}
		
		String casaTopoEsquerda = this.gradeJogo[0][0];
		String casaTopoDireita = this.gradeJogo[0][2];
		String casaCentro = this.gradeJogo[1][1];
		String casaBaseEsquerda = this.gradeJogo[2][0];
		String casaBaseDireita = this.gradeJogo[2][2];
		
		// verificar diagonal principal
		if (casaTopoEsquerda.equals(casaCentro) && casaCentro.equals(casaBaseDireita) && !casaCentro.equals("vazia")) {
			return "vitoria " + casaCentro;
		}
		
		// verificar diagonal secundária
		if (casaTopoDireita.equals(casaCentro) && casaCentro.equals(casaBaseEsquerda) && !casaCentro.equals("vazia")) {
			return "vitoria " + casaCentro;
		}
		
		// verificar se a grade está toda preenchida
		boolean temAlgumaCasaVazia = false;
		for (int linha = 0; linha < 3 && !temAlgumaCasaVazia; linha++) {
			for (int coluna = 0; coluna < 3 && !temAlgumaCasaVazia; coluna++) {
				
				if (!this.verificarPosicao(linha, coluna)) {
					temAlgumaCasaVazia = true;
				}
				
			}
			
		}
		
		if (temAlgumaCasaVazia) {
			return "jogo não terminado";
		} else {
			return "empate";
		}
		
	}
	
	public void reiniciarJogo() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				this.gradeJogo[x][y] = "vazia";
			}
			
		}
		
	}

}
