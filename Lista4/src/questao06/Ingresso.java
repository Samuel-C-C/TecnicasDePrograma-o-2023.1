package questao06;

public class Ingresso {
	
	private double valor;
	
	public Ingresso(double valor) {
		this.valor = valor;
	}
	
	public double getValorTotal() {
		return valor;
	}
	
	public String toString() {
		
		return "número: " + this.hashCode() + " - valor: " + this.getValorTotal();
		
	}

}
