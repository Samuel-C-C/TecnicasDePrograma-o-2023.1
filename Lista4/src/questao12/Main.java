package questao12;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Implemente a classe Vendedor como subclasse da classe Empregado. Um 
		 * determinado vendedor tem como atributos, para além dos atributos da classe 
		 * Pessoa e da classe Empregado, o atributo valorVendas (correspondente ao 
		 * valor monetário dos artigos vendidos) e o atributo comissao (porcentagem do 
		 * valorVendas que será adicionado ao vencimento base do Vendedor). Note 
		 * que deverá redefinir nesta subclasse o método herdado calcularSalario (o 
		 * salário de um vendedor é equivalente ao salário de um empregado usual 
		 * acrescido da referida comissão). Escreva um programa de teste adequado 
		 * para esta classe.
		 */
		
		Vendedor vendedor = new Vendedor("Cauê Bento das Neves", "275.909.328-09", 
				196, 2000, 0.05, 0.1);
		vendedor.setValorVendas(800);
		
		System.out.println("salario de " + vendedor.getNome() + ": " + vendedor.calcularSalario());

	}

}
