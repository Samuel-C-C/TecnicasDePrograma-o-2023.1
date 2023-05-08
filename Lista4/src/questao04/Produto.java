package questao04;

public class Produto {
	
	private String nome;
	private double preco;
	private int quantidade;
	
	public Produto(String nome, double preco, int quantidade) {
		
		this.nome = nome;
		
		if (preco < 0) {
			preco = 0;
		}
		this.preco = preco;
		
		if (quantidade < 0) {
			quantidade = 0;
		}
		this.quantidade = quantidade;
		
	}
	
	public void comprarProduto(int quantidade) {
		
		if (quantidade < 0) {
			quantidade = 0;
		}
		
		if (quantidade > this.quantidade) {
			quantidade = this.quantidade;
		}
		
		double precoTotal = quantidade * this.preco;
		
		if (100 < precoTotal && precoTotal <= 200) {
			precoTotal *= 0.9;
		} else if (200 < precoTotal && precoTotal <= 500) {
			precoTotal *= 0.8;
		} else if (500 < precoTotal) {
			precoTotal *= 0.75;
		}
		
		System.out.println("nome: " + this.nome + " - valor total: " + precoTotal);
		
	}

}
