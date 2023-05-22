package entidade;

import tabuleiro.*;

public abstract class Entidade {
	
	/*
	 * representa qualquer entidade que existe no tabuleiro
	 */
	
	public Celula celula;
	private char simbolo;
	
	public Plano getPlano() {
		return this.celula.getPlano();
	}
	
	public char getSimbolo() {
		return simbolo;
	}
	
	// construtores
	public Entidade(Celula celula, char simbolo) throws Exception {
		this.celula = celula;
		this.simbolo = simbolo;
		
		if (celula == null) {
			throw new Exception("celula invalida para criar entidade");
		} else {
			this.getPlano().getListaEntidades().add(this);
		}
	}
	
	public Entidade(Coordenada posicao, Plano plano, char simbolo) throws Exception {
		this(plano.getCelula(posicao), simbolo);
	}
	
	public Entidade(int x, int y, Plano plano, char simbolo) throws Exception {
		this(new Coordenada(x, y), plano, simbolo);
	}

}
