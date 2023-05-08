package questao11;

import questao10.Empregado;

public class Operario extends Empregado {
	
	private double valorProducao;
	private double comissao;
	
	public double getValorProducao() {
		return valorProducao;
	}
	
	public void setValorProducao(double valorProducao) {
		this.valorProducao = valorProducao;
	}
	
	public double getComissao() {
		return comissao;
	}
	
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public Operario(String nome, String cpf, int codigoSetor, double salarioBase, double imposto, 
			double valorProducao, double comissao) {
		super(nome, cpf, codigoSetor, salarioBase, imposto);
		this.valorProducao = valorProducao;
		this.comissao = comissao;
	}
	
	
	public double calcularSalario() {
		return super.calcularSalario() + this.valorProducao * this.comissao;
	}

}
