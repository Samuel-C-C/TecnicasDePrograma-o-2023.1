package questao14;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Criar a classe Pessoa com as seguintes características: 
		 * ● atributos: idade e dia, mês e ano de nascimento, nome da pessoa 
		 * ● métodos: o calculaIdade(), que recebe a data atual em dias, mês e anos e 
		 * calcula e armazena no atributo idade a idade atual da pessoa o 
		 * informaIdade(), que retorna o valor da idade o informaNome(), que retorna 
		 * o nome da pessoa o ajustaDataDeNascimento(), que recebe dia, mês e 
		 * ano de nascimento como parâmetros e preenche nos atributos 
		 * correspondentes do objeto. 
		 * ● Criar dois objetos da classe Pessoa, um representando Albert Einstein 
		 * (nascido em 14/3/1879) e o outro representando Isaac Newton (nascido 
		 * em 4/1/1643) 
		 * ● Fazer uma classe principal que cria os objetos, inicialize e mostre quais 
		 * seriam as idades de Einstein e Newton caso estivessem vivos.
		 */
		
		Pessoa albert = new Pessoa("Albert Einstein", 14, 3, 1879);
		Pessoa isaac = new Pessoa("Isaac Newton", 4, 1, 1643);
		
		albert.calcularIdade(28, 4, 2023);
		isaac.calcularIdade(28, 4, 2023);
		
		System.out.println(albert.informaNome() + " teria " + albert.informaIdade() + " anos de idade hoje");
		System.out.println(isaac.informaNome() + " teria " + isaac.informaIdade() + " anos de idade hoje");
		
	}

}
