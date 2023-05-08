package questao07;

public class Vendedor extends Empregado{
	
	private double percentualComissao;
	
	public double getPercentualComissao() {
		return percentualComissao;
	}
	
	public void setPercentualComissao(double percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public Vendedor(String nome, double salario, double percentualComissao) {
		super(nome, salario);
		this.percentualComissao = percentualComissao;
	}
	
	public float calcularSalario() {
		return (float) (this.salario * (1 + this.percentualComissao));
	}
	
	public String toString() {
		return super.toString() + "\nsalario com comissao: " + this.calcularSalario() +
				"\npercentual de comissao: " + this.percentualComissao;
	}

}
