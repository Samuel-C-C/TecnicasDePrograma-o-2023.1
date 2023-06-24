package view;

import javax.swing.ImageIcon;

public enum Imagens {
	CELULA_ESCONDIDA("/Prova2/imagens/celulaEscondida.png"),
	CELULA_VAZIA("/Prova2/imagens/celulaVazia.png"),
	CELULA_COM_ALUNO("/Prova2/imagens/celulaAluno.png"),
	CELULA_COM_BUG("/Prova2/imagens/celulaBug.png"),
	CELULA_COM_ROBO_1("/Prova2/imagens/celulaRobo1.png"),
	CELULA_COM_ROBO_2("/Prova2/imagens/celulaRobo2.png"),
	CELULA_COM_ROBO_3("/Prova2/imagens/celulaRobo3.png"),
	ALUNO("/Prova2/imagens/aluno.png"),
	BUG("/Prova2/imagens/bug.png"),
	ROBO_1("/Prova2/imagens/robo1.png"),
	ROBO_2("/Prova2/imagens/robo2.png"),
	ROBO_3("/Prova2/imagens/robo3.png");
	
	private ImageIcon imagem;
	
	private Imagens(String diretorioImagem) {
		imagem = new ImageIcon(diretorioImagem);
		System.out.println(imagem.getIconWidth());
	}
	
	public ImageIcon getImagem() {
		return imagem;
	}
}
