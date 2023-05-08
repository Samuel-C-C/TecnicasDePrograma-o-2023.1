package questao05;

public class Contato {
	
	private int codigo;
	private String nomePessoa;
	private String endereco;
	private String email;
	private String telefone;
	private String observacao;
	
	public Contato(int codigo) throws Exception {
		
		if (codigo < 1000 || 9999 < codigo ) {
			throw new Exception("código inválido");
		}
		
		this.codigo = codigo;
		
	}
	
	public Contato(int codigo, String nome) throws Exception {
		
		if (codigo < 1000 || 9999 < codigo ) {
			throw new Exception("código inválido");
		}
		
		this.codigo = codigo;
		this.nomePessoa = nome;
		
	}
	
	public Contato(int codigo, String nome, String email) throws Exception {
		
		if (codigo < 1000 || 9999 < codigo ) {
			throw new Exception("código inválido");
		}
		
		this.codigo = codigo;
		this.nomePessoa = nome;
		this.email = email;
		
	}
	
	public Contato(String telefone) throws Exception {
		
		if (telefone.length() != 8) {
			throw new Exception("telefone inválido");
		}
		
		this.telefone = telefone;
	}
	
	private Contato() {
		;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) throws Exception {
		if (codigo < 1000 || 9999 < codigo ) {
			throw new Exception("código inválido");
		}
		
		this.codigo = codigo;
	}
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) throws Exception {
		if (telefone.length() != 8) {
			throw new Exception("telefone inválido");
		}
		
		this.telefone = telefone;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public void imprimirContato() {
		System.out.println("---");
		System.out.println("código: " + this.codigo);
		System.out.println("nome: " + this.nomePessoa);
		System.out.println("endereço: " + this.endereco);
		System.out.println("e-mail: " + this.email);
		System.out.println("telefone: " + this.telefone);
		System.out.println("observação: " + this.observacao);
		System.out.println("---");
	}
	
	public Contato duplicar() {
		
		Contato novoContato = new Contato();
		
		novoContato.codigo = this.codigo;
		novoContato.nomePessoa = this.nomePessoa;
		novoContato.endereco = this.endereco;
		novoContato.email = this.email;
		novoContato.telefone = this.telefone;
		novoContato.observacao = this.observacao;
		
		return novoContato;
		
	}
	
	public boolean estaTotalmentePreenchido() {
		
		Contato contatoGenerico = new Contato();
		return this.codigo != contatoGenerico.codigo && this.nomePessoa != contatoGenerico.nomePessoa
				&& this.endereco != contatoGenerico.endereco && this.email != contatoGenerico.email
				&& this.telefone != contatoGenerico.telefone && this.observacao != contatoGenerico.observacao;
		
	}

}
