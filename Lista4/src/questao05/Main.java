package questao05;

public class Main {

	public static void main(String[] args) throws Exception {
		
		/*
		 * Um contato é constituído de código, nome da pessoa, endereço, e-mail, 
		 * telefone e observação.
		 * a. Crie 4 construtores e atribua o valores por meio dos construtores. Os 
		 * construtores devem receber os seguintes parâmetros:
		 * I. Código.
		 * II. Código e nome.
		 * III. Código, nome e e-mail.
		 * IV. Telefone.
		 * b. O atributo e-mail não poderá ser modificado fora da classe contato, mas 
		 * poderá ser acessado por outras classes. 
		 * c. Faça um método para imprimir o código, nome, endereço, e-mail, telefone 
		 * e observação dos contatos cadastrados. 
		 * d. Faça um validador do código do contato. Um código válido é maior 
		 * igual a 1000 e menor igual a 9999. Não permita que seja cadastrado 
		 * um código inválido para nenhum contato. 
		 * e. Faça um validador para o telefone. O telefone sempre deverá ter 8 dígitos. 
		 * Não permita que seja cadastrado um telefone inválido para nenhum contato. 
		 * f. Crie um método que possa duplicar um contato. Desta forma, um novo 
		 * contato terá os mesmos dados do contato que for requerido a duplicação. 
		 * g. Faça um método para verificar se o contato está totalmente preenchido. 
		 * Ou seja, tenha valores diferentes do padrão para: código, nome, endereço, e-mail, 
		 * telefone e observação. 
		 * h. Crie uma classe agenda que é composta de uma lista de contatos, nome 
		 * da agenda e uma descrição. 
		 * i. Crie uma classe cliente que poderá usar uma agenda. 
		 * j. Faça uma classe main para testar seu sistema criado.
		 */
		
		Cliente clienteTeste = new Cliente("Sebastiana Mariane Assis");
		
		Agenda agendaTeste = clienteTeste.criarAgenda("Contatos do Trabalho", 
				"Contatos da empresa que trabalham comigo");
		
		agendaTeste.adicionarContato(new Contato(1614, "Mirella Aline Barros", "mirella.aline78@gmail.com"));
		agendaTeste.adicionarContato(new Contato(8985, "Flávia Marina Isabella Nogueira", "flavia_nogueira@hotmail.com"));
		agendaTeste.adicionarContato(new Contato(3806, "Marcos Vinicius Vitor Vieira", "marcus_vvv12@gmail.com"));
		
		agendaTeste.getListaDeContatos().get(0).setTelefone("91238765");
		agendaTeste.getListaDeContatos().get(0).setEndereco("Rua Brigadeiro Eduardo Gomes");
		agendaTeste.getListaDeContatos().get(0).setObservacao("chefe");
		
		agendaTeste.getListaDeContatos().get(1).setEndereco("Avenida José Euclides");
		agendaTeste.getListaDeContatos().get(1).setObservacao("veterana");
		
		agendaTeste.getListaDeContatos().get(2).setEndereco("Rua Dom Jonas Batinga");
		
		for (Contato contato : agendaTeste.getListaDeContatos()) {
			if (contato.estaTotalmentePreenchido()) {
				System.out.println("o contato de " + contato.getNomePessoa() + " está todo preenchido");
			}
			
			contato.imprimirContato();
			
		}

	}

}
