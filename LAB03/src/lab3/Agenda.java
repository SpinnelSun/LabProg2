package lab3;

import java.util.ArrayList;
import java.util.Arrays;

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
	 * @returns O boolean que representa a validez da posição passada como parâmetro.
	 * 
	 */
	public boolean validarPosicao (int posicao) {
		return ((posicao >= 1) && (posicao <= 100));
	}
	
	/**
	 * Avalia se uma posição (passada como parâmetro) do Array de Contatos contém ou não um Contato
	 * cadastrado.
	 * 
	 * @param posicao A posição dos cadastros cujo conteúdo deve ser avaliado pelo método.
	 * @returns O boolean que representa a validez do conteúdo avaliado.
	 * 
	 */
	public boolean validarContato (int posicao) {
		return (this.cadastros[posicao - 1] != null);
	}
	
	/**
	 * Cria e armazena um novo Contato na Agenda, a partir das informações passadas por parâmetro.
	 * Ocorre lançamento das exceções adequadas se algum dos parâmetros for uma String apenas com
	 * espaços em branco.
	 * 
	 * @param posicao A posição da Agenda em que o novo Contato deve ser armazenado.
	 * @param nome O nome referente ao novo Contato que será armazenado.
	 * @param sobrenome O sobrenome referente ao novo Contato que será armazenado.
	 * @param telefone O telefone referente ao novo Contato que será armazenado.
	 * @returns null.
	 * 
	 */
	public void novoCadastro(int posicao, String nome, String sobrenome, String telefone) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome Vazio!");
		} else if (sobrenome.trim().equals("")) {
			throw new IllegalArgumentException("Sobrenome Vazio!");
		} else if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone Vazio!");
		}
		
		this.cadastros[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}
	
	/**
	 * Retorna a representação do Contato armazenado na Agenda (na posição passada como parâmetro).
	 * 
	 * @param posicao A posição da Agenda em que se deseja buscar um Contato armazenado.
	 * @returns Uma String que represente o Contato armazenado nessa posição.
	 * 
	 */
	public String exibicaoContato(int posicao) {
		return this.cadastros[posicao - 1].toString();
	}
	
	/**
	 * Retorna um ArrayList de Strings. Essas Strings são as representações resumidas dos Contatos
	 * que estão armazenados na Agenda e seguem o padrão POSIÇÃO - NOME SOBRENOME.
	 * 
	 * @returns Um ArrayList de Strings contendo o resumo de todos os cadastros de Contatos da Agenda.
	 * 
	 */
	public ArrayList<String> listagemContatos() {
		ArrayList<String> listaContatos = new ArrayList<>();
		for (int i = 1; i < 101; i++) {
			if (validarContato(i)) {
				listaContatos.add(i + " - " + this.cadastros[i - 1].nomeCompleto());
			}
		}
		
		return listaContatos;
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
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Agenda other = (Agenda) obj;
		if (!this.listagemContatos().equals(other.listagemContatos()))
			return false;
		
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
		return "CONTATOS CADASTRADOS: " + this.listagemContatos();
	}

}