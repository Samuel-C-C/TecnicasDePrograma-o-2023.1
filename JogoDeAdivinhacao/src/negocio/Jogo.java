package negocio;

import java.util.Random;
import apresentacao.*;

public class Jogo {

	private Jogador jogador;
	private EntradaSaida entradaSaida;
	private int numeroAlvo;
	
	public void inciarJogoTerminal() {
		this.iniciarJogo(new Terminal());
	}

	public void inciarJogoGUI() {
		this.iniciarJogo(new Tela());
	}
	
	private void iniciarJogo(EntradaSaida entradaSaida) {
		this.entradaSaida = entradaSaida;
		this.jogador = new Jogador(this.entradaSaida.pedirString("Diga seu nome"));
		
		this.loopPrincipal();
	}
	
	private void loopPrincipal() {
		do {
			rodada();
		} while (this.entradaSaida.pedirBoolean("jogar novamente?"));
		
		this.entradaSaida.escreverMensagem("obrigado por jogar <3");
	}
	
	private void rodada() {
		this.numeroAlvo = this.gerarNumeroAleatorio(0, 100);
		
		while (this.verificarAcerto()) {
			;
		}
		
		this.fimRodada();
	}
	
	private void fimRodada() {
		String numerosApostados = "";
		
		for (int index = 0; index < jogador.getListaNumeros().size(); index++) {
			int numero = jogador.getListaNumeros().get(index);
			
			if (index > 0) {
				numerosApostados += " - ";
			}
			
			numerosApostados += numero;
		}
		
		this.entradaSaida.escreverMensagem("Número de tentativas: " + 
				jogador.getNumeroTentativa() + " - Números apostados: " + numerosApostados);
		
		jogador.resetarTentativas();
	}
	
	private boolean verificarAcerto() {
		int numeroApostado = this.entradaSaida.pedirInteiro("Escolha um número");
		this.jogador.tentarNumero(numeroApostado);
		
		if (numeroApostado == this.numeroAlvo) {
			return false;
		} else if (numeroApostado > this.numeroAlvo) {
			this.entradaSaida.escreverMensagem("Número alvo é menor que " + numeroApostado);
		} else {
			this.entradaSaida.escreverMensagem("Número alvo é maior que " + numeroApostado);
		}
		
		return true;
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
	
}
