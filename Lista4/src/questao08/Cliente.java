package questao08;

public class Cliente {
	
	protected String nome;
	private ContaEspecial conta;
	
	public ContaEspecial getConta() {
		return conta;
	}
	
	public void setConta(ContaEspecial conta) {
		this.conta = conta;
	}
	
	public Cliente(String nome, int agencia, int conta, int banco, double limiteCredito) {
		this.nome = nome;
		
		if (limiteCredito < 0)
			limiteCredito = 0;
		
		this.conta = new ContaEspecial(agencia, conta, banco, limiteCredito);
		
	}

}
