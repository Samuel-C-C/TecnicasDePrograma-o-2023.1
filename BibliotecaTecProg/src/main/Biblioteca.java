package main;

import java.util.ArrayList;

import pessoas.*;
import publicacoes.*;

public class Biblioteca {
	
	private ArrayList<Publicacao> listaPublicacoes;
	private ArrayList<Emprestimo> registroEmprestimos;
	private ArrayList<Cliente> listaClientes;
	
	public ArrayList<Publicacao> getListaPublicacoes() {
		return listaPublicacoes;
	}
	
	public ArrayList<Emprestimo> getRegisroEmprestimos() {
		return registroEmprestimos;
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public Biblioteca() {
		this.listaPublicacoes = new ArrayList<Publicacao>();
		this.registroEmprestimos = new ArrayList<Emprestimo>();
		this.listaClientes = new ArrayList<Cliente>();
	}
	
	public void doarPublicacao(Publicacao publicacao) {
		this.listaPublicacoes.add(publicacao);
	}
	
	public void emprestarPublicacao(Cliente cliente, Publicacao publicacao) {
		if (!this.listaPublicacoes.contains(publicacao)) {
			System.out.println(publicacao.getTitulo()  + " não existe na biblioteca");
			return;
		}
		if (publicacao.getQuantidadeDisponivel() <= 0) {
			System.out.println("não há mais exemplares de " + publicacao.getTitulo() + " na biblioteca");
			return;
		}
		if (cliente.getPublicacoesPegasEmprestadas().size() >= cliente.getMaximoNumeroPublicacoesPegasEmprestadas()) {
			System.out.println(cliente.getNome() + " não pode mais pegar publicações emprestados");
			return;
		}
		if (cliente.verificarTp()) {
			System.out.println(cliente.getNome() + " precisa doar uma publicação antes de poder pegar mais alguma publicação");
		}
		
		Emprestimo emprestimo = new Emprestimo(publicacao, cliente);
		this.registroEmprestimos.add(emprestimo);
		
		if (!this.listaClientes.contains(cliente)) {
			this.listaClientes.add(cliente);
		}
		
	}
	
	public ArrayList<Publicacao> verificarNumeroMatricula(int matricula) {
		
		boolean clienteFoiAchado = false;
		for (int i = 0; i < this.listaClientes.size() && !clienteFoiAchado; i++) {
			Cliente cliente = this.listaClientes.get(i);
			
			if (cliente.getMatricula() == matricula) {
				clienteFoiAchado = true;
			}
		}
		
		if (!clienteFoiAchado) {
			System.out.println("cliente com " + matricula + " como número de matricula não encontrado");
			return null;
		}
		
		ArrayList<Publicacao> publicacoesEmprestadasCliente = new ArrayList<Publicacao>();
		for (Emprestimo emprestimo : this.registroEmprestimos) {
			if (emprestimo.getCliente().getMatricula() == matricula) {
				publicacoesEmprestadasCliente.add(emprestimo.getPublicacaoEmprestada());
			}
		}
		
		return publicacoesEmprestadasCliente;
	}
	
	public ArrayList<Emprestimo> verHistoricoEmprestimos(Cliente cliente) {
		ArrayList<Emprestimo> emprestimosCliente = new ArrayList<Emprestimo>();
		
		for (Emprestimo emprestimo : this.registroEmprestimos) {
			if (emprestimo.getCliente().equals(cliente)) {
				emprestimosCliente.add(emprestimo);
			}
		}
		
		return emprestimosCliente;
	}
	
	public Publicacao procurarPublicacao(String titulo) {
		for (Publicacao publicacao : this.listaPublicacoes) {
			if (publicacao.getTitulo().equals(titulo)) {
				return publicacao;
			}
		}
		
		return null;
	}
	
	public String gerarRelatorioEmprestimos() {
		
		ArrayList<Cliente> emprestimosLivros = new ArrayList<Cliente>();
		ArrayList<Cliente> emprestimosArtigos = new ArrayList<Cliente>();
		ArrayList<Cliente> emprestimosTCCs = new ArrayList<Cliente>();
		ArrayList<Cliente> emprestimosRevistas = new ArrayList<Cliente>();
		
		for (Emprestimo emprestimo : this.registroEmprestimos) {
			if (emprestimo.getPublicacaoEmprestada() instanceof Livro) {
				emprestimosLivros.add(emprestimo.getCliente());
			} else if (emprestimo.getPublicacaoEmprestada() instanceof TCC) {
				emprestimosTCCs.add(emprestimo.getCliente());
			} else if (emprestimo.getPublicacaoEmprestada() instanceof Artigo) {
				emprestimosArtigos.add(emprestimo.getCliente());
			} else if (emprestimo.getPublicacaoEmprestada() instanceof Revista) {
				emprestimosRevistas.add(emprestimo.getCliente());
			}
		}
		
		String relatorio = "";
		
		String parteProfessor, parteAluno, parteServidor;
		int numeroProfessores, numeroAlunos, numeroServidores;
		
		relatorio += "Livros: Total " + emprestimosLivros.size();
		parteProfessor = " Professor: ";
		numeroProfessores = 0;
		parteAluno = "Aluno: ";
		numeroAlunos = 0;
		parteServidor = "Servidor: ";
		numeroServidores = 0;
		
		for (Cliente cliente : emprestimosLivros) {
			if (cliente instanceof Professor) {
				if (numeroProfessores > 0) {
					parteProfessor += " - ";
				}
				parteProfessor += cliente.getNome();
				numeroProfessores++;
			} else if (cliente instanceof Aluno) {
				if (numeroAlunos > 0) {
					parteAluno += " - ";
				}
				parteAluno += cliente.getNome();
				numeroAlunos++;
			} else if (cliente instanceof Servidor) {
				if (numeroServidores > 0) {
					parteServidor += " - ";
				}
				parteServidor += cliente.getNome();
				numeroServidores++;
			}
		}
		relatorio += parteProfessor + "; " + parteAluno + "; " + parteServidor + ";\n\n";
		
		relatorio += "Artigos: Total " + emprestimosArtigos.size();
		parteProfessor = " Professor: ";
		numeroProfessores = 0;
		parteAluno = "Aluno: ";
		numeroAlunos = 0;
		parteServidor = "Servidor: ";
		numeroServidores = 0;
		
		for (Cliente cliente : emprestimosArtigos) {
			if (cliente instanceof Professor) {
				if (numeroProfessores > 0) {
					parteProfessor += " - ";
				}
				parteProfessor += cliente.getNome();
				numeroProfessores++;
			} else if (cliente instanceof Aluno) {
				if (numeroAlunos > 0) {
					parteAluno += " - ";
				}
				parteAluno += cliente.getNome();
				numeroAlunos++;
			} else if (cliente instanceof Servidor) {
				if (numeroServidores > 0) {
					parteServidor += " - ";
				}
				parteServidor += cliente.getNome();
				numeroServidores++;
			}
		}
		relatorio += parteProfessor + "; " + parteAluno + "; " + parteServidor + ";\n\n";
		
		relatorio += "TCCs: Total " + emprestimosTCCs.size();
		parteProfessor = " Professor: ";
		numeroProfessores = 0;
		parteAluno = "Aluno: ";
		numeroAlunos = 0;
		parteServidor = "Servidor: ";
		numeroServidores = 0;
		
		for (Cliente cliente : emprestimosTCCs) {
			if (cliente instanceof Professor) {
				if (numeroProfessores > 0) {
					parteProfessor += " - ";
				}
				parteProfessor += cliente.getNome();
				numeroProfessores++;
			} else if (cliente instanceof Aluno) {
				if (numeroAlunos > 0) {
					parteAluno += " - ";
				}
				parteAluno += cliente.getNome();
			} else if (cliente instanceof Servidor) {
				if (numeroServidores > 0) {
					parteServidor += " - ";
				}
				parteServidor += cliente.getNome();
			}
		}
		relatorio += parteProfessor + "; " + parteAluno + "; " + parteServidor + ";\n\n";
		
		relatorio += "Revista: Total " + emprestimosRevistas.size();
		parteProfessor = " Professor: ";
		numeroProfessores = 0;
		parteAluno = "Aluno: ";
		numeroAlunos = 0;
		parteServidor = "Servidor: ";
		numeroServidores = 0;
		
		for (Cliente cliente : emprestimosRevistas) {
			if (cliente instanceof Professor) {
				if (numeroProfessores > 0) {
					parteProfessor += " - ";
				}
				parteProfessor += cliente.getNome();
				numeroProfessores++;
			} else if (cliente instanceof Aluno) {
				if (numeroAlunos > 0) {
					parteAluno += " - ";
				}
				parteAluno += cliente.getNome();
				numeroAlunos++;
			} else if (cliente instanceof Servidor) {
				if (numeroServidores > 0) {
					parteServidor += " - ";
				}
				parteServidor += cliente.getNome();
				numeroServidores++;
			}
		}
		relatorio += parteProfessor + "; " + parteAluno + "; " + parteServidor + ";";
		
		return relatorio;
		
	}
	
	public String gerarRelatorioAcervoPublicacoes() {
		String relatorio = "";
		
		ArrayList<Publicacao> livros = new ArrayList<Publicacao>();
		ArrayList<Publicacao> artigos = new ArrayList<Publicacao>();
		ArrayList<Publicacao> revistas = new ArrayList<Publicacao>();
		
		for (Publicacao publicacao : this.listaPublicacoes) {
			if (publicacao instanceof Livro) {
				livros.add(publicacao);
			} else if (publicacao instanceof Artigo) {
				artigos.add(publicacao);
			} else if (publicacao instanceof Revista) {
				revistas.add(publicacao);
			}
		}
		
		relatorio += "Livros:\n";
		for (int i = 0; i < livros.size(); i++) {
			Publicacao publicacao = livros.get(i);
			relatorio += (i + 1) + " - " + publicacao.getTitulo() + "; " + publicacao.getAnoPublicacao() + "; ";
			
			for (int autorIndex = 0; autorIndex < publicacao.getAutores().size(); autorIndex++) {
				Pessoa autor = publicacao.getAutores().get(autorIndex);
				
				if (autorIndex > 0) 
					relatorio += " - ";
				relatorio += autor.getNome();
			}
			
			relatorio += "\n";
		}
		
		relatorio += "Artigos:\n";
		for (int i = 0; i < artigos.size(); i++) {
			Publicacao publicacao = artigos.get(i);
			relatorio += (i + 1) + " - " + publicacao.getTitulo() + "; " + publicacao.getAnoPublicacao() + "; ";
			
			for (int autorIndex = 0; autorIndex < publicacao.getAutores().size(); autorIndex++) {
				Pessoa autor = publicacao.getAutores().get(autorIndex);
				
				if (autorIndex > 0) 
					relatorio += " - ";
				relatorio += autor.getNome();
			}
			
			relatorio += "\n";
		}
		
		relatorio += "Revistas:\n";
		for (int i = 0; i < revistas.size(); i++) {
			Publicacao publicacao = revistas.get(i);
			relatorio += (i + 1) + " - " + publicacao.getTitulo() + "; " + publicacao.getAnoPublicacao() + "; ";
		
			for (int autorIndex = 0; autorIndex < publicacao.getAutores().size(); autorIndex++) {
				Pessoa autor = publicacao.getAutores().get(autorIndex);
				
				if (autorIndex > 0) 
					relatorio += " - ";
				relatorio += autor.getNome();
			}
			
			relatorio += "\n";
		}
		
		return relatorio;
	}
	
	public String gerarRelatorioClientes() {
		String relatorio = "";
		
		ArrayList<Cliente> listaProfessores = new ArrayList<Cliente>();
		ArrayList<Cliente> listaAlunos = new ArrayList<Cliente>();
		ArrayList<Cliente> listaServidores = new ArrayList<Cliente>();
		
		for (Cliente cliente : this.listaClientes) {
			if (cliente instanceof Professor) {
				listaProfessores.add(cliente);
			} else if (cliente instanceof Aluno) {
				listaAlunos.add(cliente);
			} else if (cliente instanceof Servidor) {
				listaServidores.add(cliente);
			}
		}
		
		relatorio += "Professores:\n";
		for (int i = 0; i < listaProfessores.size(); i++) {
			Cliente cliente = listaProfessores.get(i);
			
			relatorio += (i + 1) + " " + cliente.getMatricula() + "; " + cliente.getNome() + "; " + cliente.getTP() + "\n";
		}
		
		relatorio += "\n";
		
		relatorio += "Alunos:\n";
		for (int i = 0; i < listaAlunos.size(); i++) {
			Cliente cliente = listaAlunos.get(i);
			
			relatorio += (i + 1) + " " + cliente.getMatricula() + "; " + cliente.getNome() + "; " + cliente.getTP() + "\n";
		}
		
		relatorio += "\n";
		
		relatorio += "Servidores:\n";
		for (int i = 0; i < listaServidores.size(); i++) {
			Cliente cliente = listaServidores.get(i);
			
			relatorio += (i + 1) + " " + cliente.getMatricula() + "; " + cliente.getNome() + "; " + cliente.getTP() + "\n";
		}
		
		return relatorio;
	}

}
