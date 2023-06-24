package view;

import javax.swing.ImageIcon;

/**
 * Uma enum usada para de forma mais fácil importar as imagens da pasta "imagens"
 * 
 * @author Samuel
 */
public enum Imagens {
	
	CELULA_ESCONDIDA("imagens/celulaEscondida.png"),
	CELULA_VAZIA("imagens/celulaVazia.png"),
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
	
	/**
	 * cria a constante baseado no diretório da imagem
	 * 
	 * @param diretorioImagem diretório da imagem
	 * 
	 * @see ImageIcon#ImageIcon(String)
	 */
	private Imagens(String diretorioImagem) {
		imagem = new ImageIcon(diretorioImagem);
	}
	
	/**
	 * Retorna o {@code ImageIcon} da constante para uso no {@code setIcon(Icon defaultIcon)}
	 * 
	 * @return o {@code ImageIcon} da constante
	 * 
	 * @see ImageIcon
	 */
	public ImageIcon getImagem() {
		return imagem;
	}
}
