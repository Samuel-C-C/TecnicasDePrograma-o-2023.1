package questao06;

public class IngressoVIP extends Ingresso {
	
	private double valorAdicional;
	
	public IngressoVIP(double valor, double valorAdicional) {
		super(valor);
		this.valorAdicional = valorAdicional;
	}
	
	public double getValorTotal() {
		return super.getValorTotal() + valorAdicional;
	}
	
	public String toString() {
		return "VIP - " + super.toString();
	}

}
