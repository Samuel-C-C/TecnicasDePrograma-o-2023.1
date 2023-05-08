package questao08;

public class ContaCorrente {
	
	private int agencia;
	private int conta;
	private int banco;
	
	protected double saldo;
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getConta() {
		return conta;
	}
	
	public int getBanco() {
		return banco;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public ContaCorrente(int agencia, int conta, int banco) {
		this.agencia = agencia;
		this.conta = conta;
		this.banco = banco;
		
		this.saldo = 0;
		
	}
	
	public void depositar(double valor) {
		if (valor >= 0)
			this.saldo += valor;
	}
	
	public void sacar(double valor) {
		if (valor >= 0 && this.saldo - valor >= 0)
			this.saldo -= valor;
	}

}
