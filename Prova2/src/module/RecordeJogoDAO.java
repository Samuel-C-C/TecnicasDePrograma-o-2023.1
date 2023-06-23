package module;

import java.util.ArrayList;

import control.RecordeJogo;

/**
 * Usado para acessar o arquivo de texto com os dados dos recordes
 * 
 * @author Samuel
 */
public class RecordeJogoDAO {
	
	/**
	 * Um objeto usado para ler e escrever arquivos de texto
	 * 
	 * @see TextFileIO
	 */
	private TextFileIO textFileIO;
	
	/**
	 * Cria um {@code RecordeJogoDAO}
	 */
	public RecordeJogoDAO() {
		textFileIO = new TextFileIO();
	}
	
	/**
	 * Salva os recordes no arquivo
	 * 
	 * @param recordes um {@code ArrayList} de {@code RecordeJogo} que representa
	 * todos os recordes
	 * 
	 * @see ArrayList
	 * @see RecordeJogo
	 */
	public void salvar(ArrayList<RecordeJogo> recordes) {
		String dados = "";
		
		for (RecordeJogo recorde : recordes) {
			dados += recorde.getStringDeFormacao() + "\n";
		}
		
		textFileIO.Escrever(dados, "arquivos de texto/recordes.txt");
	}
	
	/**
	 * Carrega os recordes do arquivo
	 * 
	 * @return um {@code ArrayList} de {@code RecordeJogo} que representa todos os recordes
	 * 
	 * @see ArrayList
	 * @see RecordeJogo
	 */
	public ArrayList<RecordeJogo> carregar() {
		ArrayList<RecordeJogo> recordes = new ArrayList<>();
		
		String dados = textFileIO.Ler("arquivos de texto/recordes.txt");
		String[] linhas = dados.split("\n");
		
		for (String linha : linhas) {
			try {
				recordes.add(new RecordeJogo(linha));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		return recordes;
	}

}
