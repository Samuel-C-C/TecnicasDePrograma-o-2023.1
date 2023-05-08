package questao18;

import java.util.ArrayList;

public class Robo extends Entidade {
	
	private int norte;
	private int nordeste;
	private int leste;
	private int sudeste;
	private int sul;
	private int sudoeste;
	private int oeste;
	private int noroeste;
	
	private Moeda moedaAlvo;
	private String ultimaMovimentoUsado;
	
	private ArrayList<Vetor2D> posicoesVisitadas;
	
	public int getNorte() {
		return norte;
	}
	
	public int getNordeste() {
		return nordeste;
	}
	
	public int getLeste() {
		return leste;
	}
	
	public int getSudeste() {
		return sudeste;
	}
	
	public int getSul() {
		return sul;
	}
	
	public int getSudoeste() {
		return sudoeste;
	}
	
	public int getOeste() {
		return oeste;
	}
	
	public int getNoroeste() {
		return noroeste;
	}
	
	public ArrayList<Vetor2D> getPosicoesVisitadas() {
		return posicoesVisitadas;
	}
	
	public void setMoedaAlvo(Moeda moedaAlvo) {
		this.moedaAlvo = moedaAlvo;
	}
	
	public Robo(Vetor2D posicao) {
		super(posicao, 'R');
		
		this.posicoesVisitadas = new ArrayList<>();
		this.deslocar(0, 0);
		
		this.norte = 0;
		this.nordeste = 0;
		this.leste = 0;
		this.sudeste = 0;
		this.sul = 0;
		this.sudoeste = 0;
		this.oeste = 0;
		this.noroeste = 0;
		
		this.ultimaMovimentoUsado = "";
	}

	public Robo(int x, int y) {
		this(new Vetor2D(x, y));
	}
	
	public void limparPosicoesVistadas() {
		this.posicoesVisitadas = new ArrayList<>();
	}
	
	// retorna verdadeiro se existe uma posicao pertence ao plano
	private boolean verificarDeslocamento(int deslocamenteX, int deslocamentoY) {
		if (this.getPlano() != null) {
			Vetor2D posicaoAVerificar = new Vetor2D(this.getPosicao().x + deslocamenteX, this.getPosicao().y + deslocamentoY);
			
			return this.getPlano().verificarPosicao(posicaoAVerificar);
		}
		
		return false;
	}
	
	private void deslocar(int deslocamenteX, int deslocamentoY) {
		Vetor2D novaPosicao = new Vetor2D(this.getPosicao().x + deslocamenteX, this.getPosicao().y + deslocamentoY);
		this.mover(novaPosicao);
		this.posicoesVisitadas.add(novaPosicao);
	}
	
	public void norte() {
		this.deslocar(0, -1);
		this.norte++;
		this.ultimaMovimentoUsado = "Norte";
	}
	
	public void nordeste() {
		this.deslocar(1, -1);
		this.nordeste++;
		this.ultimaMovimentoUsado = "Nordeste";
	}
	
	public void leste() {
		this.deslocar(1, 0);
		this.leste++;
		this.ultimaMovimentoUsado = "Leste";
	}
	
	public void sudeste() {
		this.deslocar(1, 1);
		this.sudeste++;
		this.ultimaMovimentoUsado = "Sudeste";
	}
	
	public void sul() {
		this.deslocar(0, 1);
		this.sul++;
		this.ultimaMovimentoUsado = "Sul";
	}
	
	public void sudoeste() {
		this.deslocar(-1, 1);
		this.sudoeste++;
		this.ultimaMovimentoUsado = "Sudoeste";
	}
	
	public void oeste() {
		this.deslocar(-1, 0);
		this.oeste++;
		this.ultimaMovimentoUsado = "Oeste";
	}
	
	public void noroeste() {
		this.deslocar(-1, -1);
		this.noroeste++;
		this.ultimaMovimentoUsado = "Noroeste";
	}
	
