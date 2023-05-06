package main;

import java.util.ArrayList;

import pessoas.*;
import publicacoes.*;

public class Main {

	public static void main(String[] args) {
		
		Biblioteca bibliotecaTecProg = new Biblioteca();
		
		Professor professorFischer = new Professor("Fischer", 63021);
		Professor professorJoao = new Professor("Joao", 30305);
		Professor professorMarcos = new Professor("Marcos", 4545);
		Aluno alunaMaria = new Aluno("Maria", 45456);
		Aluno alunaAnaPaula = new Aluno("Ana Paula", 78877);
		Servidor servidoraMichele = new Servidor("Michele", 78777);
		Servidor servidorThales = new Servidor("Thales", 98888);
		
		Pessoa deitel = new Pessoa("Deitel");
		Aluno alunaGeovana = new Aluno("Geovana", 526790);
		Aluno alunaCaua = new Aluno("Cauã", 511202);
		Aluno alunoSilva = new Aluno("Silva", 497612);
		
		ArrayList<Pessoa> monitoresTecProg = new ArrayList<Pessoa>();
		monitoresTecProg.add(alunaGeovana);
		monitoresTecProg.add(alunaCaua);
		
		Livro livroComoPogramar = new Livro("Como Programar em java", 2022, deitel, 20);
		Livro livroSerAprovado = new Livro("Como ser aprovado em Tecnicas de Programação", 2023, monitoresTecProg, 10);
		
		Artigo artigoDocumentacaoTecnica = new Artigo("Documentação técnica na perspectiva do desenvolvimento e manutenção de software", 2011, professorFischer, 10);
		TCC comparativoJavaPython = new TCC("Um comparativo de desempenho entre Java e Python", 2021, alunoSilva, 10);

		Revista indico = new Revista("INDICO: inclusão digital necessária para a sociedade atual", 2023, monitoresTecProg, 10);
		
		bibliotecaTecProg.doarPublicacao(livroComoPogramar);
		bibliotecaTecProg.doarPublicacao(livroSerAprovado);
		bibliotecaTecProg.doarPublicacao(artigoDocumentacaoTecnica);
		bibliotecaTecProg.doarPublicacao(comparativoJavaPython);
		bibliotecaTecProg.doarPublicacao(indico);
		
		bibliotecaTecProg.emprestarPublicacao(professorJoao, livroComoPogramar);
		bibliotecaTecProg.emprestarPublicacao(professorMarcos, livroComoPogramar);
		bibliotecaTecProg.emprestarPublicacao(alunaMaria, livroSerAprovado);
		bibliotecaTecProg.emprestarPublicacao(alunaAnaPaula, livroSerAprovado);
		bibliotecaTecProg.emprestarPublicacao(servidorThales, livroComoPogramar);
		bibliotecaTecProg.emprestarPublicacao(servidoraMichele, artigoDocumentacaoTecnica);
		bibliotecaTecProg.emprestarPublicacao(professorMarcos, artigoDocumentacaoTecnica);
		bibliotecaTecProg.emprestarPublicacao(alunaMaria, comparativoJavaPython);
		bibliotecaTecProg.emprestarPublicacao(alunaAnaPaula, comparativoJavaPython);
		
		System.out.println("\n");
		System.out.println(bibliotecaTecProg.gerarRelatorioEmprestimos());
		System.out.println("\n");
		System.out.println(bibliotecaTecProg.gerarRelatorioAcervoPublicacoes());
		System.out.println("\n");
		System.out.println(bibliotecaTecProg.gerarRelatorioClientes());
		System.out.println("\n");
		
		if (bibliotecaTecProg.verificarNumeroMatricula(45456) != null) {
			for (Publicacao publicacao : bibliotecaTecProg.verificarNumeroMatricula(45456)) {
				System.out.println(publicacao.getTitulo());
			}
		}
		
		System.out.println("\n");
		
		if (bibliotecaTecProg.verificarNumeroMatricula(12222) != null) {
			for (Publicacao publicacao : bibliotecaTecProg.verificarNumeroMatricula(12222)) {
				System.out.println(publicacao.getTitulo());
			}
		}
		
		System.out.println("\n");
		
		for (Emprestimo emprestimo : bibliotecaTecProg.verHistoricoEmprestimos(alunaAnaPaula)) {
			System.out.println(emprestimo.toString());
		}
		
		System.out.println("\n");
		
		if (bibliotecaTecProg.procurarPublicacao("Como Programar em java") != null) {
			System.out.println(bibliotecaTecProg.procurarPublicacao("Como Programar em java").toString());
		}
		
		System.out.println("\n");
		
		if (bibliotecaTecProg.procurarPublicacao("Como Programar em python") != null) {
			System.out.println(bibliotecaTecProg.procurarPublicacao("Como Programar em python").toString());
		}
		
		System.out.println("\n");
		
	}

}
