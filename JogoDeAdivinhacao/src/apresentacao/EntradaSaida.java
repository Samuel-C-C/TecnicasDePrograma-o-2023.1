package apresentacao;

public interface EntradaSaida {
	
	public String pedirString(String mensagem);
	public int pedirInteiro(String mensagem);
	public boolean pedirBoolean(String mensagem);
	
	public void escreverMensagem(String mensagem);

}
