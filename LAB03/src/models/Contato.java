package models;

import utility.Validador;

/**
 * Representação de um contato a ser armazenado em uma agenda. Como atributos, cada Contato possui
 * nome, sobrenome e telefone (armazenados como Strings). 
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Contato {

	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Constrói um Contato a partir de um nome, um sobrenome e um telefone. Haverá lançamento de
	 * exceção adequada se algum dos atributos do objeto for nulo. Utiliza-se o trim() para que
	 * o Contato tenha uma estrutura mais adequada.
	 * 
	 * @param nome O primeiro nome do contato.
	 * @param sobrenome O sobrenome do contato.
	 * @param telefone O telefone do contato.
	 * 
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		Validador.validarStringNaoVaziaNaoNula("Nome nulo ou vazio!", nome);
		Validador.validarStringNaoVaziaNaoNula("Sobrenome nulo ou vazio!", sobrenome);
		Validador.validarStringNaoVaziaNaoNula("Telefone nulo ou vazio!", telefone);
		
		this.nome = nome.trim();
		this.sobrenome = sobrenome.trim();
		this.telefone = telefone.trim();
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Retorna o nome completo do Contato. O nome completo é a concatenação do nome e sobrenome do
	 * Contato, separados por um espaço em branco.
	 * 
	 * @returns A representação, em String, do nome completo de um Contato.
	 * 
	 */
	public String getNomeCompleto() {
		return this.getNome() + " " + this.getSobrenome();
	}
	
	/**
	 * Gera o HashCode do Contato a partir de seu nome e de seu sobrenome.
	 * 
	 * @returns O Hashcode do Contato.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		
		return result;
	}
	
	/**
	 * Avalia a igualdade entre dois Objetos. Para que haja igualdade, ambos deverão ter o mesmo
	 * nome e o mesmo sobrenome.
	 * 
	 * @param obj O objeto a ser comparado com o Contato executando o equals.
	 * 
	 * @returns O boolean que equivalente ao teste de igualdade entre dois Contatos.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		
		if (obj == null) { return false; }
		
		if (getClass() != obj.getClass()) { return false; }
		
		Contato other = (Contato) obj;
		
		if (nome == null) {
			if (other.nome != null) { return false; }		
		} else if (!nome.equals(other.nome)) { return false; }
		
		if (sobrenome == null) {
			if (other.sobrenome != null) { return false; }
			
		} else if (!sobrenome.equals(other.sobrenome)) { return false; }
		
		return true;
	}
	
	/**
	 * Retorna a String que representa o Contato. A representação segue o formato "NOME SOBRENOME - 
	 * TELEFONE".
	 * 
	 * @returns A representação, em String, de um Contato.
	 * 
	 */
	@Override
	public String toString() {
		return this.getNome() + " " + this.getSobrenome() + " - " + this.getTelefone();
	}
	
}
