
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;

public class Questao09 {

	public static void main(String[] args) {
		
		/*
		 * Faça um programa para gerar todas as permutações de um conjunto de 
		 * caracteres (por exemplo, "ABC" pode gerar "ABC", "ACB", "BAC", 
		 * "BCA", "CAB" e "CBA").
		 */
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("conjunto de caracteres a ser permutado: ");
		String conjuntoCaracteres = reader.nextLine();
		
		reader.close();
		
		conjuntoCaracteres.replace(" ", "");
		
		ArrayList<String> permutacoes = new ArrayList<>();
		permutacoes.add("");
		
		int tamanhoStringPermutacoes = 0;
		
		while (tamanhoStringPermutacoes < conjuntoCaracteres.length()) {
			
			ArrayList<String> novasPermutacoes = new ArrayList<>();
			
			for (String string : permutacoes) {
				
				String letrasFaltando = "";
				letrasFaltando += conjuntoCaracteres;
				
				for (int index = 0; index < string.length(); index++) {
					
					String letra = "";
					letra += string.charAt(index);
					
					letrasFaltando = letrasFaltando.replaceFirst(letra, "");
					
				}
				
				for (int index = 0; index < letrasFaltando.length(); index++) {
					
					String novaPermutacao = string + letrasFaltando.charAt(index);
					novasPermutacoes.add(novaPermutacao);
					
				}
				
			}
			
			tamanhoStringPermutacoes++;
			
			permutacoes.clear();
			for (String permutacao : novasPermutacoes) {
				permutacoes.add(permutacao);
			}
			novasPermutacoes.clear();
			
		}
		
		for (String permutacao : permutacoes) {
			System.out.println(permutacao);
		}
		
	}

}
