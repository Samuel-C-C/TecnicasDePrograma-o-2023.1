package apresentacao;

import javax.swing.JOptionPane;

public class Tela implements EntradaSaida{

	public String pedirString(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}

	public int pedirInteiro(String mensagem) {
		while (true) {
			try {
				String entrada = JOptionPane.showInputDialog(mensagem);
				return Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				this.escreverMensagem("Valor inválido! Digite novamente");
			} 
		} 
	}

	public void escreverMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
		
	}

	public boolean pedirBoolean(String mensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem) == 0;
	}
}