	// função que caminha para moeda
	// retorna verdadeiro se já estiver na moeda ou se não houver moeda alvo
	public boolean caminharParaMoeda() {
		if (this.moedaAlvo == null) {
			return true;
		}
		
		int deltaX = this.moedaAlvo.getPosicao().x - this.getPosicao().x;
		int deltaY = this.moedaAlvo.getPosicao().y - this.getPosicao().y;
		
		if (deltaX == 0 && deltaY < 0) {
			this.norte();
		} else if (deltaX > 0 && deltaY < 0) {
			this.nordeste();
		} else if (deltaX > 0 && deltaY == 0) {
			this.leste();
		} else if (deltaX > 0 && deltaY > 0) {
			this.sudeste();
		} else if (deltaX == 0 && deltaY > 0) {
			this.sul();
		} else if (deltaX < 0 && deltaY > 0) {
			this.sudoeste();
		} else if (deltaX < 0 && deltaY == 0) {
			this.oeste();
		} else if (deltaX < 0 && deltaY < 0) {
			this.noroeste();
			
		} else if (deltaX == 0 && deltaY == 0) {
			return true;
		}
		
		return false;
		
	}
	
	// função que caminha para moeda sem repetir direções
	// retorna verdadeiro se já estiver na moeda ou se não houver moeda alvo
	public boolean caminharParaMoedaSemRepetir() {
		if (this.moedaAlvo == null) {
			return true;
		}
		
		int deltaX = this.moedaAlvo.getPosicao().x - this.getPosicao().x;
		int deltaY = this.moedaAlvo.getPosicao().y - this.getPosicao().y;
		
		if (deltaX == 0 && deltaY < 0) {
			if (!this.ultimaMovimentoUsado.equals("Norte"))
				this.norte();
			else
				this.nordeste();
		} else if (deltaX > 0 && deltaY < 0) {
			if (!this.ultimaMovimentoUsado.equals("Nordeste"))
				this.nordeste();
			else
				if (deltaX > -deltaY)
					this.leste();
				else
					this.norte();
		} else if (deltaX > 0 && deltaY == 0) {
			if (!this.ultimaMovimentoUsado.equals("Leste"))
				this.leste();
			else
				this.sudeste();
		} else if (deltaX > 0 && deltaY > 0) {
			if (!this.ultimaMovimentoUsado.equals("Sudeste"))
				this.sudeste();
			else
				if (deltaX > deltaY)
					this.leste();
				else
					this.sul();
		} else if (deltaX == 0 && deltaY > 0) {
			if (!this.ultimaMovimentoUsado.equals("Sul"))
				this.sul();
			else
				this.sudoeste();
		} else if (deltaX < 0 && deltaY > 0) {
			if (!this.ultimaMovimentoUsado.equals("Sudoeste"))
				this.sudoeste();
			else
				if (-deltaX > deltaY)
					this.oeste();
				else
					this.sul();
		} else if (deltaX < 0 && deltaY == 0) {
			if (!this.ultimaMovimentoUsado.equals("Oeste"))
				this.oeste();
			else
				this.noroeste();
		} else if (deltaX < 0 && deltaY < 0) {
			if (!this.ultimaMovimentoUsado.equals("Noroeste"))
				this.noroeste();
			else
				if (-deltaX > -deltaY)
					this.oeste();
				else
					this.norte();
			
		} else if (deltaX == 0 && deltaY == 0) {
			return true;
		}
		
		return false;
		
	}
	
	// método que faz o robo caminhar para a ponta do plano
	// retorna verdadeiro quando chegar na ponta ou se não tiver plano
	public boolean irParaPonta() {
		if (this.getPlano() == null) {
			return true;
		}
		
		if (this.verificarDeslocamento(-1, -1)) {
			this.noroeste();
		} else if (this.verificarDeslocamento(-1, 0)) {
			this.oeste();
		} else if (this.verificarDeslocamento(0, -1)) {
			this.norte();
		} else {
			return true;
		}
		
		return false;
	}
	
