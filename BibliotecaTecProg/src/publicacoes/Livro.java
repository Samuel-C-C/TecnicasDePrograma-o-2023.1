package publicacoes;

import java.util.ArrayList;
import pessoas.Pessoa;

public class Livro extends Publicacao {

	public Livro(String titulo, int anoPublicacao, Pessoa autor, int quantidadeDisponivel) {
		super(titulo, anoPublicacao, autor, quantidadeDisponivel, 0.1);
	}
	
	public Livro(String titulo, int anoPublicacao, ArrayList<Pessoa> autores , int quantidadeDisponivel) {
		super(titulo, anoPublicacao, autores, quantidadeDisponivel, 0.1);
	}

}
