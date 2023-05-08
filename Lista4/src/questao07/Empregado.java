package questao07;

public class Empregado {
	
	public String nome;
	protected double salario;
	
	public Empregado(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String toString() {
		return "id: " + this.hashCode() + "\nnome: " + this.nome + "\nsalario: " + this.salario;
	}

}
