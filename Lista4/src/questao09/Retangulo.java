package questao09;

public class Retangulo extends Forma {
	
	public double largura;
	public double comprimento;

	public Retangulo(double largura, double comprimento) {
		super();
		this.largura = largura;
		this.comprimento = comprimento;
		
	}

	public double calcularArea() {
		return this.largura * this.comprimento;
	}

	public void imprimirNome() {
		System.out.println("retângulo");
	}
	
}
