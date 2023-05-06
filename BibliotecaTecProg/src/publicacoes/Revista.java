package publicacoes;

import java.util.ArrayList;
import pessoas.Pessoa;

public class Revista extends Publicacao {

	public Revista(String titulo, int anoPublicacao, Pessoa autor, int quantidadeDisponivel) {
		super(titulo, anoPublicacao, autor, quantidadeDisponivel, 0.01);
	}
	
	public Revista(String titulo, int anoPublicacao, ArrayList<Pessoa> autores, int quantidadeDisponivel) {
		super(titulo, anoPublicacao, autores, quantidadeDisponivel, 0.01);
	}

}