	// método que faz o robo caminhar para o centro do plano
	// retorna verdadeiro quando chegar no centro ou se não tiver plano
	public boolean irParaCentro() {
		if (this.getPlano() == null) {
			return true;
		}
		
		int centroXouY = this.getPlano().getTamanho() / 2;
		int deltaX = centroXouY - this.getPosicao().x;
		int deltaY = centroXouY - this.getPosicao().y;
		
		if (deltaX == 0 && deltaY < 0) {
			this.norte();
		} else if (deltaX > 0 && deltaY < 0) {
			this.nordeste();
		} else if (deltaX > 0 && deltaY == 0) {
			this.leste();
		} else if (deltaX > 0 && deltaY > 0) {
			this.sudeste();
		} else if (deltaX == 0 && deltaY > 0) {
			this.sul();
		} else if (deltaX < 0 && deltaY > 0) {
			this.sudoeste();
		} else if (deltaX < 0 && deltaY == 0) {
			this.oeste();
		} else if (deltaX < 0 && deltaY < 0) {
			this.noroeste();
			
		} else if (deltaX == 0 && deltaY == 0) {
			return true;
		}
		
		return false;
	}
	
	// método que faz a caminhada A
	// retorna verdadeiro quando terminar a caminhada ou se não tiver plano
	public boolean caminhadaA() {
		if (this.getPlano() == null) {
			return true;
		}
		
		if (this.getPosicao().y % 2 == 0) {
			if (this.verificarDeslocamento(-1, 0)) {
				this.oeste();
			} else {
				if (this.verificarDeslocamento(0, 1)) {
					this.sul();
				} else {
					return true;
				}
			}
		} else {
			if (this.verificarDeslocamento(1, 0)) {
				this.leste();
			} else {
				if (this.verificarDeslocamento(0, 1)) {
					this.sul();
				} else {
					return true;
				}
			}
		}
		
		return false;
	}

	// método que faz a caminhada B
	// retorna verdadeiro quando terminar a caminhada ou se não tiver plano
	public boolean caminhadaB() {
		if (this.getPlano() == null) {
			return true;
		}
		
		if (this.getPosicao().x == this.getPosicao().y) {
			if (this.verificarDeslocamento(1, 1)) {
				this.sudeste();
			} else {
				this.norte();
			}
		} else if (this.getPosicao().x == this.getPlano().getTamanho()) {
			if (this.getPosicao().y == 1) {
				this.sudoeste();
			} else {
				this.norte();
			}
		} else if (this.getPosicao().x == 1) {
			if (this.getPosicao().y == 2) {
				return true;
			} else {
				this.norte();
			}	
		} else {
			this.sudoeste();
		}
		
		return false;
	}
	
	// método que faz a caminhada C
	// retorna verdadeiro quando terminar a caminhada ou se não tiver plano
	public boolean caminhadaC() {
		if (this.getPlano() == null) {
			return true;
		}
		
		int metade = this.getPlano().getTamanho() / 2;
		
		if (this.getPosicao().y <= metade && this.getPosicao().x >= this.getPosicao().y && this.getPosicao().x + this.getPosicao().y <= 2 * metade) {
			if (this.verificarDeslocamento(1, 0)) {
				this.leste();
			} else {
				return true;
			}
		} else if (this.getPosicao().x > metade && this.getPosicao().x > this.getPosicao().y && this.getPosicao().x + this.getPosicao().y > 2 * metade) {
			if (this.verificarDeslocamento(0, 1)) {
				this.sul();
			} else {
				return true;
			}
		} else if (this.getPosicao().y > metade && this.getPosicao().x <= this.getPosicao().y && this.getPosicao().x + this.getPosicao().y > 2 * metade) {
			if (this.verificarDeslocamento(-1, 0)) {
				this.oeste();
			} else {
				return true;
			}
		} else if (this.getPosicao().x < metade && this.getPosicao().x < this.getPosicao().y && this.getPosicao().x + this.getPosicao().y <= 2 * metade) {
			if (this.verificarDeslocamento(0, -1)) {
				this.norte();
			} else {
				return true;
			}
		}
		
		return false;
	}

}
