package view;

import java.util.ArrayList;

public interface EntradaSaida {
	
	// entrada 
	public String pedirString(String mensagem);
	public int pedirInt(String mensagem);
	public boolean pedirBoolean(String mensagem, String trueString, String falseString);
	public int pedirOpcao(String mensagem, ArrayList<String> opcoes);
	
	// saida
	public void escreverln(String string);
	public void escrever(String string);

}
