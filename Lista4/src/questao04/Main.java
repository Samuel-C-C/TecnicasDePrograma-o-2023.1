package questao04;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Crie um programa que tenha uma classe produto constituída de nome, preço 
		 * e quantidade. Implemente um método chamado “comprarProduto”. Este 
		 * método quando chamado deverá modificar uma variável do produto indicando 
		 * que o produto foi comprado. Para cada produto informado escreva o nome do 
		 * produto comprado e o valor total a ser pago, considerando que são 
		 * oferecidos descontos segundo o valor do produto conforme a tabela abaixo: 
		 * a. Até R$ 100: sem desconto 
		 * b. De R$ 100 a R$ 200: 10% de desconto 
		 * c. De R$ 200 a R$ 500: 20% de desconto 
		 * d. Acima de R$500: 25% de desconto
		 */
		
		Produto novoProduto = new Produto("leite em pó", 35.70, 100);
		
		novoProduto.comprarProduto(5);

	}

}
