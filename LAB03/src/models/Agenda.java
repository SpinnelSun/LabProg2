package models;

import java.util.Arrays;

import utility.Validador;

/**
 * Representação de uma agenda de contatos. Como atributos, cada Agenda possui um Array que contém
 * os Contatos armazenados (até 100 Contatos). 
 * 
 * Laboratório de Programação 2 - Lab 03
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public class Agenda {
	
	private Contato[] cadastros;
	
	/**
	 * Constrói uma Agenda de Contatos. O construtor cria um Array de Contatos (com 100 posições) a
	 * serem ocupadas posteriormente.
	 * 
	 */
	public Agenda() {
		this.cadastros = new Contato[100];
	}
	
	/**
	 * Verifica se a posição passada como parâmetro é valida. Para ser válida, a posição deverá ser
	 * um valor de 1 a 100 (posições possíveis numa agenda).
	 * 
	 * @param posicao A posição cuja validade deve ser testada pelo método.
	 * 
	 * @returns O boolean que representa a validez da posição passada como parâmetro.
	 * 
	 */
	public boolean verificarPosicaoValida (int posicao) {
		return Validador.validarIntUmACem(posicao);
	}
	
	/**
	 * Verifica se uma posição (passada como parâmetro) do Array de Contatos contém ou não um Contato
	 * cadastrado.
	 * 
	 * @param posicao A posição dos cadastros cujo conteúdo deve ser avaliado pelo método.
	 * 
	 * @returns O boolean que representa a validez do conteúdo avaliado.
	 * 
	 */
	public boolean verificarContatoCadastrado (int posicao) {
		return (this.cadastros[posicao - 1] != null);
	}
	
	/**
	 * Cria e armazena um novo Contato na Agenda, a partir das informações passadas por parâmetro.
	 * 
	 * @param posicao A posição da Agenda em que o novo Contato deve ser armazenado.
	 * @param nome O nome referente ao novo Contato que será armazenado.
	 * @param sobrenome O sobrenome referente ao novo Contato que será armazenado.
	 * @param telefone O telefone referente ao novo Contato que será armazenado.
	 * 
	 * @returns null.
	 * 
	 */
	public void cadastrarContato(int posicao, String nome, String sobrenome, String telefone) {
		this.cadastros[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}
	
	/**
	 * Retorna a representação do Contato armazenado na Agenda (na posição passada como parâmetro).
	 * 
	 * @param posicao A posição da Agenda em que se deseja buscar um Contato armazenado.
	 * 
	 * @returns Uma String que represente o Contato armazenado nessa posição.
	 * 
	 */
	public String exibirContato(int posicao) {
		return this.cadastros[posicao - 1].toString();
	}
	
	/**
	 * Retorna a listagem dos Contatos armazenados na Agenda. Cada Contato é representado resumida-
	 * nente no padrão POSIÇÃO - NOME SOBRENOME.
	 * 
	 * @returns Uma String de listagem dos Contatos cadastrados na Agenda.
	 * 
	 */
	public String listarContatos() {
		String listagemContatos = "";
		
		for (int i = 1; i < 101; i++) {
			if (verificarContatoCadastrado(i)) {
				listagemContatos += (i + " - " + this.cadastros[i - 1].getNomeCompleto() +
									System.lineSeparator());
			}
		}
		
		return listagemContatos;
	}
	
	/**
	 * Gera o HashCode da Agenda a partir do Array de Contatos que a Agenda armazena.
	 * 
	 * @returns O Hashcode da Agenda.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + Arrays.hashCode(cadastros);
		
		return result;
	}


	/**
	 * Checa se duas Agendas são ou não iguais. Para que haja igualdade, duas agendas deverão ter o
	 * mesmo conjunto de Contatos armazenados. Espera-se que o objeto do parâmetro também seja uma
	 * Agenda, caso não seja, retorna-se false.
	 * 
	 * @param obj O objeto a ser comparado com a Agenda executando o equals.
	 * @returns O boolean que equivalente ao teste de igualdade entre os dois objetos.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		
		if (obj == null) { return false; }
		
		if (getClass() != obj.getClass()) { return false; }
		
		Agenda other = (Agenda) obj;
		
		if (!this.listarContatos().equals(other.listarContatos())) { return false; }
		
		return true;
	}

	/**
	 * Retorna uma String que representa a Agenda. Tal representação utiliza os contatos cadastrados
	 * na Agenda.
	 * 
	 * @returns A representação, em String, de uma Agenda.
	 * 
	 */
	@Override
	public String toString() {
		return "CONTATOS CADASTRADOS: " + this.listarContatos();
	}

}