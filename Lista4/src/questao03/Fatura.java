package questao03;

public class Fatura {
	
	private int itemCodigo;
	private String descricaoItem;
	private int quantidadeComprada;
	private double precoUnitario;
	private double precoTotal;
	
	public Fatura(int itemCodigo, String descricaoItem, int quantidadeComprada, double precoUnitario) {
		
		this.itemCodigo = itemCodigo;
		this.descricaoItem = descricaoItem;
		
		if (quantidadeComprada < 0) {
			quantidadeComprada = 0;
		}
		
		this.quantidadeComprada = quantidadeComprada;
		
		if (precoUnitario < 0) {
			precoUnitario = 0;
		}
		
		this.precoUnitario = precoUnitario;
		
	}
	
	public int getItemCodigo() {
		return itemCodigo;
	}
	
	public void setItemCodigo(int itemCodigo) {
		this.itemCodigo = itemCodigo;
	}
	
	public String getDescricaoItem() {
		return descricaoItem;
	}
	
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public double getValorFatura() {
		this.precoTotal = this.precoUnitario * this.quantidadeComprada;
		return this.precoTotal;
	}
	
	public void adicionarDesconto(double desconto) {
		this.precoUnitario *= (1 - desconto);
	}

}
