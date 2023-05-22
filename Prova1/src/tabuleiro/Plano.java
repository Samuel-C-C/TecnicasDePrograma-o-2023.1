package tabuleiro;

import java.util.ArrayList;

import entidade.*;
import robo.*;

public final class Plano implements VerificarCelula {
	
	/*
	 * Representa o tabuleiro
	 */
	
	private ArrayList<Celula> listaCelulas;
	private ArrayList<Entidade> listaEntidades;
	
	private int tamanhoX;
	private int tamanhoY;
	
	public ArrayList<Celula> getListaCelulas() {
		return listaCelulas;
	}
	
	public ArrayList<Entidade> getListaEntidades() {
		return listaEntidades;
	}
	
	public int getTamanhoX() {
		return tamanhoX;
	}
	
	public int getTamanhoY() {
		return tamanhoY;
	}
	
	// construtor
	public Plano(int x, int y) {
		
		if (x < 0) {
			x = -x;
		}
		
		this.tamanhoX = x;
		
		if (y < 0) {
			y = -y;
		}
		
		this.tamanhoY = y;
		
		this.listaCelulas = new ArrayList<Celula>();
		
		for (int indexX = 1; indexX <= x; indexX++) {
			for (int indexY = 1; indexY <= y; indexY++) {
				
				Celula novaCelula = new Celula(indexX, indexY, this);
				this.listaCelulas.add(novaCelula);
				
			}
			
		}
		
		this.listaEntidades = new ArrayList<Entidade>();
		
	}
	
	// retorna o número de alunos no plano
	public int numeroAlunos() {
		int numeroAlunos = 0;
		
		for (Entidade entidade : this.listaEntidades) {
			if (entidade instanceof Aluno) {
				numeroAlunos++;
			}
			
		}
		
		return numeroAlunos;
	}
	
	// retorna todos os robos no plano
	public ArrayList<Robo> getRobos() {
		ArrayList<Robo> robos = new ArrayList<>();
		
		for (Entidade entidade : this.listaEntidades) {
			if (entidade instanceof Robo) {
				robos.add((Robo) entidade);
			}
		}
		
		return robos;
	}
	
	// retorna uma String que representa a configuração do plano
	public String toString() {
		String planoString = "";
		
		for (int y = 1; y <= this.tamanhoY; y++) {
			
			planoString += " ";
			
			for (int x = 1; x <= this.tamanhoX; x++) {
				Coordenada posicao = new Coordenada(x, y);
				ArrayList<Entidade> entidadesNaPosicao = this.verificarCelula(posicao);
				
				if (entidadesNaPosicao.size() > 0) {
					Entidade entidadeBase = entidadesNaPosicao.get(0);
					planoString += entidadeBase.getSimbolo();
					
				} else {
					Celula celulaPosicao = this.getCelula(posicao);
					
					if (celulaPosicao.isVisitada()) {
						planoString += " ";
					} else {
						planoString += "?";
					}
				}
				
				if (x < tamanhoX) {
					planoString += " | ";
					
				} else {
					
					planoString += " ";
					
					if (y < tamanhoY) {
						planoString += "\n";
						for (int i = 0; i < this.tamanhoX; i++) {
							if (i == 0) {
								planoString += "---";
							} else {
								planoString += "+---";
							}
						}
						planoString += "\n";
					} 
				}
				
			}
		}
		
		return planoString;
	}
	
	// método que tira alunos e bugs do plano depois que eles são encontrados
	public void removerAlunosEBugsEncontrados() {
		ArrayList<Entidade> EntidadesASeremRemovidas = new ArrayList<>();
		
		for (Entidade entidade : this.listaEntidades) {
			if (entidade instanceof SairSeEncontrado) {
				SairSeEncontrado alunoOuBug = (SairSeEncontrado) entidade;
				if (alunoOuBug.isEncontrado())
					EntidadesASeremRemovidas.add(entidade);
			}
		}
		
		this.listaEntidades.removeAll(EntidadesASeremRemovidas);
		
	}

	// retornar celula que existe numa determinada posição (retorna null se não existir)
	public Celula getCelula(Coordenada posicao) {
		if (posicao.x < 1 || posicao.x > tamanhoX || posicao.y < 1 || posicao.y > tamanhoY) {
			return null;
		} else {
			for (Celula celula : this.listaCelulas) {
				if (celula.verificarPosicao(posicao)) {
					return celula;
				}
				
			}
			
		}
		
		return null;
		
	}
	
	// retorna uma lista de entidades que estão em determinada posição
	public ArrayList<Entidade> verificarCelula(Coordenada posicao) {
		Celula celulaPosicao = this.getCelula(posicao);
		
		ArrayList<Entidade> entidades = new ArrayList<Entidade>();
		
		for (Entidade entidade : listaEntidades) {
			if (entidade.celula == celulaPosicao) {
				entidades.add(entidade);
			}
			
		}
		
		return entidades;
		
	}
	
	public ArrayList<Aluno> getAlunosEncontrados() {
		ArrayList<Aluno> alunosEncontrados = new ArrayList<>();
		
		for (Entidade entidade : this.listaEntidades) {
			if (entidade instanceof Aluno) {
				Aluno aluno = (Aluno) entidade;
				
				if (aluno.isEncontrado()) {
					alunosEncontrados.add(aluno);
				}
			}
		}
		
		return alunosEncontrados;
	}
	
	public ArrayList<Bug> getBugsEncontrados() {
		ArrayList<Bug> bugsEncontrados = new ArrayList<>();
		
		for (Entidade entidade : this.listaEntidades) {
			if (entidade instanceof Bug) {
				Bug bug = (Bug) entidade;
				
				if (bug.isEncontrado()) {
					bugsEncontrados.add(bug);
				}
			}
		}
		
		return bugsEncontrados;
	}

}
