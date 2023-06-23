package view;

import java.awt.MediaTracker;
import javax.swing.ImageIcon;

public enum Imagens {
	CELULA_ESCONDIDA("/imagens/celulaEscondida.png"),
	CELULA_VAZIA("/imagens/celulaVazia.png"),
	CELULA_COM_ALUNO("imagens/celulaAluno.png"),
	CELULA_COM_BUG("imagens/celulaBug.png"),
	CELULA_COM_ROBO_1("imagens/celulaRobo1.png"),
	CELULA_COM_ROBO_2("imagens/celulaRobo2.png"),
	CELULA_COM_ROBO_3("imagens/celulaRobo3.png"),
	ALUNO("imagens/aluno.png"),
	BUG("imagens/bug.png"),
	ROBO_1("imagens/robo1.png"),
	ROBO_2("imagens/robo2.png"),
	ROBO_3("imagens/robo3.png");
	
	private ImageIcon imagem;
	
	private Imagens(String diretorioImagem) {
		imagem = new ImageIcon(diretorioImagem);
		if (imagem.getImageLoadStatus() == MediaTracker.ERRORED) {
			System.out.println("deu erro ao carrger: " + diretorioImagem);
		} else if (imagem.getImageLoadStatus() == MediaTracker.COMPLETE) {
			System.out.println("deu certo carregar: " + diretorioImagem);
		}
	}
	
	public ImageIcon getImagem() {
		return imagem;
	}
}
