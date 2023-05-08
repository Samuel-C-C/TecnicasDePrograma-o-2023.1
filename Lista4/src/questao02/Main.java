package questao02;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * A fim de representar empregados em uma firma, você deverá criar uma 
		 * classe chamada Empregado. Esta classe deverá possuir as três informações 
		 * a seguir: 
		 * a. Um primeiro nome, 
		 * b. Um sobrenome, 
		 * c. Um salário mensal. 
		 * Sua classe deve ter um construtor que inicializa os três atributos. Forneça um 
		 * método set e get para cada atributo. Se o salário mensal não for positivo, 
		 * configure-o como 0.0. Crie duas instâncias da classe e exiba o salário anual de cada 
		 * instância. Então dê a cada empregado um aumento de 10% e exiba novamente o 
		 * salário anual de cada empregado.
		 */
		
		Empregado primeiroEmpregado = new Empregado("João Batista", "Gomes", 1300.50);
		Empregado segundoEmpregado = new Empregado("Sarah Manuela", "Dias", 2560.20);
		
		primeiroEmpregado.exibirSalarioAnual();
		segundoEmpregado.exibirSalarioAnual();
		
		primeiroEmpregado.aumentarSalario(0.1);
		segundoEmpregado.aumentarSalario(0.1);
		
		System.out.println("");
		primeiroEmpregado.exibirSalarioAnual();
		segundoEmpregado.exibirSalarioAnual();
		

	}

}
