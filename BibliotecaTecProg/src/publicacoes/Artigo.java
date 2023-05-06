package publicacoes;

import java.util.ArrayList;
import pessoas.Pessoa;

public class Artigo extends Publicacao {

	public Artigo(String titulo, int anoPublicacao, Pessoa autor, int quantidadeDisponivel) {
		super(titulo, anoPublicacao, autor, quantidadeDisponivel, 0.5);
	}
	
	public Artigo(String titulo, int anoPublicacao, ArrayList<Pessoa> autores, int quantidadeDisponivel) {
		super(titulo, anoPublicacao, autores, quantidadeDisponivel, 0.5);
	}

}
