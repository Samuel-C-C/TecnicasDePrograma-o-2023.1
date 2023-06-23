package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

//import javax.swing.BorderFactory;
import javax.swing.JPanel;

import control.AlunoEBug;
import control.Celula;
import control.Robo;
import control.Tabuleiro;

/**
 * Painel que mostra o tabuleiro do jogo
 * 
 * @author Samuel
 * 
 * @see Tabuleiro
 */
public class PainelGrade extends JPanel {

	private static final long serialVersionUID = -999830848952280768L;
	
	/**
	 * Referencia a {@code TelaJogo} a qual esse painel pertence
	 * 
	 * @see TelaJogo
	 */
	private TelaJogo telaJogo;
	
	/**
	 * {@code ArrayList} de {@code BotaoCelulaGrade}
	 * 
	 * @see ArrayList
	 * @see BotaoCelulaGrade
	 */
	private ArrayList<BotaoCelulaGrade> botoesCelula;
	
	/**
	 * número de linhas da grade
	 */
	private int numeroLinhas;
	
	/**
	 * número de colunas da grade
	 */
	private int numeroColunas;
	
	/**
	 * Cria uma grade com tamanho 8x8
	 * 
	 * @param telaJogo a tela a qual esse painel pertence
	 * 
	 * @see TelaJogo
	 */
	public PainelGrade(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
		numeroLinhas = 8;
		numeroColunas = 8;
		
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new GridLayout(numeroLinhas, numeroColunas));
		botoesCelula = new ArrayList<>();
		
		for (int x = 1; x <= numeroColunas; x++) {
			for (int y = 1; y <= numeroLinhas; y++) {
				BotaoCelulaGrade novaCelula = new BotaoCelulaGrade(telaJogo, x, y);
				botoesCelula.add(novaCelula);
				this.add(novaCelula);
			}
		}
	}
	
	/**
	 * Retorna o botão da posição (x, y)
	 * 
	 * @param x posição X
	 * @param y posição Y
	 * @return o botão com a posição (x, y), se não houver botão com essa posição,
	 * retorna {@code null}
	 * 
	 * @see BotaoCelulaGrade
	 */
	private BotaoCelulaGrade getBotao(int x, int y) {
		for (BotaoCelulaGrade botao : botoesCelula) {
			if (botao.verificarPosicao(x, y)) {
				return botao;
			}
		}
		
		return null;
	}
	
	/**
	 * Faz todos os botões relacionados a celulas não visitadas serem ativados
	 * 
	 * @see Celula
	 * @see BotaoCelulaGrade
	 */
	public void habilitarBotoes() {
		Tabuleiro tabuleiro = telaJogo.getControleJogo().getTabuleiro();
		
		for (Celula celula : tabuleiro.getCelulas()) {
			if (!celula.isVisitada() && tabuleiro.getRobo(celula.getX(), celula.getY()) == null) {
				getBotao(celula.getX(), celula.getY()).setEnabled(true);
			}
		}
	}
	
	/**
	 * Atualiza os Botões da grade baseado no Tabuleiro do jogo
	 * 
	 * @see Tabuleiro
	 */
	public void update() {
		Tabuleiro tabuleiro = telaJogo.getControleJogo().getTabuleiro();
		
		for (int x = 1; x <= numeroColunas; x++) {
			for (int y = 1; y <= numeroLinhas; y++) {
				getBotao(x, y).setText("");
				
				if (tabuleiro.getCelula(x, y).isVisitada()) {
					getBotao(x, y).setIcon(Imagens.CELULA_VAZIA.getImagem());
				} else {
					getBotao(x, y).setIcon(Imagens.CELULA_ESCONDIDA.getImagem());
				}
			}
		}
		
		for (AlunoEBug alunoOuBug : tabuleiro.getAlunosEBugs()) {
			if (alunoOuBug.isEncontrado()) {
				int xAlunoOuBug = alunoOuBug.getX();
				int yAlunoOuBug = alunoOuBug.getY();
				
				if (alunoOuBug.isAluno()) {
					getBotao(xAlunoOuBug, yAlunoOuBug).setIcon(Imagens.CELULA_COM_ALUNO.getImagem());
				} else if (alunoOuBug.isBug()) {
					getBotao(xAlunoOuBug, yAlunoOuBug).setIcon(Imagens.CELULA_COM_BUG.getImagem());
				}
			}
		}
		
		for (Robo robo : tabuleiro.getRobos()) {
			if (robo.isPosicionado()) {
				if (robo.getId() == 1) {
					getBotao(robo.getX(), robo.getY()).setIcon(Imagens.CELULA_COM_ROBO_1.getImagem());
				} else if (robo.getId() == 2) {
					getBotao(robo.getX(), robo.getY()).setIcon(Imagens.CELULA_COM_ROBO_2.getImagem());
				} else if (robo.getId() == 3) {
					getBotao(robo.getX(), robo.getY()).setIcon(Imagens.CELULA_COM_ROBO_3.getImagem());
				} else {
					getBotao(robo.getX(), robo.getY()).setText(robo.getNome());
				}
			}
		}
	}
	
	/**
	 * Desativa todos os botões da grade
	 * 
	 * @see BotaoCelulaGrade
	 */
	public void desabilitarBotoes() {
		for (BotaoCelulaGrade botao : botoesCelula) {
			botao.setEnabled(false);
		}
	}

}
