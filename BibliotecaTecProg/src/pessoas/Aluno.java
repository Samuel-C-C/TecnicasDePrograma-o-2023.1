package pessoas;

import publicacoes.Publicacao;

public class Aluno extends Cliente {

	public Aluno(String nome, int matricula) {
		super(nome, matricula, 5, 10);	
	}

	public final void pegarPublicacaoEmprestada(Publicacao publicacao) {
		super.pegarPublicacaoEmprestada(publicacao, 10 * (1 - publicacao.getDescontoAluno()));
	}

}
