package questao05;

public class Cliente {
	
	public String nome;
	
	public Cliente(String nome) {
		this.nome = nome;		
	}
	
	public Agenda criarAgenda(String nomeAgenda, String descricao) {
		
		Agenda novaAgenda = new Agenda(nomeAgenda, descricao);
		novaAgenda.setCliente(this);
		
		return novaAgenda;
		
	}

}
