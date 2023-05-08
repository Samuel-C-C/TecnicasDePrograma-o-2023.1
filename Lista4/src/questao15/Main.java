package questao15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 15)Crie uma classe Produto, essa classe deverá conter os seguintes atributos: 
		 * nome do produto, preço de custo, preço de venda, margem de lucro e 
		 * despesas da empresa. E o método: Cálculo da Margem de Lucros. OBS: 
		 * Cálculo da Margem de Lucro: Margem de Lucro = {[PV – (PC + D)] / PV]} x 
		 * 100. Com - PC= Preço de Custo, PV= Preço de Venda, D= Despesas. Por 
		 * fim, no método main(), crie um novo objeto da classe Produto, peça para o 
		 * usuário informar o nome, os preços de custo e de venda e exiba a margem 
		 * de lucro em porcentagem.
		 */
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("nome do produto: ");
		String nome = teclado.nextLine();
		
		double precoCusto;
		do {
			System.out.print("preço de custo do produto: ");
			precoCusto = teclado.nextDouble();
			
			if (precoCusto < 0) {
				System.out.println("o preco de custo não pode ser negativo");
			} else if (precoCusto == 0) {
				System.out.println("o preco de custo não pode ser zero");
			}
			
		} while (precoCusto <= 0);
		
		double despesas;
		do {
			System.out.print("despesas do produto: ");
			despesas = teclado.nextDouble();
			
			if (despesas < 0) {
				System.out.println("as despesas não podem ser negativas");
			} else if (despesas == 0) {
				System.out.println("as despesas não podem ser zero");
			}
			
		} while (despesas <= 0);
		
		double precoVenda;
		do {
			System.out.print("preço de venda do produto: ");
			precoVenda = teclado.nextDouble();
			
			if (precoVenda < 0) {
				System.out.println("o preco de venda não pode ser negativo");
			} else if (precoVenda == 0) {
				System.out.println("o preco de venda não pode ser zero");
			}
			
		} while (precoVenda <= 0);
		
		teclado.close();
		
		Produto produto = new Produto(nome, precoCusto, precoVenda, despesas);
		produto.calcularMargemLucro();
		
		System.out.println("margem de lucro de " + produto.nome + ": " + produto.getMargemLucro() + "%");

	}

}
