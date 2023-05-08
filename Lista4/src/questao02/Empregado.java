package questao02;

public class Empregado {
	
	private String primeiroNome;
	private String sobreNome;
	private double salarioMensal;
	
	public Empregado(String primeiroNome, String sobreNome, double salarioMensal) {
		
		this.primeiroNome = primeiroNome;
		
		this.sobreNome = sobreNome;
		
		if (salarioMensal < 0) {
			salarioMensal = 0;
		}
		
		this.salarioMensal = salarioMensal;
		
	}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public double getSalarioMensal() {
		return salarioMensal;
	}
	
	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}
	
	public void exibirSalarioAnual() {
		System.out.println("Salario anual de " + this.primeiroNome + " " + this.sobreNome + ": " + 12 * this.salarioMensal);
	}
	
	public void aumentarSalario(double porcentagem) {
		this.salarioMensal = this.salarioMensal * (1 + porcentagem);
	}

}
