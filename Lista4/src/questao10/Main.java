package questao10;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 10)Considere, como subclasse da classe Pessoa, a classe Empregado. 
		 * Considere que cada instância da classe Empregado tem, para além dos 
		 * atributos que caracterizam a classe Pessoa, os atributos codigoSetor 
		 * (inteiro), salarioBase (vencimento base) e imposto (porcentagem retida dos 
		 * impostos). Implemente a classe Empregado com métodos seletores e 
		 * modificadores e um método calcularSalario. Escreva um programa de teste 
		 * adequado para a classe Empregado.
		 */
		
		Empregado empregado = new Empregado("Tatiane Ana Antonella Lopes", "185.484.565-90", 12, 1200, 0.05);
		System.out.println("Salario de " + empregado.getNome() + ": " + empregado.calcularSalario());
		
	}

}
