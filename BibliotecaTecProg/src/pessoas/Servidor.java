package pessoas;

import publicacoes.Publicacao;

public class Servidor extends Cliente {

	public Servidor(String nome, int matricula) {
		super(nome, matricula, 7, 15);
	}
	
	public final void pegarPublicacaoEmprestada(Publicacao publicacao) {
		super.pegarPublicacaoEmprestada(publicacao, 15);
	}

}
