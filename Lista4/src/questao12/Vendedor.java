package questao12;

import questao10.Empregado;

public class Vendedor extends Empregado {
	
	private double valorVendas;
	private double comissao;
	
	public double getValorVendas() {
		return valorVendas;
	}
	
	public void setValorVendas(double valorVendas) {
		this.valorVendas = valorVendas;
	}
	
	public double getComissao() {
		return comissao;
	}
	
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public Vendedor(String nome, String cpf, int codigoSetor, double salarioBase, double imposto,
			double comissao) {
		super(nome, cpf, codigoSetor, salarioBase, imposto);
		this.comissao = comissao;
		this.valorVendas = 0;
	}
	
	public double calcularSalario() {
		return super.calcularSalario() + this.valorVendas * this.comissao;
	}

}
