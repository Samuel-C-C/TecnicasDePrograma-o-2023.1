package pessoas;

import publicacoes.Publicacao;

public class Professor extends Cliente {

	public Professor(String nome, int matricula) {
		super(nome, matricula, 10, 20);
	}
	
	public final void pegarPublicacaoEmprestada(Publicacao publicacao) {
		super.pegarPublicacaoEmprestada(publicacao, 25);
	}

}
