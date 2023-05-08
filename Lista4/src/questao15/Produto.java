package questao15;

public class Produto {
	
	protected String nome;
	protected double precoCusto;
	protected double precoVenda;
	protected double despesasEmpresa;
	
	private double margemLucro;
	
	public double getMargemLucro() {
		return margemLucro;
	}
	
	public Produto(String nome, double precoCusto, double precoVenda, double despesasEmpresa) {
		this.nome = nome;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.despesasEmpresa = despesasEmpresa;
	}

	public void calcularMargemLucro() {
		this.margemLucro = 100 * ((this.precoVenda - (this.precoCusto + this.despesasEmpresa)) / this.precoVenda);
	}

}
