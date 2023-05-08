package questao08;

public class ContaEspecial extends ContaCorrente {
	
	private double limiteCredito;

	public ContaEspecial(int agencia, int conta, int banco, double limiteCredito) {
		super(agencia, conta, banco);
		
		if (limiteCredito < 0)
			limiteCredito = 0;
		this.limiteCredito = limiteCredito;
		
	}

	public void sacar(double valor) {
		if (valor >= 0 && this.saldo - valor >= -this.limiteCredito)
			this.saldo -= valor;
		
	}

}
