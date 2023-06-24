package module;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Um objeto usado para ler e escrever arquivos de texto
 * 
 * @author Samuel
 */
public class TextFileIO {
	
	/**
	 * Escrever uma String em um arquivo de texto
	 * 
	 * @param dados string a ser escrita
	 * @param diretorio diretório do arquivo de texto
	 */
	public void escrever(String dados, String diretorio) {
		try {
			FileWriter arquivo = new FileWriter(diretorio);
			arquivo.write(dados);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ler uma string de um arquivo de texto
	 * 
	 * @param diretorio diretório do arquivo de texto
	 * @return uma string com oq tinha escrito no arquivo de texto
	 */
	public String ler(String diretorio) {
		try {
			FileReader arquivo = new FileReader(diretorio);
			BufferedReader arquivoLeitura = new BufferedReader(arquivo);
			
			String dados = "";
			while (arquivoLeitura.ready()) {
				dados += arquivoLeitura.readLine() + "\n";
			}
			
			arquivo.close();
			return dados;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
